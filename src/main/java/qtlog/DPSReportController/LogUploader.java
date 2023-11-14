package qtlog.DPSReportController;

import qtlog.DataModel.ILogObserver;
import qtlog.shared.FileDTO;
import qtlog.shared.LogDTO;

public class LogUploader implements ILogUploader, ILogObservable{
    private ILogObserver observer;
    private LogDTO latestLog;

    @Override
    public void registerObs(ILogObserver obs) {
        this.observer = obs;
    }

    @Override
    public void notifyObserver() {
        this.observer.updateLogObserver();
    }

    @Override
    public void uploadLog(FileDTO fileInfo) {
        //logupload functionality here, maybe call helper functions etc.
        //mock implementation
        LogDTO tempLog = new LogDTO("www.snowcrows.com", 100, true, 100, "Deimos", false);
        this.latestLog = tempLog;
        this.notifyObserver();
    }

    @Override
    public LogDTO getLatestLogInfo() {
        return latestLog;
    }
    
    //create more private helper functions if needed

}
