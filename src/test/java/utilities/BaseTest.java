package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;

public class BaseTest {
	
	protected AndroidDriver driver;
    protected WebDriverWait wait;
    //protected ExtentTest extentTest;
    public BaseTest(AndroidDriver driver/*ExtentTest extentTest*/) {
        this.driver = driver;
        //this.extentTest = extentTest;
       // PageFactory.initElements(driver, this);
    }

    public AndroidDriver getDriver() {
        return driver;
    }

	/*
	 * public ExtentTest getExtentTest() { return extentTest; }
	 */
    public void waitForElementVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickElement(WebElement element) {
        waitForElementVisible(element);
        element.click();
    }

}
