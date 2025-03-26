Feature: Demo Web Shop Testing

Scenario: User registers with invalid data
Given User is on the registration page
When User enters invalid details in the form
And User click the register 
Then Error message is displayed

Scenario: User registers and logs in successfully
Given User is on the registration page
When User enters valid details in the form
And User click the register 
Then "Your registration completed" message is displayed

Scenario Outline: User logs in with different credentials
Given User is on home page
When User enters "<email>" and "<password>"
Then "<message>" is displayed

Examples:
| email                        | password     | message                               |
| invalid@example.com          | wrongpassword| The credentials provided are incorrect|
| testfunctionality@example.com| Password123  | User Email Displayed                  |

Scenario: User logs out successfully
Given User is logged in
When User clicks on the logout button
Then User is logged out and sees the login button

Scenario: Product Search and Add to Cart
Given User is on the homepage
When User search for a product
And clicks the search button
And clicks on the product from the search results
And clicks the Add to Cart button
Then "The product has been added to your shopping cart" message should be displayed

Scenario: Adding multiple products to cart and validating cart summary
Given User is on the homepage
When User searches for the first product and adds it to the cart
And User searches for the second product and adds it to the cart
And User navigates to the cart page
Then Both products should be displayed in the cart
And Total price should be displayed

Scenario: Applying a Coupon Code and Verifying Discount
Given User adds a product to the cart
And User navigates to the checkout page
When User enters a coupon code
Then User should be able to see whether the coupon is applied or not
And Relevant message should be displayed

Scenario: Checkout Process with Invalid Data Handling
Given User added a product to the cart 
And User is on the cart page
When User clicks the checkout button
When User enters invalid shipping details
Then Error message should be displayed

Scenario: Checkout Process with Valid Data Handling
Given User added a product to the cart 
And User is on the cart page
When User clicks the checkout button
When User enters valid shipping details
And Completes the checkout process
Then Order confirmation message should be displayed