package utils;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Slf4j
public class ConfigReader {

   public static String getEndPoint(String name)
   {
       Properties properties = new Properties();
       try(FileInputStream fileInputStream = new FileInputStream("src/test/resources/endpoints.properties")) {
           properties.load(fileInputStream);

       } catch (IOException e) {
          log.info("End points file not found " + e);

       }
       return properties.getProperty(name);
   }

    public static String getJsonPath(String name) {
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/jsonpath.properties")) {
            properties.load(fileInputStream);

        } catch (IOException e) {
            log.info("Json path is not found " + e);

        }
        return properties.getProperty(name);
    }
}
