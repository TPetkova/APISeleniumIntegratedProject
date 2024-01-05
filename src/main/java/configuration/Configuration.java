package configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
    static String appConfigPath = "app.settings";
    private static Properties Settings = new Properties();
    static {
        loadProperties(appConfigPath);
    }

    private static void loadProperties(String fileName) {
        try (InputStream input = Configuration.class.getClassLoader().getResourceAsStream(fileName)) {
            if (input != null) {
                Settings.load(input);
            } else  {
                throw new RuntimeException("Cannot load file" + fileName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String propertyName) {
        return Settings.getProperty(propertyName);
    }
}
