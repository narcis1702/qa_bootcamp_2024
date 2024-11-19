package AssigmentFramework.tests;

import AssigmentFramework.pages.LogInPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class LogInTest extends BaseTest{

    @DataProvider(name = "LoginDataProvider")
    public Iterator<Object[]> loginDp() {
        Collection<Object[]> dp = new ArrayList<>();
        // Positive tests
        dp.add(new String[]{"doggo", "doggopassword"});
        dp.add(new String[]{"kitty", "kittypassword"});
        dp.add(new String[]{"mice", "micepassword"});
        //Negative tests
        dp.add(new String[]{"", "micepassword"});
        dp.add(new String[]{"mice", ""});
        return dp.iterator();
    }

    @Test(dataProvider = "LoginDataProvider")
    public void login(String username, String password) {
        driver.get(baseUrl);
        LogInPage lp = new LogInPage(driver);
        Assert.assertEquals(lp.getWebStubsText(), lp.getWebStubsStaticText());
        lp.loginButton();
        Assert.assertEquals(lp.getSignInSelector().getText(), lp.getSignInStaticText());
        lp.login(username, password);
        if (username.isEmpty() || password.isEmpty()) {
            String expectedErrorText = "";
            if (username.isEmpty()) {
                expectedErrorText += lp.getErrorTextStaticUser();
            }
            if (password.isEmpty()) {
                expectedErrorText += lp.getErrorTextStaticPass();
            }

            Assert.assertEquals(lp.getErrorText().getText(), expectedErrorText);

        }else {

            lp.signInButton();

            String expectedText = lp.getConfirmSignInSelector().getText().trim().replaceAll(",\\s+", ",");
            String actualText = lp.getText(username).trim().replaceAll(",\\s+", ",");

            Assert.assertEquals(expectedText, actualText);
        }


    }
}
