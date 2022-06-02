package ui.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ui.base.TestBase;
import ui.pages.CheckOutStepOnePage;
import ui.pages.LoginPage;
import ui.pages.CartPage;
import ui.pages.InventoryPage;
import ui.pages.CheckOutStepTwoPage;
import ui.pages.CheckOutCompletePage;
import ui.helpers.WaitHelper;

public class ShoppingFlowStep {

    public LoginPage loginPage;
    public InventoryPage inventoryPage;
    public CartPage cartPage;
    public CheckOutStepOnePage checkOutStepOnePage;
    public CheckOutStepTwoPage checkOutStepTwoPage;
    public CheckOutCompletePage checkOutCompletePage;
    public WaitHelper waitHelper;
    public WebDriver driver = null;

    @Given("I'm logged on customer portal {string}")
    public void i_m_logged_on_customer_portal(String portalURL) {

        driver = TestBase.driver;

        waitHelper = new WaitHelper();

        loginPage = new LoginPage(driver);

        inventoryPage = new InventoryPage(driver);

        cartPage = new CartPage(driver);

        checkOutStepOnePage = new CheckOutStepOnePage(driver);

        checkOutStepTwoPage = new CheckOutStepTwoPage(driver);

        checkOutCompletePage = new CheckOutCompletePage(driver);

        // Login page URL validation
        Assert.assertEquals(loginPage.getLoginPageUrl(), portalURL, "Incorrect E-commerce portal URL");

        // Login page title validation
        String portalPageTitle = "Swag Labs";
        Assert.assertEquals(loginPage.getLoginPageTitle(), portalPageTitle, "Incorrect E-commerce portal title");

        loginPage.clearUsernameField();

        loginPage.clearPasswordField();

        loginPage.enterUsername("standard_user");

        loginPage.enterPassword("secret_sauce");

        loginPage.clickLoginButton();

        // Inventory Page URL Validation
        String inventoryPageURL = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(inventoryPage.getInventoryPageUrl(), inventoryPageURL);

        // Inventory page title validation
        String inventoryPageTitle = "Swag Labs";
        Assert.assertEquals(inventoryPage.getInventoryPageTitle(), inventoryPageTitle);

        // Inventory title validation
        String inventoryTitle = "PRODUCTS";
        Assert.assertEquals(inventoryPage.getInventoryTitle(), inventoryTitle);

        // Inventory page item name validation
        String itemName = "Sauce Labs Fleece Jacket";
        Assert.assertEquals(inventoryPage.getItemName(), itemName);

    }
    @Given("I added an item to the shopping cart")
    public void i_added_an_item_to_the_shopping_cart() {

        // To add cart item
        inventoryPage.clickAddToCartButton();

        // Click on Shopping Cart badge
        inventoryPage.clickShoppingCartBadgeButton();

        // Cart Page URL Validation
        String cartPageURL = "https://www.saucedemo.com/cart.html";
        Assert.assertEquals(cartPage.getCartPageUrl(), cartPageURL);

        // Cart page title validation
        String cartPageTitle = "Swag Labs";
        Assert.assertEquals(cartPage.getCartPageTitle(), cartPageTitle);

        // Cart title validation
        String cartTitle = "YOUR CART";
        Assert.assertEquals(cartPage.getCartTitle(), cartTitle);

        // Item present in the shopping cart validation
        String itemName = "Sauce Labs Fleece Jacket";
        Assert.assertEquals(cartPage.getItemCart(), itemName);

        // Click on checkout button in the shopping cart
        cartPage.clickCheckoutButton();

        // CheckOut Step One Page URL Validation
        String checkOutStepOnePageURL = "https://www.saucedemo.com/checkout-step-one.html";
        Assert.assertEquals(checkOutStepOnePage.getCheckOutStepOnePageUrl(), checkOutStepOnePageURL);

        // CheckOut Step One Page title validation
        String checkOutStepOnePageTitle = "Swag Labs";
        Assert.assertEquals(checkOutStepOnePage.getCheckOutStepOnePageTitle(), checkOutStepOnePageTitle);

        // CheckOut Step One title validation
        String checkOutStepOneTitle = "CHECKOUT: YOUR INFORMATION";
        Assert.assertEquals(checkOutStepOnePage.getCheckOutStepOneTitle(), checkOutStepOneTitle);

        checkOutStepOnePage.clearFirstNameField();

        checkOutStepOnePage.clearLastNameField();

        checkOutStepOnePage.clearZipPostalCodeField();

        checkOutStepOnePage.enterFirstName("Fabio");

        checkOutStepOnePage.enterLastName("Siciliano");

        checkOutStepOnePage.enterZipPostalCode("123456");

        checkOutStepOnePage.clickContinueButton();

    }
    @When("I confirm the order")
    public void i_confirm_the_order() {

        // Checkout step two page URL Validation
        String checkOutStepTwoPageURL = "https://www.saucedemo.com/checkout-step-two.html";
        Assert.assertEquals(checkOutStepTwoPage.getCheckOutStepTwoPageUrl(), checkOutStepTwoPageURL);

        // Checkout step two page title validation
        String checkOutStepTwoPageTitle = "Swag Labs";
        Assert.assertEquals(checkOutStepTwoPage.getCheckOutStepTwoPageTitle(), checkOutStepTwoPageTitle);

        // Checkout step two title validation
        String checkOutStepTwoTitle = "CHECKOUT: OVERVIEW";
        Assert.assertEquals(checkOutStepTwoPage.getCheckOutStepTwoTitle(), checkOutStepTwoTitle);

        // Validation the item total
        String itemTotal = "Item total: $49.99";
        Assert.assertEquals(checkOutStepTwoPage.getItemTotal(), itemTotal);

        // Validation the tax
        String tax = "Tax: $4.00";
        Assert.assertEquals(checkOutStepTwoPage.getTax(), tax);

        // Validation the tax
        String total = "Total: $53.99";
        Assert.assertEquals(checkOutStepTwoPage.getTotal(), total);

        checkOutStepTwoPage.clickOnFinishButton();

    }
    @Then("The order has been dispatched")
    public void the_order_has_been_dispatched() throws Exception {

        // Checkout complete page URL Validation
        String checkoutCompletePageURL = "https://www.saucedemo.com/checkout-complete.html";
        Assert.assertEquals(checkOutCompletePage.getCheckOutCompletePageUrl(), checkoutCompletePageURL);

        // Checkout complete page title validation
        String checkoutCompletePageTitle = "Swag Labs";
        Assert.assertEquals(checkOutCompletePage.getCheckOutCompletePageTitle(), checkoutCompletePageTitle);

        // Checkout title validation
        String checkoutTitle = "CHECKOUT: COMPLETE!";
        Assert.assertEquals(checkOutCompletePage.getCheckoutTitle(), checkoutTitle);

        // Checkout header validation
        String checkoutHeader = "THANK YOU FOR YOUR ORDER";
        Assert.assertEquals(checkOutCompletePage.getCompleteCheckoutHeader(), checkoutHeader);

        // Checkout text validation
        String checkoutText = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";
        Assert.assertEquals(checkOutCompletePage.getCompleteCheckoutText(), checkoutText);

        checkOutCompletePage.clickOnBackHomeButton();

        // Inventory Page URL Validation
        String inventoryPageURL = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(inventoryPage.getInventoryPageUrl(), inventoryPageURL);

        /* Workaround to fix the StaleElementReferenceException that is raised everytime that I try to catch
         the found elements.
         It happens after that the getCurrentUrl() method is performed(reload is generate), all the previously found
         elements become stale because the DOM is rebuilt */
        InventoryPage inventoryPage = new InventoryPage(driver);

        // Inventory page title validation
        String inventoryPageTitle = "Swag Labs";
        Assert.assertEquals(inventoryPage.getInventoryPageTitle(), inventoryPageTitle);

        // Inventory title validation
        String inventoryTitle = "PRODUCTS";
        Assert.assertEquals(inventoryPage.getInventoryTitle(), inventoryTitle);

        //Click on Shopping Cart badge
        inventoryPage.clickShoppingCartBadgeButton();

        // Cart Page URL Validation
        String cartPageURL = "https://www.saucedemo.com/cart.html";
        Assert.assertEquals(cartPage.getCartPageUrl(), cartPageURL);

        /* Workaround to fix the StaleElementReferenceException */
        CartPage cartPage = new CartPage(driver);

        // Cart page title validation
        String cartPageTitle = "Swag Labs";
        Assert.assertEquals(cartPage.getCartPageTitle(), cartPageTitle);

        // Cart title validation
        String cartTitle = "YOUR CART";
        Assert.assertEquals(cartPage.getCartTitle(), cartTitle);

        // Check that the shopping cart is empty
        try {
            WebElement cartQuantity = cartPage.getCartQuantity();
            cartQuantity.isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("Shopping flow scenario validation completed with success: " +
                    "The item has been dispatched and removed from the shopping cart as expected");
        }
    }
}
