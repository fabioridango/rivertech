package ui.pages;

import ui.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends TestBase {

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    @CacheLookup
    WebElement itemCartElement;

    @FindBy(xpath = "//button[@id='checkout']")
    @CacheLookup
    WebElement CheckoutElement;

    @FindBy(xpath = "//span[@class='title']")
    @CacheLookup
    WebElement titleElement;

    @FindBy(xpath = "//div[@class='cart_quantity']")
    @CacheLookup
    WebElement cartQuantityElement;

    WebDriver driver = null;

    public CartPage(WebDriver driver) {
        this.driver = driver;

        // Initializing Page Objects
        PageFactory.initElements(driver, this);
    }

    // To get the current url of the page
    public String getCartPageUrl() {
        return driver.getCurrentUrl();
    }

    // To get the title of the page
    public String getCartPageTitle() {
        return driver.getTitle();
    }

    // To get the title
    public String getCartTitle() {
        return titleElement.getText();
    }

    // To get the cart quantity
    public WebElement getCartQuantity() {
        return cartQuantityElement;
    }

    // To get the item in the shopping cart
    public String getItemCart() {
        return itemCartElement.getText();
    }

    // Click on checkout button in the shopping cart
    public void clickCheckoutButton() {
        CheckoutElement.click();
    }
}
