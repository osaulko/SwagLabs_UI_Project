package tests;

import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import static com.codeborne.selenide.Selenide.page;

public class LoginTest extends BaseTest {

    @Test
    public void validLogIn(){
        for (int i = 0; i < validUserEmails.length; i++){
            page(LoginPage.class).logInAsValidUser(new String[]{validUserEmails[i]});
            Assert.assertFalse(LoginPage.loginBtn.isDisplayed());
            Selenide.back();
        }
    }
    @Test
    public void invalidLogIn(){
        for (int i = 0; i < invalidUserEmails.length; i++){
            page(LoginPage.class).logInAsInvalidUser(new String[]{invalidUserEmails[i]});
            Assert.assertTrue(LoginPage.loginBtn.isDisplayed());
            Assert.assertTrue(LoginPage.errorMassage.isDisplayed());
            Selenide.refresh();
        }
    }
}