package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@value=\"Add to cart\"]")
	WebElement AddCart;
	
	@FindBy(xpath = "//input[@name='discountcouponcode']")
	WebElement couponField;
	
	@FindBy(xpath = "//input[@name='applydiscountcouponcode']")
	WebElement applyButton;
	
	@FindBy(xpath = "//div[@class='message']")
	WebElement message;
	
	@FindBy(xpath = "//input[@id=\"termsofservice\"]")
	WebElement terms;
	
	@FindBy(xpath = "//button[@id=\"checkout\"]")
	WebElement checkout;
	
	@FindBy(xpath = "//input[@value=\"Checkout as Guest\"]")
	WebElement asGuest;
	
	@FindBy(xpath = "//input[@id=\"BillingNewAddress_FirstName\"]")
	WebElement fname;
	
	@FindBy(xpath = "//input[@id=\"BillingNewAddress_LastName\"]")
	WebElement lname;
	
	@FindBy(xpath = "//input[@id=\"BillingNewAddress_Email\"]")
	WebElement email;

	@FindBy(xpath = "//select[@id=\"BillingNewAddress_CountryId\"]")
	WebElement countryDD;
	
	@FindBy(xpath = "//input[@name=\"BillingNewAddress.City\"]")
	WebElement city;
	
	@FindBy(xpath = "//input[@name=\"BillingNewAddress.Address1\"]")
	WebElement address;
	
	@FindBy(xpath = "//input[@id=\"BillingNewAddress_ZipPostalCode\"]")
	WebElement zip;
	
	@FindBy(xpath = "//input[@id=\"BillingNewAddress_PhoneNumber\"]")
	WebElement phone;
	
	@FindBy(xpath = "//input[@class=\"button-1 new-address-next-step-button\"]")
	WebElement cont;
	
	@FindBy(xpath = "//span[@class='field-validation-error']")
	WebElement error;
	
	@FindBy(xpath = "//input[@class=\"button-1 new-address-next-step-button\" and @onclick=\"Shipping.save()\"]")
	WebElement cont2;
	
	@FindBy(xpath = "//input[@class=\"button-1 shipping-method-next-step-button\"]")
	WebElement cont3;
	
	@FindBy(xpath ="//input[@onclick=\"PaymentMethod.save()\"]")
	WebElement cont4;

	@FindBy(xpath ="//input[@onclick=\"PaymentInfo.save()\"]")
	WebElement cont5;
	
	@FindBy(xpath ="//input[@value=\"Confirm\"]")
	WebElement confirm;

	@FindBy(xpath ="//div[@class=\"title\"]/strong")
	WebElement confirmMsg;
	
	public void AddToCart() {
		AddCart.click();
	}
	
	public void enterCouponCode(String code) {	   
	    couponField.sendKeys(code);
	}

	public void applyCoupon() {
	    applyButton.click();
	}

	public String getCouponMessage() {
	    return message.getText();
	}

	public boolean isCouponApplied() {
		return false;
	}
	
	public void clickTerms() {
	    terms.click();
	}
	
	public void clickCheckout() {
	    checkout.click();
	}
	
	public void clickAsGuest() {
	    asGuest.click();
	}
	
	public void enterFname(String str) {
		fname.clear();	
	    fname.sendKeys(str);
	}
	
	public void enterLname(String str) {
		lname.clear();
	    lname.sendKeys(str);
	}
	
	public void enterEmail(String str) {
		email.clear();
	    email.sendKeys(str);
	}
	
	public void selectFromDropdown(String countryName) {
        Select s = new Select(countryDD);
        s.selectByVisibleText(countryName);
    }
	
	public void enterCity(String str) {	
		city.clear();
	    city.sendKeys(str);
	}
	
	public void enterAddress(String str) {
		address.clear();
	    address.sendKeys(str);
	}
	
	public void enterZip(String str) {
		zip.clear();
	    zip.sendKeys(str);
	}
	
	public void enterPhone(String str) {
		phone.clear();
	    phone.sendKeys(str);
	}
	
	public void clickContinue() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(cont)).click();
	}

	public String getMessage() {
		return error.getText();
	}

	public void clickAddressContinue() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(cont2)).click();
	}

	public void clickShippingContinue() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(cont3)).click();
	}

	public void clickPaymentContinue() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(cont4)).click();
	}

	public void clickPaymentInfoContinue() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(cont5)).click();
	}

	public void clickConfirm() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(confirm)).click();
	}

	public String getSuccessMessage() {
		return confirmMsg.getText();
	}
	
}
