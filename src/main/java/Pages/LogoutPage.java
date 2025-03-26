package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	WebDriver driver;

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class=\"ico-logout\"]")
    WebElement logoutButton;

    @FindBy(xpath = "//a[@class='ico-login']")
    WebElement loginButton;

    public void clickLogout() {
        logoutButton.click();
    }

    public boolean isLoginButtonDisplayed() {
        return loginButton.isDisplayed();
    }
}
