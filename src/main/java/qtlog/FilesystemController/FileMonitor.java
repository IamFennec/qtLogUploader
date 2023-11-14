package qtlog.FilesystemController;

import qtlog.DataModel.IFileObserver;
import qtlog.shared.FileDTO;

import java.nio.file.WatchService;
import java.nio.file.Path;

public class FileMonitor implements IFileMonitor, IFileObservable{
    IFileObserver observer;
    Path filepath;
    WatchService watchservice;
    FileDTO newestFile;

    @Override
    public void registerObs(IFileObserver observer) {
        this.observer = observer;
    }

    @Override
    public void notifyObserver() {
        this.observer.updateFileObserver();
    }

    @Override
    public FileDTO getFileInformation() {
        return newestFile;
    }

    @Override
    public void setFolderpath(String folderpath) {
        // TODO Auto-generated method stub
    }

    //example code, delete later
    public void setNewestFile(FileDTO newFile){
        this.newestFile = newFile;
        this.notifyObserver();
    }
    
}
