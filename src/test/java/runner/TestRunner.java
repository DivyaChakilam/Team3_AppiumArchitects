package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
	    features = "src/test/resources/features",
	    glue = {"com.numpyninja.AppiumArchitects.stepDefinitions", "hooks"},
	    plugin = {
	        "pretty",
	        "html:target/cucumber-reports/Cucumber.html",
	        "json:target/cucumber-reports/Cucumber.json",
	        "junit:target/cucumber-reports/Cucumber.xml"
	    },
	    monochrome = true
	)
	public class TestRunner extends AbstractTestNGCucumberTests {

	    @Override
	    @DataProvider(parallel = true)
	    public Object[][] scenarios() {
	        return super.scenarios();
	    }
}