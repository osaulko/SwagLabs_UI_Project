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

    public LoginPage logInAsValidUser(String usernameInput) {
        username.sendKeys(usernameInput);
        password.sendKeys(validPassword);
        loginBtn.click();
        return this;
    }
    public LoginPage logInAsInvalidUser(String invalidUsernameInput) {
        username.sendKeys(invalidUsernameInput);
        password.sendKeys(validPassword);
        loginBtn.click();
        return this;
    }
    public InventoryPage logIn() {
        username.sendKeys(properties.getProperty("standardUser"));
        password.sendKeys(validPassword);
        loginBtn.click();
        return new InventoryPage();
    }
}