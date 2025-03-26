package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='ico-register']")
	WebElement register;
	
	@FindBy(xpath="//input[@id=\"gender-female\"]")
	WebElement gender;
	
	@FindBy(id="FirstName")
	WebElement fname;
	
	@FindBy(id="LastName")
	WebElement lname;

	@FindBy(id="Email")
	WebElement email;
	
	@FindBy(id="Password")
	WebElement password;
	
	@FindBy(id="ConfirmPassword")
	WebElement confirmpassword;
	
	@FindBy(id="register-button")
	WebElement registerButton;
	
	@FindBy(xpath="//div[@class=\"result\"]")
	WebElement message;
	
	@FindBy(xpath="//input[@type=\"button\" and @value=\"Continue\"]")
	WebElement cont;
	
	@FindBy(xpath="//div[@class=\"validation-summary-errors\"]")
	WebElement error;
	
	public void clickRegister() {
		register.click();
	}
	
	public void selectGender() {
		gender.click();
	}
	
	public void enterFirstName(String FirstName) {
		fname.sendKeys(FirstName);
	}

	public void enterLastName(String LastName) {
		lname.sendKeys(LastName);
	}
	
	public void enterEmail() {
        String dynamicEmail = "user" + System.currentTimeMillis() + "@example.com";
        email.sendKeys(dynamicEmail);
    }
	
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void enterConfirmPassword(String cpass) {
		confirmpassword.sendKeys(cpass);
	}
	
	public void clickRegisterButton() {
		registerButton.click();
	}
	
	public String isMessageText() {
        return message.getText();
    }

	public void clickContinue() {
		cont.click();		
	}

	public String getErrorMsg() {
        return error.getText();
    }

	public void enterExistEmail(String str) {
		email.sendKeys(str);
	}
}
