package qtlog.DPSReportController;

import qtlog.DataModel.ILogObserver;
import qtlog.shared.LogDTO;

import java.nio.file.Path;

public interface ILogUploader {
    public void uploadLog(Path fileInfo);

    public LogDTO getLatestLogInfo();

    public void registerObs(ILogObserver observer);
}
