package Assigment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class RegisterTest {
    protected static final String baseUrl = Assigment.Utils.getConfigProperty("baseUrl");

    protected WebDriver driver;

    @BeforeMethod
    public void initBrowser(){

        // OLD version !! Do not use unless the server you are testing does not have internet
        // System.property("webdriver.chrome.driver", "C:\\Users\myuser\Download\chromedriver.exe");
        driver = Utils.getDriver();
        driver.manage().window().maximize();

    }
    @DataProvider(name = "RegistrationData")
    public Iterator<Object[]> provideData() {

        List<Object[]> testData = new ArrayList<>();

        testData.add(new Object[] { "invalidemail.com", "short23","short23","gabi"});
        testData.add(new Object[] { "ancaa@s.com", "","short23","gabi" });
        testData.add(new Object[] { "daniel@t.com", "vlad2345","vlad2435","gabi" });
        testData.add(new Object[] { "ionela@ioana.com", "short23","short23","" });

        testData.add(new Object[] { "anadre@ci.com", "andr2554","andr2554","gabi" });
        testData.add(new Object[] { "popion@ion.com", "ioddop23","ioddop23","ionut" });
        testData.add(new Object[] { "dudf@flaviu.com", "flava284","flava284","daniel" });

        return testData.iterator();
    }
    @Test(dataProvider = "RegistrationData")
    public void register(String email, String password,String confirmPassword,String securityAns) {
        driver.get(baseUrl + "/#/");
        Assert.assertEquals(driver.findElement(By.cssSelector(Assigment.Selectors.MAIN_PAGE_HEADER)).getText(), Assigment.Selectors.MAIN_TEXT);


        WebElement accountButton = driver.findElement(By.id(Assigment.Selectors.ACCOUNT_BUTTON));
        WebElement dismiss = Assigment.Utils.waitForElement(driver,5,By.cssSelector(Selectors.DISMISS));
        dismiss.click();
        accountButton.click();

        WebElement loginButton = driver.findElement(By.id(Assigment.Selectors.LOGIN_BUTTON));
        loginButton.click();

        Assert.assertEquals(driver.findElement(By.cssSelector(Assigment.Selectors.LOGIN_HEADER)).getText(), Assigment.Selectors.LOGIN_TEXT);

        WebElement registerLink = driver.findElement(By.cssSelector(Assigment.Selectors.REGISTER_URL));
        if (Assigment.Utils.waitToDisappear(driver,5,By.id(Selectors.MODAL)))
            registerLink.click();

        Assert.assertEquals(
                driver.findElement(By.cssSelector(Assigment.Selectors.REGISTER_HEADER)).getText(),
                Selectors.REGISTER_TEXT);

        WebElement usernameElement = driver.findElement(By.id(Assigment.Selectors.REGISTER_EMAIL));
        usernameElement.clear();
        usernameElement.sendKeys(email);

        WebElement passwordElement = driver.findElement(By.id(Assigment.Selectors.REGISTER_PASSWORD));
        passwordElement.clear();
        passwordElement.sendKeys(password);

        WebElement passwordRepeat = driver.findElement(By.id(Assigment.Selectors.REGISTER_CONFIRM));
        passwordRepeat.clear();
        passwordRepeat.sendKeys(confirmPassword);

        WebElement securityQuestion = Assigment.Utils.waitForElement(driver, 5,
                By.name(Assigment.Selectors.SECURITY_QUESTION));
        securityQuestion.click();


        WebElement securityQuestionChoice = Assigment.Utils.waitToBeClickable(driver,10,
                By.cssSelector(Selectors.SECURITY_QUESTION1));
        securityQuestionChoice.click();

        WebElement securityAnswer = driver.findElement(By.id(Assigment.Selectors.SECURITY_ANSWER));
        securityAnswer.clear();
        securityAnswer.sendKeys(securityAns);

        WebElement submitButton = driver.findElement(By.id(Assigment.Selectors.REGISTER_SUBMIT_BUTTON));

        if (Assigment.Utils.waitToDisappear(driver,5,By.id(Assigment.Selectors.COOKIES_MODAL)))


            if (!submitButton.isDisplayed()){
                if (driver.findElement(By.id(Selectors.INVALID_EMAIL)).isDisplayed()) {
                    Assert.assertEquals(driver.findElement(By.id(Selectors.INVALID_EMAIL)).getText(),
                            Selectors.INVALID_EMAIL_TEXT, "Mesajul de eroare nu este cel așteptat.");

                } else if (driver.findElement(By.id(Selectors.INVALID_PASSWORD)).isDisplayed()) {
                    Assert.assertEquals(driver.findElement(By.id(Selectors.INVALID_PASSWORD)).getText(),
                            Selectors.INVALID_PASSWORD_TEXT, "Mesajul de eroare nu este cel așteptat.");
                    Assert.assertEquals(driver.findElement(By.id(Selectors.REPEAT_PASSWORD)).getText(),
                            Selectors.REPEAT_PASSWORD_TEXT, "Mesajul de eroare nu este cel așteptat.");


                } else if (driver.findElement(By.id(Selectors.WRONG_PASSWORD)).isDisplayed()) {
                    Assert.assertEquals(driver.findElement(By.id(Selectors.WRONG_PASSWORD)).getText(),
                            Selectors.WRONG_PASSWORD_TEXT, "Mesajul de eroare nu este cel așteptat.");

                } else if (driver.findElement(By.id(Selectors.NO_ANSWER)).isDisplayed()) {
                    Assert.assertEquals(driver.findElement(By.id(Selectors.NO_ANSWER)).getText(),
                            Selectors.NO_ANSWER_TEXT, "Mesajul de eroare nu este cel așteptat.");
                }
            }else {
                submitButton.click();

            }


    }

    @AfterMethod
    public void closeBrowser(){
        try {
            driver.close();
        }catch (Exception ex){
            driver.quit();
        }
    }
}
