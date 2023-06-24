package core.browser;

import org.openqa.selenium.WebDriver;

public interface IDriver {
    WebDriver createDriver();

    void setDriverOptions(Object options);
}
