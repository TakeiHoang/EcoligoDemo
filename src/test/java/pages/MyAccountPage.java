package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BasePage {

    public MyAccountPage(WebDriver driver) {
        super(driver);
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
            findElement(myAccountMenu, waitInMillis).isDisplayed();
            findElement(userName, waitInMillis).isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
