package pages;

import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final SelenideElement username = $("#user-name");
    private final SelenideElement password = $("#password");
    private final SelenideElement loginBtn = $("#login-button");
    private final SelenideElement errorMassage = $("[class^='error-button']");

    public LoginPage enterValidUsername(){
        username.sendKeys(System.getProperty("standardUser"));
        return this;
    }
    public LoginPage enterInvalidUsername(){
        username.sendKeys(System.getProperty("invalidUser"));
        return this;
    }
    public LoginPage enterLockedUsername(){
        username.sendKeys(System.getProperty("lockedOutUser"));
        return this;
    }
    public LoginPage enterProblemUsername(){
        username.sendKeys(System.getProperty("problemUser"));
        return this;
    }
    public LoginPage enterPerformanceGlitchUsername(){
        username.sendKeys(System.getProperty("performanceGlitchUser"));
        return this;
    }
    public LoginPage enterErrorUsername(){
        username.sendKeys(System.getProperty("errorUser"));
        return this;
    }
    public LoginPage enterVisualUsername(){
        username.sendKeys(System.getProperty("visualUser"));
        return this;
    }
    public LoginPage enterPassword(){
        password.sendKeys(System.getProperty("password"));
        return this;
    }
    public LoginPage clickLoginBtn(){
        loginBtn.click();
        return this;
    }
    public void verifyThatLoginPageIsClosed() {
        Assert.assertFalse(loginBtn.isDisplayed());
    }
    public void verifyThatLoginPageIsOpened() {
        Assert.assertTrue(loginBtn.isDisplayed());
    }
    public LoginPage errorMassageDisplayed(){
        Assert.assertTrue(errorMassage.isDisplayed());
        return this;
    }
}

