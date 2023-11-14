package qtlog.DPSReportController;

import qtlog.DataModel.ILogObserver;
import qtlog.shared.FileDTO;
import qtlog.shared.LogDTO;

public interface ILogUploader {
    public void uploadLog(FileDTO fileInfo);

    public LogDTO getLatestLogInfo();

    public void registerObs(ILogObserver observer);
}
