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
    /**
     * This method create instance for web driver depend on browser.
     *
     * @param browser Get element by.
     * @return Web driver instance.
     */
    private static WebDriver getDriver(String browser) throws Exception {
        return switch (browser.toUpperCase()) {
            case "CHROME" -> new Chrome().createDriver();
            case "FIREFOX" -> new Firefox().createDriver();
            case "EDGE" -> new Edge().createDriver();
            default -> throw new Exception("No browser found!");
        };
    }

    /**
     * This method get browser property and set implicit wait for driver.
     *
     * @return Web driver instance.
     */
    public static WebDriver driverInit() throws Exception {
        WebDriver driver = getDriver(PropertiesReader.getDriverFromPropertiesFile("browser"));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        return driver;
    }
}
