package juiceShop.tests;

import juiceShop.frameworkUtils.Utils;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

import java.util.Set;

public class CookieTest extends  BaseTest {

    @Test
    public void cookieTest() {
        driver.get(baseUrl + "/#/");
        Utils.printCookies(driver);
        Cookie c = new Cookie("alexCookie", "cookie_value");
        driver.manage().addCookie(c);
        Utils.printCookies(driver);
        driver.manage().deleteCookieNamed("alexCookie");
        driver.manage().deleteAllCookies();
        Utils.printCookies(driver);

    }

}