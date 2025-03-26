package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "Email")
	WebElement EmailBox;

	@FindBy(id = "Password")
	WebElement PasswordBox;

	@FindBy(xpath = "//input[@type='submit' and @value='Log in']")
	WebElement LoginButton;

	@FindBy(xpath = "//div[@class='message-error']")
	WebElement errorMessage;

	@FindBy(css = ".header-links .account")
	WebElement loggedInUserEmail;

	public void EnterEmail(String str) {
		EmailBox.sendKeys(str);
	}

	public void EnterPassword(String pass) {
		PasswordBox.sendKeys(pass);
	}

	public void ClickLoginButton() {
		LoginButton.click();
	}

	public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }

    public boolean isUserEmailDisplayed(String expectedEmail) {
        return loggedInUserEmail.isDisplayed() && loggedInUserEmail.getText().trim().equals(expectedEmail);
    }
}
