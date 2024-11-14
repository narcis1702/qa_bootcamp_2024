package AssigmentFramework.tests;

import AssigmentFramework.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test

import static AssigmentFramework.tests.BaseTest.baseUrl;

public class MainTest {
    @Test
    public void mainPageTest(){

        // OLD version !! Do not use unless the server you are testing does not have internet
        // System.property("webdriver.chrome.driver", "C:\\Users\myuser\Download\chromedriver.exe");
        driver.get(baseUrl);
        MainPage mp = new MainPage(driver);
        Assert.assertEquals(mp.getWebStubsText(),mp.getWebStubsStaticText());
    }

}
}
