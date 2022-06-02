package ui.pages;

import ui.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutCompletePage extends TestBase {

    @FindBy(xpath = "//span[@class='title']")
    @CacheLookup
    WebElement checkoutTitleElement;

    @FindBy(xpath = "//h2[@class='complete-header']")
    @CacheLookup
    WebElement completeCheckoutHeaderElement;

    @FindBy(xpath = "//div[@class='complete-text']")
    @CacheLookup
    WebElement completeCheckoutTextElement;

    @FindBy(xpath = "//button[@id='back-to-products']")
    @CacheLookup
    WebElement backHomeButtonElement;

    WebDriver driver = null;

    public CheckOutCompletePage(WebDriver driver) {
        this.driver = driver;

        // Initializing Page Objects
        PageFactory.initElements(driver, this);
    }

    // To get the current url of the page
    public String getCheckOutCompletePageUrl() {
        return driver.getCurrentUrl();
    }

    // To get the title of the page
    public String getCheckOutCompletePageTitle() {
        return driver.getTitle();
    }

    // To get the checkout title
    public String getCheckoutTitle() {
        return checkoutTitleElement.getText();
    }

    // To get the complete checkout header
    public String getCompleteCheckoutHeader() {
        return completeCheckoutHeaderElement.getText();
    }

    // To get the checkout text
    public String getCompleteCheckoutText() {
        return completeCheckoutTextElement.getText();
    }

    // Click on backHome Button
    public void clickOnBackHomeButton() {
         backHomeButtonElement.click();
    }
}
