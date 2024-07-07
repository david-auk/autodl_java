package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    String fileName;

    public Config(String fileName) {
        this.fileName = fileName;
    }

    public String get(String key) {
        Properties properties = new Properties();
        InputStream input = Config.class.getClassLoader().getResourceAsStream(fileName);
        if (input == null) {
            return null;
        }
        try {
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties.getProperty(key);
    }
}