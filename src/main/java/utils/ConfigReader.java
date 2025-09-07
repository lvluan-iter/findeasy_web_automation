package utils;

import lombok.Getter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    @Getter
    private static final Properties properties;

    static {
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
            properties = new Properties();
            properties.load(fis);

        } catch (IOException e) {
            throw new RuntimeException("Could not load config.properties file.", e);
        }
    }

}
