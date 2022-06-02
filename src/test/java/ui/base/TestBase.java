package ui.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

    public static WebDriver driver = null;
    public static Properties propConfig;

    public TestBase() {
    }

    // Cross-Platform & Cross-Browser
    public static void initialization() {
        try {

            propConfig = new Properties();

            FileInputStream fileConfig = new FileInputStream(System.getProperty("user.dir") + "/src/test/java" +
                    "/ui/config/" + "environment.properties");

            propConfig.load(fileConfig);

            String os = propConfig.getProperty("os");

            String browserName = propConfig.getProperty("browser");

            if (os.equals("MacOS")) {

                if (browserName.equals("chrome")) {

                    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/" +
                            "ui/webdrivers" + "/macOS_driver/chromedriver");

                    driver = new ChromeDriver();
                }

            } else if (os.equals("Windows")) {

                if (browserName.equals("chrome")) {

                    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\" +
                            "resources\\ui\\webdrivers\\" +
                            "Windows_driver\\chromedriver.exe");

                    driver = new ChromeDriver();
                }
            }

            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();

            // Set the page load timeout
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
            // Set implicit wait
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            driver.navigate().to(propConfig.getProperty("url"));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void closeBrowser() {
        driver.quit();
    }
}
