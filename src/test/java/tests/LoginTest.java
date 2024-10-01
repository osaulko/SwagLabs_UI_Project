package tests;

import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(priority = 1, description = "Кейс номер 3p001")
    public void validLogIn() {
        new LoginPage()
                .enterValidUsername()
                .enterPassword()
                .clickLoginBtn()
                .verifyThatLoginPageIsClosed();
    }
    @Test(priority = 2, description = "Кейс номер 3p002")
    public void lockedOutLogIn() {
        new LoginPage()
                .enterLockedUsername()
                .enterPassword()
                .clickLoginBtn()
                .errorMassageDisplayed()
                .verifyThatLoginPageIsOpened();
    }
    @Test(priority = 3, description = "Кейс номер 3p003")
    public void problemUserLogIn() {
        new LoginPage()
                .enterProblemUsername()
                .enterPassword()
                .clickLoginBtn()
                .verifyThatLoginPageIsClosed();
    }
    @Test(priority = 4, description = "Кейс номер 3p004")
    public void performanceGlitchLogIn() {
        new LoginPage()
                .enterPerformanceGlitchUsername()
                .enterPassword()
                .clickLoginBtn()
                .verifyThatLoginPageIsClosed();
    }
    @Test(priority = 5, description = "Кейс номер 3p005")
    public void errorUserLogIn() {
        new LoginPage()
                .enterErrorUsername()
                .enterPassword()
                .clickLoginBtn()
                .verifyThatLoginPageIsClosed();
    }
    @Test(priority = 6, description = "Кейс номер 3p006")
    public void visualUserLogIn() {
        new LoginPage()
                .enterVisualUsername()
                .enterPassword()
                .clickLoginBtn()
                .verifyThatLoginPageIsClosed();
    }
    @Test(priority = 7, description = "Кейс номер 3p007")
    public void invalidLogIn() {
        new LoginPage()
                .enterInvalidUsername()
                .enterPassword()
                .clickLoginBtn()
                .errorMassageDisplayed()
                .verifyThatLoginPageIsOpened();
    }
    @Test(priority = 8, description = "Кейс номер 3p008")
    public void logInWithoutUsername() {
        new LoginPage()
                .enterPassword()
                .clickLoginBtn()
                .errorMassageDisplayed()
                .verifyThatLoginPageIsOpened();
    }
}
