package tests;

import com.relevantcodes.extentreports.LogStatus;
import core.BaseTests;
import org.testng.annotations.Test;
import tests.data.LoginTestDataProvider;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTests extends BaseTests {
    private final LocalDateTime dateTime = LocalDateTime.now();
    private String testUserName = "testAccount";
    private final String testEmail = "test" + dateTime + "@gmail.com";
    private final String testPassword = generatePassword(8);

    @Test(description = "TC-01: Verify successful registration with valid inputs",
            groups = "RegressionTest")
    void registerWithValidFields() throws Exception {
        try {
            loginPage = homePage.navigateToLoginPage();
            registerPage = loginPage.navigateToRegisterPage(15000);
            registerPage.register(testUserName + dateTime, testEmail, testPassword, testPassword, 5000);
            registerPage.submitRegister(5000);

            // Validate that user successfully registration
            assertThat(myAccountPage.getCurrentUrl()).contains("/account");
            assertThat(myAccountPage.verifyIfUserLoggedIn(10000)).isTrue();
            test.log(LogStatus.PASS, "");
        } catch (Exception e) {
            test.log(LogStatus.FAIL, e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    @Test(description = "TC-02: Verify registration fails with an existing Username",
            groups = "RegressionTest")
    void registerWithDuplicateUsername() throws Exception {
        try {
            loginPage = homePage.navigateToLoginPage();
            registerPage = loginPage.navigateToRegisterPage(15000);
            registerPage.register(testUserName, testEmail, testPassword, testPassword, 5000);
            registerPage.submitRegister(5000);

            // Validate error message
            assertThat(registerPage.verifyErrorMessage(5000).toLowerCase())
                    .isEqualTo("is already taken");
            assertThat(registerPage.verifyInvalidTextBox(5000)).isTrue();
            test.log(LogStatus.PASS, "");
        } catch (Exception e) {
            test.log(LogStatus.FAIL, e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    @Test(description = "TC-03: Verify registration fails with an invalid Email",
            groups = "RegressionTest",
            dataProvider = "invalidEmailTestDataList", dataProviderClass = LoginTestDataProvider.class)
    void registerWithInvalidEmails(String email) throws Exception {
        try {
            // Generate unique user name
            testUserName += dateTime;
            // Action
            loginPage = homePage.navigateToLoginPage();
            registerPage = loginPage.navigateToRegisterPage(15000);
            registerPage.register(testUserName, email, testPassword, testPassword, 5000);
            registerPage.submitRegister(5000);

            // Validate message
            assertThat(registerPage.verifyErrorMessage(5000).toLowerCase())
                    .containsAnyOf("invalid input", "please fill in this field");
            assertThat(registerPage.verifyInvalidTextBox(5000)).isTrue();
            test.log(LogStatus.PASS, "");
        } catch (Exception e) {
            test.log(LogStatus.FAIL, e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    @Test(description = "TC-04: Verify registration fails with an invalid Password & Confirm Password",
            groups = "RegressionTest",
            dataProvider = "invalidPasswordTestDataList", dataProviderClass = LoginTestDataProvider.class)
    void registerWithInvalidPasswordAndConfirmPassword(String password) throws Exception {
        try {
            // Generate unique user name
            testUserName += dateTime;

            // Action
            loginPage = homePage.navigateToLoginPage();
            registerPage = loginPage.navigateToRegisterPage(15000);
            registerPage.register(testUserName, testEmail, password, password, 5000);
            registerPage.submitRegister(5000);

            // Validate error message and invalid text box
            List<String> errorMessages = registerPage.verifyListOfErrorMessages(5000);
            for (String text : errorMessages) {
                assertThat(text.toLowerCase()).containsAnyOf("invalid input", "please fill in this field",
                        "exceed characters limit", "minimum 8 characters");
            }
            List<Boolean> invalidTextBoxes = registerPage.verifyListOfInvalidTextBox(5000);
            for (Boolean bo : invalidTextBoxes) {
                assertThat(bo).isTrue();
            }
            test.log(LogStatus.PASS, "");
        } catch (Exception e) {
            test.log(LogStatus.FAIL, e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    @Test(description = "TC-05: Verify registration fails when Password and Confirm Password do not match",
            groups = "RegressionTest")
    void registerWithPasswordAndConfirmPasswordMismatch() throws Exception {
        try {
            // Generate unique user name
            testUserName += dateTime;

            // Action
            loginPage = homePage.navigateToLoginPage();
            registerPage = loginPage.navigateToRegisterPage(15000);
            registerPage.register(testUserName, testEmail, testPassword,
                    testPassword + dateTime, 5000);
            registerPage.submitRegister(5000);

            // Validate list of error messages and list of invalid text boxes
            List<String> errorMessages = registerPage.verifyListOfErrorMessages(5000);
            for (String text : errorMessages) {
                assertThat(text.toLowerCase()).contains("does not match");
            }
            List<Boolean> invalidTextBoxes = registerPage.verifyListOfInvalidTextBox(5000);
            for (Boolean bo : invalidTextBoxes) {
                assertThat(bo).isTrue();
            }
            test.log(LogStatus.PASS, "");
        } catch (Exception e) {
            test.log(LogStatus.FAIL, e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    @Test(description = "TC-06: Verify Password and Confirm Password are hidden",
            groups = "RegressionTest")
    void verifyThatPasswordAndConfirmPasswordIsHidden() throws Exception {
        try {
            // Generate unique user name
            testUserName += dateTime;

            // Action
            loginPage = homePage.navigateToLoginPage();
            registerPage = loginPage.navigateToRegisterPage(15000);
            registerPage.register(testUserName, testEmail, testPassword,
                    testPassword, 5000);

            // Validate password and confirm password are hidden
            assertThat(registerPage.getPasswordAndConfirmPasswordType(5000))
                    .contains("password");
            test.log(LogStatus.PASS, "");
        } catch (Exception e) {
            test.log(LogStatus.FAIL, e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    @Test(description = "TC-07: Verify registration fails with an invalid Username",
            groups = "RegressionTest",
            dataProvider = "usernameTestDataList", dataProviderClass = LoginTestDataProvider.class)
    void registerFailWithInvalidUsername(String userName) throws Exception {
        try {
            // Generate unique user name

            // Action
            loginPage = homePage.navigateToLoginPage();
            registerPage = loginPage.navigateToRegisterPage(15000);
            registerPage.register(userName, testEmail, testPassword,
                    testPassword, 5000);

            // Validate message
            assertThat(registerPage.verifyErrorMessage(5000).toLowerCase())
                    .containsAnyOf("invalid input", "please fill in this field");
            assertThat(registerPage.verifyInvalidTextBox(5000)).isTrue();
            test.log(LogStatus.PASS, "");
        } catch (Exception e) {
            test.log(LogStatus.FAIL, e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    @Test(description = "TC-08: Verify registration fails when the email is already registered",
            groups = "RegressionTest")
    void registerWithDuplicateEmail() throws Exception {
        try {
            String dupEmail = "test@gmail.com";
            // Action
            loginPage = homePage.navigateToLoginPage();
            registerPage = loginPage.navigateToRegisterPage(15000);
            registerPage.register(testUserName + dateTime, dupEmail, testPassword,
                    testPassword, 5000);

            // Validate error message
            assertThat(registerPage.verifyErrorMessage(5000).toLowerCase())
                    .isEqualTo("is already taken");
            assertThat(registerPage.verifyInvalidTextBox(5000)).isTrue();
            test.log(LogStatus.PASS, "");
        } catch (Exception e) {
            test.log(LogStatus.FAIL, e.getMessage());
            throw new Exception(e.getMessage());
        }
    }
}