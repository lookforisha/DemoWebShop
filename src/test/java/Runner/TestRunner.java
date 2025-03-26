package Runner;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import Base.DriverManager;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/resources/features/demowebshop.feature",
	    glue = {"StepsDefinition", "Base"},
	    plugin = {"pretty","html:target/DemoWebShop.html"}
	) 

public class TestRunner extends AbstractTestNGCucumberTests {
	
	@BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void setBrowser(@Optional String browser) {
        String browserName;

        if (System.getProperty("browser") != null) {
            browserName = System.getProperty("browser");
        } else if (browser != null) {
            browserName = browser;
        } else {
            browserName = "chrome";
        }
        DriverManager.setThreadBrowser(browserName);
    }
}
