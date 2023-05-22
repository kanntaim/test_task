package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

    private static final String CONFIG_PROPERTIES = "config.properties";

    public static synchronized String getProperty(String key){
        try (InputStream propertiesStream = PropertiesUtil.class.getClassLoader().getResourceAsStream(CONFIG_PROPERTIES)){
            Properties properties = new Properties();
            properties.load(propertiesStream);
            return properties.getProperty(key);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
