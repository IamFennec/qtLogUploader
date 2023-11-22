package qtlog.DPSReportController;

import qtlog.DataModel.ILogObserver;

import java.nio.file.Path;

public interface ILogUploader {
    public void uploadLog(Path fileInfo);

    public DpsReportDTO getLatestLogInfo();

    public void registerObs(ILogObserver observer);
}
