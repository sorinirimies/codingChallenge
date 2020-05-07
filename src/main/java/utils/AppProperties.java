package utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class AppProperties {
    private static final String PROPERTIES_FILENAME = "app.properties";
    private static Properties properties = null;

public static void initAppProperties(){
        properties = new Properties();
        String pathToProperties = Objects.requireNonNull(AppProperties.class.getClassLoader().getResource(PROPERTIES_FILENAME)).getFile();

        try (FileReader fr = new FileReader(pathToProperties)) {
            properties.load(fr);
        } catch (IOException e) {
            throw new RuntimeException("Could not init properties from path!", e);
        }
    }


    public static String getAppName(){ return properties.getProperty("app"); }

    public static String getApk(){ return (new File(properties.getProperty("apk")).getAbsolutePath());}
}
