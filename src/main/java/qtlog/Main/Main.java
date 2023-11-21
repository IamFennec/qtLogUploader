package qtlog.Main;

import java.util.Scanner;

import qtlog.DPSReportController.LogUploader;
import qtlog.DataModel.DataModel;
import qtlog.DiscordController.DiscordController;
import qtlog.FilesystemController.FileMonitor;
import qtlog.UIController.UIController;
import qtlog.UserInterface.UserInterface;
import qtlog.util.ConfigManager;

public class Main {
    public static void main(String[] args) {
        start();
    }

    public static void start() {
        // Get Log Folder Path on first startup
        String folderPath = ConfigManager.readLogPath();
        Scanner scanner = new Scanner(System.in);

        if (folderPath.isEmpty()) {
            System.out.println("Enter logpath plsssss: ");
            String userInput = scanner.nextLine();
            ConfigManager.writeLogPath(userInput);
        }

        // Get webhook on first startup
        String webhook = ConfigManager.readWebhook();

        if (webhook.isEmpty()) {
            System.out.println("Enter webhook url: ");
            String userInput = scanner.nextLine();
            scanner.close();
            ConfigManager.writeWebhook(userInput);
        }

        // init
        FileMonitor fileMonitor = new FileMonitor();
        LogUploader logUploader = new LogUploader();
        DiscordController discordController = new DiscordController();
        DataModel dataModel = new DataModel(logUploader, discordController, fileMonitor);
        UserInterface userInterface = new UserInterface();
        UIController uiController = new UIController(dataModel, userInterface);

        // Start FileMonitor in a new Thread
        Thread fileMonitorThread = new Thread(fileMonitor);
        fileMonitorThread.start();

        while (true) {

        }

    }
}