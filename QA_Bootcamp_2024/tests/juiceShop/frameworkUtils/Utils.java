package juiceShop.frameworkUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Utils {

    private static final String configFile = "config.properties";

    public static String getConfigProperty(String property) {
        Properties configProps = new Properties();
        String baseUrl = "";
        try {
            configProps.load(new FileInputStream(configFile));
            baseUrl = configProps.getProperty(property).toLowerCase();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return baseUrl;
    }

    public static WebDriver getDriver() {
        WebDriver driver;
//        System.out.println(System.getenv("AUTO_BROWSER"));
        String browser = getConfigProperty("browser");

        switch(browser) {
            case "chrome": {
                driver = new ChromeDriver();
                break;
            }
            case "firefox": {
                driver = new FirefoxDriver();
                break;
            }
            case "edge": {
                driver = new EdgeDriver();
                break;
            }
            default: {
                driver = new ChromeDriver();
            }
        }
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }


    public static WebElement waitForElement(WebDriver driver, long seconds, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

    }

    public static WebElement waitForElementClickable(WebDriver driver, long seconds, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));

    }

}