package Base;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks  extends BaseTest {
	
	@Before
	public void setUp() {
	    String browserName = DriverManager.getThreadBrowser();	    
	    OpenBrowser(browserName);
	    String Url = ConfigReader.getProperty("url");
	    getDriver().get(Url);
	}

	@After
	public void tearDown() {
	    closeBrowser();
	    DriverManager.clear();
	}
}
