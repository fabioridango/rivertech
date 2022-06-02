package ui.pages;

import ui.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage extends TestBase {

    @FindBy(xpath = "//div[normalize-space()='Sauce Labs Fleece Jacket']")
    @CacheLookup
    WebElement itemElement;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-fleece-jacket']")
    @CacheLookup
    WebElement addToCartElement;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    @CacheLookup
    WebElement shoppingCartBadgeElement;

    @FindBy(xpath = "//span[@class='title']")
    @CacheLookup
    WebElement titleElement;

    WebDriver driver = null;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;

        // Initializing Page Objects
        PageFactory.initElements(driver, this);
    }

    // To get the current url of the page
    public String getInventoryPageUrl() {
        return driver.getCurrentUrl();
    }

    // To get the title of the page
    public String getInventoryPageTitle() {
        return driver.getTitle();
    }

    // To get the title element
    public String getInventoryTitle() {
        return titleElement.getText();
    }

    // To get the item name
    public String getItemName() {
        return itemElement.getText();
    }

    // Click on Add To Cart button
    public void clickAddToCartButton() {
        addToCartElement.click();
    }

    // Click on shopping cart badge button
    public void clickShoppingCartBadgeButton() {
        shoppingCartBadgeElement.click();
    }

    // Return titleElement
    public WebElement getTitleElement() {
        return titleElement;
    }

}
