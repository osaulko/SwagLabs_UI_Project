package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static config.PropertyReader.properties;

public class LoginPage {
    private final SelenideElement username = $("#user-name");
    private final SelenideElement password = $("#password");
    public static SelenideElement loginBtn = $("#login-button");
    public static SelenideElement errorMassage = $("[class^='error-button']");
    private static final String validPassword = properties.getProperty("password");

    public void logInAsValidUser(Object loginDataProvider){
            username.sendKeys((CharSequence) loginDataProvider);
            password.sendKeys(validPassword);
            loginBtn.click();

    }
    public void logInAsInvalidUser(Object invalidLoginDataProvider){
            username.sendKeys((CharSequence) invalidLoginDataProvider);
            password.sendKeys(validPassword);
            loginBtn.click();
    }
}