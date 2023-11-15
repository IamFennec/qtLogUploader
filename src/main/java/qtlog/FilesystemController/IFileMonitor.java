package qtlog.FilesystemController;

import qtlog.DataModel.IFileObserver;
import qtlog.shared.FileDTO;

public interface IFileMonitor {
    public FileDTO getFileInformation();

    public void registerObs(IFileObserver observer);
}
