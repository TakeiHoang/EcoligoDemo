package pages;

import com.relevantcodes.extentreports.ExtentTest;
import core.helper.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver, ExtentTest test) {
        super(driver, test);
    }

    // Elements
    private final By loginLink = By.cssSelector(".login-btn-wrap .login");

    /**
     * This method performs navigate to Home Page.
     *
     * @return Home Page instance.
     */
    public HomePage goToHomePage() throws IOException {
        String url = PropertiesReader.getPropName("baseUrl");
        driver.navigate().to(url);
        return new HomePage(driver, test);
    }

    /**
     * This method performs navigate to Login Page.
     *
     * @return Login Page instance.
     */
    public LoginPage navigateToLoginPage() {
        findElement(loginLink).click();
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        return new LoginPage(driver, test);
    }
}
