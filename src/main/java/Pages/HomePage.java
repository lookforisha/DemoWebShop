package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class=\"ico-login\"]")
	WebElement Login;
	
	@FindBy(xpath="//a[@class=\"account\"]")
	WebElement loggedInUserEmail;

	public void clickLogin() {
		Login.click();
	}

	public boolean isUserLoggedIn() {
		return loggedInUserEmail.isDisplayed();
	}
}
