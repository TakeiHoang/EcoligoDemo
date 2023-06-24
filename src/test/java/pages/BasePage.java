package pages;

import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected static ExtentTest test;

    public BasePage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        BasePage.test = test;
    }

    /**
     * This method performs get current url.
     */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * This method performs find element.
     *
     * @param by Get element by.
     * @return Web element.
     */
    public WebElement findElement(By by) {
        // Default timeout value of 5000 milliseconds
        return findElement(by, 5000);
    }

    /**
     * This method performs find element while waiting the element for a set of time before timeout.
     * Otherwise it will return immediately.
     *
     * @param by Get element by.
     * @param timeoutMillis the driver wait for set of time to be timeout.
     * @return Web element.
     */
    public WebElement findElement(By by, int timeoutMillis) {
        if (timeoutMillis > 0) {
            wait = new WebDriverWait(driver, Duration.ofMillis(timeoutMillis));
            return wait.until(drv -> drv.findElement(by));
        }
        return driver.findElement(by);
    }

    /**
     * This method performs find list of elements.
     *
     * @param by Get element by.
     * @return Web element.
     */
    public List<WebElement> findElements(By by) {
        // Default timeout value of 5000 milliseconds
        return findElements(by, 5000);
    }

    /**
     * This method performs find list of elements while waiting the element for a set of time before timeout.
     * Otherwise it will return immediately.
     *
     * @param by Get element by.
     * @param timeoutMillis the driver wait for set of time to be timeout.
     * @return Web element.
     */
    public List<WebElement> findElements(By by, int timeoutMillis) {
        if (timeoutMillis > 0) {
            wait = new WebDriverWait(driver, Duration.ofMillis(timeoutMillis));
            return wait.until((drv -> drv.findElements(by)));
        }
        return driver.findElements(by);
    }
}
