package utilities;

//import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;

public class TestContext {
	
	private AndroidDriver driver;
   // private ExtentTest extentTest;

    public TestContext(AndroidDriver driver) {
        this.driver = driver;
        //this.extentTest = extentTest;
    }

    public AndroidDriver getDriver() {
        return driver;
    }

	/*
	 * public ExtentTest getExtentTest() { return extentTest; }
	 */

}
