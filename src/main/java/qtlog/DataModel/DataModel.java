package qtlog.DataModel;

import qtlog.DPSReportController.ILogUploader;
import qtlog.DiscordController.IDiscordController;
import qtlog.FilesystemController.IFileMonitor;
import qtlog.LogParser.ILogParser;
import qtlog.LogParser.LogParser;
import qtlog.UIController.IModelObserver;
import qtlog.shared.LogDTO;

import java.nio.file.Path;

public class DataModel implements IFileObserver, IDataModel, IModelObservable, ILogObserver {
    private IModelObserver observer;
    private LogDTO latestLog;
    private IFileMonitor fileService;
    private IDiscordController discordService;
    private ILogUploader logService;
    private ILogParser logParser;

    public DataModel(ILogUploader logUploader, IDiscordController discordController, IFileMonitor fileMonitor) {
        this.discordService = discordController;
        this.logService = logUploader;
        this.fileService = fileMonitor;
        this.logService.registerObs(this);
        this.fileService.registerObs(this);
        this.logParser = new LogParser();
    }

    // called when Log is finished uploading
    @Override
    public void updateLogObserver() {
        // code to process uploaded log i.e send to discord
        this.latestLog = this.logService.getLatestLogInfo();
        // this.discordService.sendMessage(latestLog);
        this.observer.updateModelObserver();
    }

    @Override
    public void registerObs(IModelObserver observer) {
        this.observer = observer;
    }

    @Override
    public LogDTO getLatestLog() {
        return latestLog;
    }

    // called when new log is found in directory
    @Override
    public void updateFileObserver() {
        // code to process newest file i.e. upload it
        Path tempFile = this.fileService.getFileInformation();
        this.logService.uploadLog(tempFile);
        this.logParser.readLog(tempFile);
    }

    @Override
    public void notifyObserver() {
        this.observer.updateModelObserver();
    }

}
