package ui.hooks;

import ui.base.TestBase;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class myHooks {

    public WebDriver driver = null;

    // Global Hooks
    // Before hook − Set up the webdriver and other prerequisites to run the test.
    // The Before script will be run before each Scenario
    @Before
    public void setUP() {
        TestBase.initialization();
        driver = TestBase.driver;
    }

    // The After script  will be run after each Scenario
    @After
    public void tearDown(Scenario scenario) {

            if (scenario.isFailed()) {

                System.out.println("**** Scenario: " + scenario.getName() + " is Failed ******");

            }else {

                System.out.println("**** Scenario: " + scenario.getName() + " is Passed ******");

            }

            TestBase.closeBrowser();
    }
}

