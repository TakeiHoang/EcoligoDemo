package pages;

import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BasePage {

    public MyAccountPage(WebDriver driver, ExtentTest test) {
        super(driver, test);
    }

    // Elements
    private final By myAccountMenu = By.id("Menu");
    private final By userName = By.id("Username");

    /**
     * This method verify user logged in after successfully register
     *
     * @param waitInMillis the driver wait for set of time to be timeout.
     * @return True/False.
     */
    public boolean verifyIfUserLoggedIn(int waitInMillis) {
        try {
            findElement(myAccountMenu).isDisplayed();
            findElement(userName).isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
