package tests;

import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import static com.codeborne.selenide.Selenide.page;

public class LoginTest extends BaseTest {

    /** Тест validLogIn покрывает кейсы 3p001, 3p003, 3p004, 3p005, 3p006.
     *  assert в этом тесте проверяет отсутствие кнопки loginBtn.
     */

    @Test(dataProvider = "validLoginData")
    public void validLogIn(String username){
            page(LoginPage.class).logInAsValidUser(username);
            Assert.assertFalse(LoginPage.loginBtn.isDisplayed());
            Selenide.back();
    }

    /** Тест invalidLogIn покрывает кейсы 3p002, 3p007, 3p008
    *   assert в этом тесте проверяет наличие кнопки loginBtn и наличие сообщения об ошибке.
    */

    @Test(dataProvider = "invalidLoginData")
    public void invalidLogIn(String username){
            page(LoginPage.class).logInAsInvalidUser(username);
            Assert.assertTrue(LoginPage.loginBtn.isDisplayed());
            Assert.assertTrue(LoginPage.errorMassage.isDisplayed());
            Selenide.refresh();
    }
}