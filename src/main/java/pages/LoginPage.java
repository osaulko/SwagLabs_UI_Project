package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static config.PropertyReader.properties;

public class LoginPage {
    private final SelenideElement username = $("#user-name");
    private final SelenideElement password = $("#password");
    public static SelenideElement loginBtn = $("#login-button");
    public static SelenideElement errorMassage = $("[class^='error-button']");
    private static final String validPassword = properties.getProperty("password");

    public void logInAsValidUser(String[] validUserEmails){
        for (String email : validUserEmails) {
            username.sendKeys(email);
            password.sendKeys(validPassword);
            loginBtn.click();
        return;}
    }
    public void logInAsInvalidUser(String[] invalidUserEmails){
        for (String invalidEmail : invalidUserEmails) {
            username.sendKeys(invalidEmail);
            password.sendKeys(validPassword);
            loginBtn.click();
        return;}
    }
}