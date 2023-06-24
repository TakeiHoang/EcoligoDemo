package core.helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    /**
     * This method get property browser value.
     *
     * @param propNames property name.
     * @return browser value.
     */
    public static String getDriverFromPropertiesFile(String propNames) {
        String browser = "";
        try (FileInputStream input = new FileInputStream(".\\test.properties")) {
            Properties prop = new Properties();

            prop.load(input);

            // get the property value and print it out
            browser = prop.getProperty(propNames);

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return browser;
    }

    /**
     * This method get property value in test.properties file except browser.
     *
     * @param propNames property name.
     * @return property value.
     */
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
