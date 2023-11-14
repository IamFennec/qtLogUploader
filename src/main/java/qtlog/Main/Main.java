package qtlog.Main;

import javax.swing.UIClientPropertyKey;

import qtlog.DPSReportController.LogUploader;
import qtlog.DataModel.DataModel;
import qtlog.DiscordController.DiscordController;
import qtlog.FilesystemController.FileMonitor;
import qtlog.UIController.UIController;
import qtlog.UserInterface.UserInterface;
import qtlog.shared.FileDTO;

public class Main {
    public static void main(String[] args) {
        start();
    }

    public static void start(){
        FileMonitor fileMonitor = new FileMonitor();
        LogUploader logUploader = new LogUploader();
        DiscordController discordController = new DiscordController();
        DataModel dataModel = new DataModel(logUploader, discordController, fileMonitor);
        UserInterface userInterface = new UserInterface();
        UIController uiController = new UIController(dataModel, userInterface);

        //example to test flow of the program
        FileDTO newFile = new FileDTO("example File", "/path/to/file");
        fileMonitor.setNewestFile(newFile);
    }
}