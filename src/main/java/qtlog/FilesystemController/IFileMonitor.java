package qtlog.FilesystemController;

import qtlog.DataModel.IFileObserver;

import java.nio.file.Path;

public interface IFileMonitor {
    public Path getFileInformation();

    public void registerObs(IFileObserver observer);
}
