package demoSite.tests;

import juiceShop.frameworkUtils.Utils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected static final String baseUrl = "http://57.151.123.81:4999";
    protected WebDriver driver;

    @BeforeMethod
    public void initDriver() {
        driver = Utils.getDriver();
    }

    @AfterMethod
    public void closeBrowser() {
        try {
            driver.close();
        }
        catch (Exception ex) {
            driver.quit();
        }
    }
}