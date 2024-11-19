package AssigmentFramework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage {
    private static final String LOGIN_BUTTON = "#svelte > div.container-fluid > " +
            "div.header.sticky-top.row > div:nth-child(2) > div > a";

    private static final String ERROR_TEXT = "form-error";
    private static final String CONFIRM_SIGN_IN_SELECTOR = "#svelte > div.container-fluid > div.main.row > div.content > h1";
    private static final String CONFIRM_SIGN_IN_TEXT1 = "Welcome to the Web Stubs,";
    private static final String CONFIRM_SIGN_IN_TEXT2 = "!";

    @FindBy(css = LOGIN_BUTTON)
    WebElement loginButton;
    @FindBy(className = ERROR_TEXT)
    WebElement errorText;
    @FindBy(css = CONFIRM_SIGN_IN_SELECTOR)
    WebElement confirmSignInSelector;
    protected WebDriver driver;
    public void loginButton(){
        loginButton.click();
    }
    public WebElement getErrorText(){
        return errorText;
    }
    public WebElement getConfirmSignInSelector(){

        return confirmSignInSelector;
    }
    public String getText(String username){
        String text = CONFIRM_SIGN_IN_TEXT1+username+CONFIRM_SIGN_IN_TEXT2;
        return text;
    }
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
