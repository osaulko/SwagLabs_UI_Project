package tests;

import org.testng.annotations.Test;
import pages.LoginPage;
import static com.codeborne.selenide.Selenide.page;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void validLogIn() {
        page(LoginPage.class)
                .loginAsValidUser();

    }
    @Test(priority = 2)
    public void invalidLogIn() {
        page(LoginPage.class)
                .loginAsInvalidUser();
    }
}