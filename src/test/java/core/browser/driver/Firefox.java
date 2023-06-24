package core.browser.driver;

import core.browser.IDriver;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Firefox implements IDriver {
    private FirefoxOptions options;
    private DesiredCapabilities capabilities;

    private FirefoxOptions getOptions() {
        if (options == null) {
            options = new FirefoxOptions();
            options.setHeadless(false);
            options.addArguments("private");
            options.addArguments("--start-maximized");
            options.setAcceptInsecureCerts(true);
            options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS_AND_NOTIFY);
        }
        return options;
    }

    @Override
    public WebDriver createDriver() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/driver/geckodriver.exe");
        return new FirefoxDriver((getOptions()));
    }

    @Override
    public void setDriverOptions(Object options) {
        this.options = (FirefoxOptions) options;
    }
}
