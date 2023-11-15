package qtlog.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
    private static final String CONFIG_FILE = "src/main/resources/config.properties";

    public static String readLogPath() {
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream(CONFIG_FILE)) {
            properties.load(input);
            return properties.getProperty("logPath", "default");
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void writeLogPath(String newLogPath) {
        Properties properties = new Properties();
        properties.setProperty("logPath", newLogPath);
        try (FileOutputStream output = new FileOutputStream(CONFIG_FILE)) {
            properties.store(output, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
