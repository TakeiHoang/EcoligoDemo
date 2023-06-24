package core;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.*;

import java.security.SecureRandom;

public class BaseTests {
    protected static ExtentTest test;
    protected static ExtentReports report;
    protected WebDriver driver;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected RegisterPage registerPage;
    protected MyAccountPage myAccountPage;

    /*
    Set up reporter
     */
    @BeforeSuite
    protected void startReport() {
        report = new ExtentReports(".\\extent_report\\TestResults.html");
        test = report.startTest("ExtentReports");
    }

    /*
    Stop report and generate HTML file
     */
    @AfterSuite
    protected static void endTest() {
        report.endTest(test);
        report.flush();
        report.close();
    }

    /*
    Set up browser and navigate to home page
     */
    @BeforeMethod
    protected void setUp() throws Exception {
        driver = DriverManager.driverInit();
        homePage = new HomePage(driver, test);
        homePage = homePage.goToHomePage();
    }

    /*
    Quit and close all window of the browser
     */
    @AfterMethod
    protected void tearDown() {
        driver.quit();
    }

    private static final String UPPERCASE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE_CHARS = "abcdefghijklmnopqrstuvwxyz";
    private static final String SPECIAL_CHARS = "!@#$%^&*()";
    private static final String ALL_CHARS = UPPERCASE_CHARS + LOWERCASE_CHARS + SPECIAL_CHARS;

    /*
    Generate random password, include at least 1 Uppercase, 1 special char, and lower case
    @param length: Length of the password
     */
    public static String generatePassword(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);

        // Add at least one uppercase letter
        password.append(UPPERCASE_CHARS.charAt(random.nextInt(UPPERCASE_CHARS.length())));

        // Add at least one lowercase letter
        password.append(LOWERCASE_CHARS.charAt(random.nextInt(LOWERCASE_CHARS.length())));

        // Add at least one special character
        password.append(SPECIAL_CHARS.charAt(random.nextInt(SPECIAL_CHARS.length())));

        // Generate remaining characters
        for (int i = 3; i < length; i++) {
            password.append(ALL_CHARS.charAt(random.nextInt(ALL_CHARS.length())));
        }

        // Random characters
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(length);
            char temp = password.charAt(i);
            password.setCharAt(i, password.charAt(randomIndex));
            password.setCharAt(randomIndex, temp);
        }

        return password.toString();
    }
}
