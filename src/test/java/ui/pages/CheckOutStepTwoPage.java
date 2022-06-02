package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.base.TestBase;

public class CheckOutStepTwoPage extends TestBase{

    @FindBy(xpath = "//div[@class='summary_subtotal_label']")
    @CacheLookup
    WebElement subtotalElement;

    @FindBy(xpath = "//div[@class='summary_tax_label']")
    @CacheLookup
    WebElement taxElement;

    @FindBy(xpath = "//div[@class='summary_total_label']")
    @CacheLookup
    WebElement totalElement;

    @FindBy(xpath = "//button[@id='finish']")
    @CacheLookup
    WebElement finishButtonElement;

    @FindBy(xpath = "//span[@class='title']")
    @CacheLookup
    WebElement titleElement;

    WebDriver driver = null;

    public CheckOutStepTwoPage(WebDriver driver) {
        this.driver = driver;

        // Initializing Page Objects
        PageFactory.initElements(driver, this);
    }

    // To get the current url of the page
    public String getCheckOutStepTwoPageUrl() {
        return driver.getCurrentUrl();
    }

    // To get the title of the page
    public String getCheckOutStepTwoPageTitle() {
        return driver.getTitle();
    }

    // To get the title element
    public String getCheckOutStepTwoTitle() {
        return titleElement.getText();
    }

    // To get the item total
    public String getItemTotal() {
        return subtotalElement.getText();
    }

    // To get the tax
    public String getTax() {
        return taxElement.getText();
    }

    // To get the total
    public String getTotal() {
        return totalElement.getText();
    }

    // Click on finish button
    public void clickOnFinishButton() {
        finishButtonElement.click();
    }
}
