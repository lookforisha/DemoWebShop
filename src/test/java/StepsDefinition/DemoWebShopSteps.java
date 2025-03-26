package StepsDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Base.BaseTest;
import Base.ConfigReader;
import Pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DemoWebShopSteps {
	WebDriver driver;
	HomePage hp;
	LoginPage lp;
	RegistrationPage rp;
	LogoutPage logoutPage;
	SearchAndAddToCart sa;
	CheckoutPage cp;

	String username = ConfigReader.getProperty("username");
	String password = ConfigReader.getProperty("password");

	public DemoWebShopSteps() {
		WebDriver driver = BaseTest.getDriver();
		hp = new HomePage(driver);
		lp = new LoginPage(driver);
		rp = new RegistrationPage(driver);
		logoutPage = new LogoutPage(driver);
		sa = new SearchAndAddToCart(driver);
		cp = new CheckoutPage(driver);
	}

	@Given("User is on the registration page")
	public void user_is_on_the_registration_page() {
		driver = BaseTest.getDriver();
		rp = new RegistrationPage(driver);
		rp.clickRegister();
	}

	@When("User enters invalid details in the form")
	public void user_enters_invalid_details_in_the_form() {
		rp.selectGender();
		rp.enterFirstName("New");
		rp.enterLastName("User");
		rp.enterExistEmail("abcd@eg.com");
		rp.enterPassword("NewPassword123");
		rp.enterConfirmPassword("NewPassword123");
	}

	@When("User click the register")
	public void user_click_the_register() {
		rp.clickRegisterButton();
	}

	@Then("Error message is displayed")
	public void error_message_is_displayed() {
		String Message = rp.getErrorMsg();
		System.out.println(Message);
	}

	@When("User enters valid details in the form")
	public void user_enters_valid_details_in_the_form() {
		rp.selectGender();
		rp.enterFirstName("New");
		rp.enterLastName("User");
		rp.enterEmail();
		rp.enterPassword("NewPassword123");
		rp.enterConfirmPassword("NewPassword123");
	}

	@Then("{string} message is displayed")
	public void message_is_displayed(String expectedMessage) {
		String actualMessage = rp.isMessageText();
		System.out.println("Expected: " + expectedMessage);
		System.out.println("Actual: " + actualMessage);
		Assert.assertEquals(actualMessage, expectedMessage, "Registration message mismatch!");
		rp.clickContinue();
	}

	@Given("User is on home page")
	public void user_is_on_home_page() {
		driver = BaseTest.getDriver();
		hp = new HomePage(driver);
		lp = new LoginPage(driver);
		hp.clickLogin();
	}

	@When("User enters {string} and {string}")
	public void user_enters_credentials(String email, String password) {
		lp.EnterEmail(email);
		lp.EnterPassword(password);
		lp.ClickLoginButton();
	}

	@Then("{string} is displayed")
	public void verify_message_displayed(String expectedMessage) {
		if (expectedMessage.equalsIgnoreCase("The credentials provided are incorrect")) {
			boolean isErrorDisplayed = lp.isErrorMessageDisplayed();
			Assert.assertTrue(isErrorDisplayed, "Error message was not displayed!");
			if (isErrorDisplayed) {
				System.out.println("Test Passed: Error message is correctly displayed for invalid credentials.");
			} else {
				System.out.println("Test Failed: Error message is missing for invalid credentials.");
			}
		} else if (expectedMessage.equalsIgnoreCase("User Email Displayed")) {
			boolean isEmailDisplayed = lp.isUserEmailDisplayed("testfunctionality@example.com");
			Assert.assertTrue(isEmailDisplayed, "User email is not displayed after login!");
			if (isEmailDisplayed) {
				System.out.println("Test Passed: User successfully logged in, and email is displayed.");
			} else {
				System.out.println("Test Failed: User email is not visible after login.");
			}
		}
	}

	@Given("User is logged in")
	public void user_is_logged_in() {
		hp.clickLogin();
		lp.EnterEmail(username);
		lp.EnterPassword(password);
		lp.ClickLoginButton();
	}

	@When("User clicks on the logout button")
	public void user_clicks_on_the_logout_button() {
		driver = BaseTest.getDriver();
		logoutPage = new LogoutPage(driver);
		logoutPage.clickLogout();
	}

	@Then("User is logged out and sees the login button")
	public void user_is_logged_out_and_sees_the_login_button() {
		boolean isLoginVisible = logoutPage.isLoginButtonDisplayed();
		Assert.assertTrue(isLoginVisible, "Login button is not visible after logout!");
		if (isLoginVisible) {
			System.out.println("Test Passed: User successfully logged out and login button is visible.");
		} else {
			System.out.println("Test Failed: Logout was not successful.");
		}
	}

	@Given("User is on the homepage")
	public void user_is_on_the_homepage() {
		System.out.println("HomePage");
	}

	@When("User search for a product")
	public void user_search_for_a_product() {
		driver = BaseTest.getDriver();
		sa = new SearchAndAddToCart(driver);
		sa.searchProduct("14.1-inch Laptop");
	}

	@When("clicks the search button")
	public void clicks_the_search_button() {
		sa.clickSearchButton();
	}

	@When("clicks on the product from the search results")
	public void clicks_on_the_product_from_the_search_results() {
		sa.clickProduct();
	}

	@When("clicks the Add to Cart button")
	public void clicks_the_add_to_cart_button() {
		sa.clickAddToCartButton();

	}

	@Then("{string} message should be displayed")
	public void message_should_be_displayed(String expectedMessage) {
		String actualMessage = sa.isSuccessMessageText();
		System.out.println("Expected: " + expectedMessage);
		System.out.println("Actual: " + actualMessage);
		Assert.assertEquals(actualMessage, expectedMessage, "Product is not addedd");
	}

	@When("User searches for the first product and adds it to the cart")
	public void user_searches_for_the_first_product_and_adds_it_to_the_cart() {
		driver = BaseTest.getDriver();
		sa = new SearchAndAddToCart(driver);
		sa.searchProduct("Computing and Internet");
		sa.clickSearchButton();
		sa.clickFirstProduct();
		sa.clickAddToCartButtonFirst();
	}

	@When("User searches for the second product and adds it to the cart")
	public void user_searches_for_the_second_product_and_adds_it_to_the_cart() {
		sa.searchProduct("Black & White Diamond Heart");
		sa.clickSearchButton();
		sa.clickSecondProduct();
		sa.clickAddToCartButtonSecond();
	}

	@When("User navigates to the cart page")
	public void user_navigates_to_the_cart_page() {
		sa.cartIcon();
	}

	@Then("Both products should be displayed in the cart")
	public void both_products_should_be_displayed_in_the_cart() {
		String expectedFirstProduct = "Computing and Internet";
		String expectedSecondProduct = "Black & White Diamond Heart";
		String actualFirstProduct = sa.getFirstProductTitle().trim();
		String actualSecondProduct = sa.getSecondProductTitle().trim();
		Assert.assertEquals(actualFirstProduct, expectedFirstProduct, "First product title does not match");
		System.out.println("First product title matched.");
		Assert.assertEquals(actualSecondProduct, expectedSecondProduct, "Second product title does not match");
		System.out.println("Second product title matched.");
	}

	@Then("Total price should be displayed")
	public void total_price_should_be_displayed() {
		String expectedTotalPrice = "140.00";
		String actualTotalPrice = sa.getTotalPrice();
		Assert.assertEquals(actualTotalPrice, expectedTotalPrice, "Total price does not match");
		System.out.println("Total price matched.");
	}

	@Given("User adds a product to the cart")
	public void user_adds_a_product_to_the_cart() {
		driver = BaseTest.getDriver();
		cp = new CheckoutPage(driver);
		sa.searchProduct("Computing and Internet");
		sa.clickSearchButton();
		cp.AddToCart();
	}

	@Given("User navigates to the checkout page")
	public void user_navigates_to_the_checkout_page() {
		sa.cartIcon();
	}

	@When("User enters a coupon code")
	public void user_enters_a_coupon_code() {
		cp.enterCouponCode("DISCOUNT10");
		cp.applyCoupon();
	}

	@Then("User should be able to see whether the coupon is applied or not")
	public void user_should_be_able_to_see_whether_the_coupon_is_applied_or_not() {
		boolean isApplied = cp.isCouponApplied();
		Assert.assertFalse(isApplied);
	}

	@Then("Relevant message should be displayed")
	public void a_relevant_message_should_be_displayed() {
		String message = cp.getCouponMessage();
		System.out.println("Displayed message: " + message);
	}

	@Given("User added a product to the cart")
	public void user_added_a_product_to_the_cart() {
		sa.searchProduct("Computing and Internet");
		sa.clickSearchButton();
		cp.AddToCart();
	}

	@Given("User is on the cart page")
	public void user_is_on_the_cart_page() {
		sa.cartIcon();
	}

	@When("User clicks the checkout button")
	public void user_clicks_the_checkout_button() {
		cp.clickTerms();
		cp.clickCheckout();
		cp.clickAsGuest();
	}

	@When("User enters invalid shipping details")
	public void user_enters_invalid_shipping_details() {
		cp.enterFname("User1");
		cp.enterLname("Test1");
		cp.enterEmail("abcd");
		cp.selectFromDropdown("India");
		cp.enterCity("Kolkata");
		cp.enterAddress("abc colony");
		cp.enterZip("123456");
		cp.enterPhone("2349875432");
		cp.clickContinue();
	}

	@Then("Error message should be displayed")
	public void error_message_should_be_displayed() {
		String actualMessage = cp.getMessage();
		System.out.println("Error: " + actualMessage);
		String expectedMessage = "Wrong email";
		Assert.assertEquals(actualMessage, expectedMessage, "Wrong Email Id has been entered");
	}

	@When("User enters valid shipping details")
	public void user_enters_valid_shipping_details() {
		cp.enterFname("User1");
		cp.enterLname("Test1");
		cp.enterEmail("abcd@eg.com");
		cp.selectFromDropdown("India");
		cp.enterCity("Kolkata");
		cp.enterAddress("abc colony");
		cp.enterZip("123456");
		cp.enterPhone("2349875432");
		cp.clickContinue();

	}

	@When("Completes the checkout process")
	public void completes_the_checkout_process() {
		cp.clickAddressContinue();
		cp.clickShippingContinue();
		cp.clickPaymentContinue();
		cp.clickPaymentInfoContinue();
		cp.clickConfirm();
	}

	@Then("Order confirmation message should be displayed")
	public void order_confirmation_message_should_be_displayed() {
		String actualMessage = cp.getSuccessMessage();
		System.out.println("Success: " + actualMessage);
		String expectedMessage = "Your order has been successfully processed!";
		Assert.assertEquals(actualMessage, expectedMessage, "Order confirmation message not displayed as expected");
	}

}
