package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final SelenideElement username = $("#user-name");
    private final SelenideElement password = $("#password");
    private final SelenideElement loginBtn = $("#login-button");
    private final SelenideElement errorMassage = $("[class^='error-button']");
    String lockedUser = "locked_out_user";
    String invalidUserName = "standard";

    public LoginPage loginAsValidUser(){
            //кейс 3р001
        username.sendKeys(System.getProperty("standardUser"));
        password.sendKeys(System.getProperty("password"));
        loginBtn.click();
        Assert.assertFalse(loginBtn.isDisplayed());
        Selenide.back();
            //кейс 3р003
        username.sendKeys(System.getProperty("problemUser"));
        password.sendKeys(System.getProperty("password"));
        loginBtn.click();
        Assert.assertFalse(loginBtn.isDisplayed());
        Selenide.back();
            //кейс 3р004
        username.sendKeys(System.getProperty("performanceGlitchUser"));
        password.sendKeys(System.getProperty("password"));
        loginBtn.click();
        Assert.assertFalse(loginBtn.isDisplayed());
        Selenide.back();
            //кейс 3р005
        username.sendKeys(System.getProperty("errorUser"));
        password.sendKeys(System.getProperty("password"));
        loginBtn.click();
        Assert.assertFalse(loginBtn.isDisplayed());
        Selenide.back();
        //кейс 3р006
        username.sendKeys(System.getProperty("visualUser"));
        password.sendKeys(System.getProperty("password"));
        loginBtn.click();
        Assert.assertFalse(loginBtn.isDisplayed());
        Selenide.back();
        return this;
    }
    public LoginPage loginAsInvalidUser(){
            //кейс 3р002
        username.sendKeys(lockedUser);
        password.sendKeys(System.getProperty("password"));
        loginBtn.click();
        verifyThatLoginPageIsOpened();
        Selenide.refresh();
            //кейс 3р007
        username.sendKeys(invalidUserName);
        password.sendKeys(System.getProperty("password"));
        loginBtn.click();
        verifyThatLoginPageIsOpened();
        Selenide.refresh();
            //кейс 3р008
        password.sendKeys(System.getProperty("password"));
        loginBtn.click();
        verifyThatLoginPageIsOpened();
        return this;
    }
    private void verifyThatLoginPageIsOpened() {
        Assert.assertTrue(loginBtn.isDisplayed());
        Assert.assertTrue(errorMassage.isDisplayed());
    }
}

