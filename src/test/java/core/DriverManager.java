package core;

import core.browser.driver.Chrome;
import core.browser.driver.Edge;
import core.browser.driver.Firefox;
import core.helper.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class DriverManager {
    private static WebDriver getDriver(String browser) throws Exception {
        return switch (browser.toUpperCase()) {
            case "CHROME" -> new Chrome().createDriver();
            case "FIREFOX" -> new Firefox().createDriver();
            case "EDGE" -> new Edge().createDriver();
            default -> throw new Exception("No browser found!");
        };
    }

    public static WebDriver driverInit() throws Exception {
        WebDriver driver = getDriver(PropertiesReader.getDriverFromPropertiesFile("browser"));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        return driver;
    }
}
