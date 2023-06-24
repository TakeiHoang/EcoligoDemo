package core.helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    public static String getDriverFromPropertiesFile(String propertyName) throws IOException {
        String browser = "";
        try (FileInputStream input = new FileInputStream(".\\test.properties")) {
            Properties prop = new Properties();

            prop.load(input);

            // get the property value and print it out
            browser = prop.getProperty(propertyName);

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return browser;
    }

    public static String getPropName(String propNames) throws IOException {
        String value = "";
        try (FileInputStream input = new FileInputStream(".\\test.properties")) {
            Properties prop = new Properties();

            prop.load(input);

            // get the property value and print it out
            value = prop.getProperty(propNames);

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return value;
    }
}
