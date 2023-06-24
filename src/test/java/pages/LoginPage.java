package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
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
        return new RegisterPage(driver);
    }
}
