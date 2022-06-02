package ui.pages;

import ui.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    @FindBy(xpath = "//*[@id='user-name']")
    @CacheLookup
    WebElement usernameElement;

    @FindBy(xpath = "//input[@id='password']")
    @CacheLookup
    WebElement passwordElement;

    @FindBy(xpath = "//input[@id='login-button']")
    @CacheLookup
    WebElement loginButtonElement;

    WebDriver driver = null;

    public LoginPage(WebDriver driver) {
        this.driver = driver;

        // Initializing Page Objects
        PageFactory.initElements(driver, this);
    }

    // Clear text of username field
    public void clearUsernameField() {
        usernameElement.clear();
    }

    // Clear text of password field
    public void clearPasswordField() {
        passwordElement.clear();
    }

    // Enter username
    public void enterUsername(String username) {
        usernameElement.sendKeys(username);
    }

    // Enter password
    public void enterPassword(String password) {
        passwordElement.sendKeys(password);
    }

    // Click on Login button
    public void clickLoginButton() {
        loginButtonElement.click();
    }

    // To get the current url of the page
    public String getLoginPageUrl() {
        return driver.getCurrentUrl();
    }

    // To get the title of the page
    public String getLoginPageTitle() {
        return driver.getTitle();
    }
}

