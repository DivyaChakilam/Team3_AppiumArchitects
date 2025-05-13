package hooks;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.ConfigReader;
import utilities.LogUtil;
import utilities.TestContext;

public class Hooks {
	
	private AndroidDriver driver;
    private TestContext testContext;

    @Before
    public void setUp(Scenario scenario) throws MalformedURLException, URISyntaxException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName(ConfigReader.getProperty("platformName"));
        options.setDeviceName(ConfigReader.getProperty("deviceName"));
        options.setAutomationName(ConfigReader.getProperty("automationName"));
        options.setAppPackage(ConfigReader.getProperty("appPackage"));
        options.setAppActivity(ConfigReader.getProperty("appActivity"));
        options.setCapability("uiautomator2ServerInstallTimeout", 60000);
        options.setApp(System.getProperty("user.dir") + "/" + ConfigReader.getProperty("appPath"));
        System.out.println("App Path: " + System.getProperty("user.dir") + "/" + ConfigReader.getProperty("appPath"));
        //driver = new AndroidDriver(new URI(ConfigReader.getProperty("appiumServerURL")).toURL(), options);
        //String appiumServerURL = "http://127.0.0.1:4723/wd/hub";
        //driver = new AndroidDriver(new URL(appiumServerURL), capabilities);
        
      

        // Using AppiumServiceBuilder
        AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withArgument(GeneralServerFlag.RELAXED_SECURITY);

        driver = new AndroidDriver(serviceBuilder, options);
        testContext = new TestContext(driver);
        // PicoContainer will automatically inject testContext into step definitions
        LogUtil.info("Test started: " + scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            //ScreenshotUtil.attachScreenshotToScenario(scenario, driver);
            LogUtil.error("Test failed: " + scenario.getName(), null);
        }
        if(driver!=null) {
        driver.quit();
        }
       // ExtentReportManager.flushReports();
        LogUtil.info("Test finished: " + scenario.getName());
    }

}
