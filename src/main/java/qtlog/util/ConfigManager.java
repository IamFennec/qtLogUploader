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
            return properties.getProperty("logPath", "");
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void writeLogPath(String newLogPath) {
        Properties properties = loadProperties();
        properties.setProperty("logPath", newLogPath);
        saveProperties(properties);
    }

    public static void writeWebhook(String webhook) {
        Properties properties = loadProperties();
        properties.setProperty("webhook", webhook);
        saveProperties(properties);
    }

    private static Properties loadProperties() {
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream(CONFIG_FILE)) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    private static void saveProperties(Properties properties) {
        try (FileOutputStream output = new FileOutputStream(CONFIG_FILE)) {
            properties.store(output, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readWebhook() {
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream(CONFIG_FILE)) {
            properties.load(input);
            return properties.getProperty("webhook", "");
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
