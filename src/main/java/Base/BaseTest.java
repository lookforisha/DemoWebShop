package Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	 public static void OpenBrowser(String browserName) {
		    WebDriver localDriver = null;

		    if (browserName.equalsIgnoreCase("chrome")) {
		        WebDriverManager.chromedriver().setup();
		        localDriver = new ChromeDriver();
		    } else if (browserName.equalsIgnoreCase("edge")) {
		        WebDriverManager.edgedriver().setup();
		        localDriver = new EdgeDriver();
		    } else {
		        throw new RuntimeException("Unsupported Browser");
		    }

		    localDriver.manage().window().maximize();
		    localDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		    driver.set(localDriver);
		}

	    public static WebDriver getDriver() {
	        return driver.get();
	    }

	    public static void closeBrowser() {
	        if (driver.get() != null) {
	            driver.get().quit();
	            driver.remove();
	        }
	    }
}
