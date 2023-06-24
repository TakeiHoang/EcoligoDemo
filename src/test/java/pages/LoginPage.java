package pages;

import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver, ExtentTest test) {
        super(driver, test);
    }

    // Elements
    private final By registerLink = By.cssSelector("a[href='/investor/registration']");

    /**
     * This method performs navigate to Register Page.
     *
     * @param waitInMillis the driver wait for set of time to be timeout.
     * @return Register Page instance.
     */
    public RegisterPage navigateToRegisterPage(int waitInMillis) {
        findElement(registerLink, waitInMillis).click();
        return new RegisterPage(driver, test);
    }
}
