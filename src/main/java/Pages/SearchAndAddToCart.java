package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchAndAddToCart {
	WebDriver driver;

	public SearchAndAddToCart(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@id='small-searchterms']")
	WebElement SearchBox;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement Button;
	
	@FindBy(xpath="//h2[@class='product-title']")
	WebElement product;
	
	@FindBy(xpath = "//h2[@class=\"product-title\"][1]")
	WebElement firstproduct;
	
	@FindBy(xpath="//h2[@class='product-title']")
	WebElement secondproduct;
	
	@FindBy(xpath="//input[@value='Add to cart']")
	WebElement AddToCart;
	
	@FindBy(xpath="//input[@id=\"add-to-cart-button-13\"]")
	WebElement firstAddToCart;
	
	@FindBy(xpath="//input[@class=\"button-1 add-to-cart-button\"]")
	WebElement secondAddToCart;
	
	@FindBy(xpath="//p[@class=\"content\"]")
	WebElement SuccessMessage;

	@FindBy(css="li#topcartlink")
	WebElement CartIcon;
	
	@FindBy(xpath="(//a[@class=\"product-name\"])[1]")
	WebElement firstProductTitle;

	@FindBy(xpath="(//a[@class=\"product-name\"])[2]")
	WebElement secondProductTitle;
	
	@FindBy(xpath="//span[@class=\"product-price order-total\"]")
	WebElement totalPrice;
	

	public void searchProduct(String str) {
		SearchBox.sendKeys(str);
	}

	public void clickSearchButton() {
		Button.click();
	}
	
	public void clickProduct() {
		product.click();
	}
	
	public void clickAddToCartButton() {
		AddToCart.click();
	}
	
	public String isSuccessMessageText() {
        return SuccessMessage.getText();
    }

	public void clickFirstProduct() {
		firstproduct.click();
	}

	public void clickAddToCartButtonFirst() {
		firstAddToCart.click();
		
	}
	
	public void clickSecondProduct() {
		secondproduct.click();
	}

	public void clickAddToCartButtonSecond() {
		secondAddToCart.click();		
	}
	
	public void cartIcon() {
		CartIcon.click();		
	}

	public String getFirstProductTitle() {
		return firstProductTitle.getText();
	}

	public String getSecondProductTitle() {
		return secondProductTitle.getText();
	}

	public String getTotalPrice() {
		return totalPrice.getText();
	}	
}
