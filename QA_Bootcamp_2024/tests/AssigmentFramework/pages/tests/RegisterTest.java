package AssigmentFramework.pages.tests;

import AssigmentFramework.pages.RegistrationPage;
import juiceShop.frameworkUtils.Utils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class RegisterTest extends BaseTest{
    @DataProvider(name = "RegisterDataProvider")
    public Iterator<Object[]> registerDp (){
        Collection<Object[]> dp = new ArrayList<>();
        // Positive tests
        dp.add(new String[] {"negrup30",
                "Glam.2016",
                "Glam.2016",
                "Mr.",
                "Narcis",
                "Negru",
                "contact@narcisnegru.ro",
                "17-02-1995"});
        dp.add(new String[] {"petru30",
                "Toby@123",
                "Toby@123",
                "Ms",
                "Gabriela",
                "Dejeu",
                "dejeu_gabi@yahoo.com",
                "05-11-1994"});
        dp.add(new String[] {"sorin234",
                "Sorinel@232",
                "Sorinel@232",
                "Mr",
                "Sorin",
                "Onica",
                "onica.sorin@gmail.com",
                "02-17-1975"});
        // Negative tests
        dp.add(new String[] {"",
                "Ionut22334@",
                "Ionut22334@",
                "Mr",
                "Pop",
                "Ilie",
                "ilie.pop@outlook.com",
                "12-19-1987"});
        dp.add(new String[] {"narcis1706",
                "",
                "Narcos2332",
                "Mr",
                "Narcos",
                "Padre",
                "padre.narcos@gmail.com",
                "17-02-1995"});
        return dp.iterator();
    }

    @Test(dataProvider = "RegisterDataProvider")
    public void register(String user,String pass, String confPass,String title,String firstName,String lastName,String email,String date){
        driver.get(baseUrl);
        RegistrationPage rp = new RegistrationPage(driver);
        rp.loginButton();
        rp.registerButton();
        Assert.assertEquals(rp.getSignUpSelector(),rp.getSignUpSelectorText());
        rp.register(user, pass, confPass, title, firstName, lastName, email, date);
        if (user.isEmpty() || pass.isEmpty()) {
            String expectedErrorText = "";
            if (user.isEmpty()) {
                expectedErrorText += rp.getErrorTextStaticUser();
            }
            if (pass.isEmpty()) {
                expectedErrorText += rp.getErrorTextStaticPass();
            }
            Assert.assertEquals(rp.getErrorText().getText(), expectedErrorText);

        }else {

            rp.setSubmitButton();

            String expectedText = rp.getConfirmSignInSelector().getText().trim().replaceAll(",\\s+", ",");
            String actualText = rp.getText(user).trim().replaceAll(",\\s+", ",");

            Assert.assertEquals(expectedText, actualText);
        }
    }
}
