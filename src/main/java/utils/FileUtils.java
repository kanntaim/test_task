package utils;

import java.io.File;

public class FileUtils {
    public static File getTestDataFile(String fileName){
        return new File(PropertiesUtil.getProperty("test_data_path") + fileName);
    }
}
