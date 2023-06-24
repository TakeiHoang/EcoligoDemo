package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    // Elements
    private final By usernameText = By.id("investor_username");
    private final By emailText = By.id("investor_email");
    private final By passwordText = By.id("investor_password");
    private final By confirmPasswordText = By.id("investor_confirm_password");
    private final By registerButton = By.id("register_button");
    private final By errorMessageText = By.className("invalid-feedback");
    private final By invalidTextBox = By.xpath("//*[@aria-invalid='true']");

    /**
     * This method performs type user registration.
     *
     * @param userName        user name.
     * @param email           user email.
     * @param passWord        password.
     * @param confirmPassword confirm password.
     * @param waitForMillis   the driver wait for set of time to be timeout.
     */
    public void register(String userName, String email, String passWord,
                         String confirmPassword, int waitForMillis) {
        findElement(usernameText, waitForMillis).sendKeys(userName);
        findElement(emailText, waitForMillis).sendKeys(email);
        findElement(passwordText, waitForMillis).sendKeys(passWord);
        findElement(confirmPasswordText, waitForMillis).sendKeys(confirmPassword);
    }

    /**
     * This method performs submit registration.
     *
     * @param waitForMillis the driver wait for set of time to be timeout.
     * @return My Account Page instance.
     */
    public MyAccountPage submitRegister(int waitForMillis) {
        findElement(registerButton, waitForMillis).click();
        return new MyAccountPage(driver);
    }

    /**
     * This method get password and confirm password type.
     *
     * @param waitForMillis the driver wait for set of time to be timeout.
     * @return List string
     */
    public List<String> getPasswordAndConfirmPasswordType(int waitForMillis) {
        List<String> type = null;
        type.add(findElement(passwordText, waitForMillis).getAttribute("type"));
        type.add(findElement(confirmPasswordText, waitForMillis).getAttribute("type"));
        return type;
    }

    /**
     * This method verify error message for register forms.
     *
     * @param waitInMillis the driver wait for set of time to be timeout.
     * @return Error message.
     */
    public String verifyErrorMessage(int waitInMillis) throws Exception {
        try {
            String errorMessage = findElement(errorMessageText, waitInMillis).getText();
            return errorMessage;
        } catch (Exception e) {
            throw new Exception("Unable to get error message!");
        }
    }

    /**
     * This method verify list of error messages for register forms.
     *
     * @param waitInMillis the driver wait for set of time to be timeout.
     * @return List of error messages.
     */
    public List<String> verifyListOfErrorMessages(int waitInMillis) throws Exception {
        try {
            List<String> listOfMessage = null;
            List<WebElement> listOfElements = findElements(errorMessageText, waitInMillis);
            for (WebElement e : listOfElements) {
                listOfMessage.add(e.getText());
            }
            return listOfMessage;
        } catch (Exception e) {
            throw new Exception("Unable to get error message!");
        }
    }

    /**
     * This method verify invalid text box for register forms.
     *
     * @param waitInMillis the driver wait for set of time to be timeout.
     * @return True/False.
     */
    public Boolean verifyInvalidTextBox(int waitInMillis) {
        try {
            return findElement(invalidTextBox, waitInMillis).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * This method verify list of invalid text box for register forms.
     *
     * @param waitInMillis the driver wait for set of time to be timeout.
     * @return List of True/False.
     */
    public List<Boolean> verifyListOfInvalidTextBox(int waitInMillis) throws Exception {
        try {
            List<Boolean> listOfBool = null;
            List<WebElement> listOfElements = findElements(invalidTextBox, waitInMillis);
            for (WebElement e : listOfElements) {
                listOfBool.add(e.isDisplayed());
            }
            return listOfBool;
        } catch (Exception e) {
            throw new Exception("Unable to get error text box!");
        }
    }
}
