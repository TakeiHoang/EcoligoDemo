package core.browser.driver;

import core.browser.IDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Edge implements IDriver {
    private EdgeOptions options;

    private EdgeOptions getOptions() {
        if (options == null) {
            options = new EdgeOptions();
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
        System.setProperty("webdriver.edge.driver", "src/test/resources/driver/msedgedriver.exe");
        return new EdgeDriver(getOptions());
    }

    @Override
    public void setDriverOptions(Object options) {
        this.options = (EdgeOptions) options;
    }
}
