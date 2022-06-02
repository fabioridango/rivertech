package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.base.TestBase;

public class CheckOutStepOnePage extends TestBase {

    @FindBy(xpath = "//input[@id='first-name']")
    @CacheLookup
    WebElement firstNameElement;

    @FindBy(xpath = "//input[@id='last-name']")
    @CacheLookup
    WebElement lastNameElement;

    @FindBy(xpath = "//input[@id='postal-code']")
    @CacheLookup
    WebElement zipPostalCodeElement;

    @FindBy(xpath = "//input[@id='continue']")
    @CacheLookup
    WebElement continueButtonElement;

    @FindBy(xpath = "//span[@class='title']")
    @CacheLookup
    WebElement titleElement;

    WebDriver driver = null;

    public CheckOutStepOnePage(WebDriver driver) {
        this.driver = driver;

        // Initializing Page Objects
        PageFactory.initElements(driver, this);
    }

    // To get the current url of the page
    public String getCheckOutStepOnePageUrl() {
        return driver.getCurrentUrl();
    }

    // To get the title of the page
    public String getCheckOutStepOnePageTitle() {
        return driver.getTitle();
    }

    // To get the title element
    public String getCheckOutStepOneTitle() {
        return titleElement.getText();
    }

    // Clear text of first name field
    public void clearFirstNameField() {
        firstNameElement.clear();
    }

    // Clear text of last name field
    public void clearLastNameField() {
        lastNameElement.clear();
    }

    // Clear text of zip/postal code field
    public void clearZipPostalCodeField() {
        zipPostalCodeElement.clear();
    }

    // Enter first name
    public void enterFirstName(String firstName) {
        firstNameElement.sendKeys(firstName);
    }

    // Enter last name
    public void enterLastName(String lastName) {
        lastNameElement.sendKeys(lastName);
    }

    // Enter zip/postal code
    public void enterZipPostalCode(String zipPostalCode) {
        zipPostalCodeElement.sendKeys(zipPostalCode);
    }

    // Click on Continue button
    public void clickContinueButton() {
        continueButtonElement.click();
    }
}
