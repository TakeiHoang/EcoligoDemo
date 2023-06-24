package core.browser.driver;

import core.browser.IDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome implements IDriver {
    private ChromeOptions options;

    private ChromeOptions getOptions() {
        if (options == null) {
            options = new ChromeOptions();
            //Set run as Headless
            options.setHeadless(false);
            options.addArguments("incognito");
            options.addArguments("--start-maximized");
            //Accept security warning
            options.setAcceptInsecureCerts(true);
        }
        return options;
    }

    @Override
    public WebDriver createDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
        return new ChromeDriver(getOptions());
    }
}
