package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import static com.codeborne.selenide.Selenide.page;

public class LoginTest extends BaseTest {

    @Epic("Авторизация")
    @Feature("Успешная авторизация")
    @Story("Позитивные сценарии входа")
    @Description("Тест покрывает кейсы 3p001, 3p003, 3p004, 3p005, 3p006 - Успешный вход в систему")
    @Test(dataProvider = "validLoginData")
    public void validLogIn(String username) {
        Allure.step("Выполнение входа с валидным пользователем: " + username, () -> {
            Allure.parameter("Имя пользователя", username);
            Allure.step("Выполнение авторизации", () -> {
                page(LoginPage.class).logInAsValidUser(username);
            });
            Allure.step("Проверка отсутствия кнопки входа", () ->
                    Assert.assertFalse(LoginPage.loginBtn.isDisplayed(),
                    "Кнопка входа должна исчезнуть после успешной авторизации"));
        });
    }
    @Epic("Авторизация")
    @Feature("Неуспешная авторизация")
    @Story("Негативные сценарии входа")
    @Description("Тест покрывает кейсы 3p002, 3p007, 3p008 - Вход с невалидными данными")
    @Test(dataProvider = "invalidLoginData")
    public void invalidLogIn(String username) {
        Allure.step("Попытка входа с невалидным пользователем: " + username, () -> {
            Allure.parameter("Имя пользователя", username);
            Allure.step("Выполнение авторизации с невалидными данными", () -> {
                page(LoginPage.class).logInAsInvalidUser(username);
            });
            Allure.step("Проверка сохранения кнопки входа", () ->
                    Assert.assertTrue(LoginPage.loginBtn.isDisplayed(),
                    "Кнопка входа должна остаться видимой после неудачной авторизации"));
            Allure.step("Проверка отображения сообщения об ошибке", () ->
                    Assert.assertTrue(LoginPage.errorMassage.isDisplayed(),
                    "Должно отображаться сообщение об ошибке при неудачной авторизации"));
        });
    }
}