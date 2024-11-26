package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;
import static com.codeborne.selenide.Selenide.open;
import static config.PropertyReader.properties;

public abstract class BaseTest {
    String BASE_URL = properties.getProperty("url");
    @DataProvider(name = "validLoginData")
    public Object[] loginDataProvider() {
        return new Object[][] {
                {properties.getProperty("standardUser")},
                {properties.getProperty("problemUser")},
                {properties.getProperty("performanceGlitchUser")},
                {properties.getProperty("errorUser")},
                {properties.getProperty("visualUser")}
        };
    }
    @DataProvider(name = "invalidLoginData")
    public Object[] invalidLoginDataProvider() {
        return new Object[][] {
                {"locked_out_user"},
                {"standard"},
                {""}
        };
    }
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        Configuration.browser="chrome";
        Configuration.headless=false;
        Configuration.browserSize="1920x1080";
    }
    @BeforeMethod()
    public void init(){
        setUp();
        open(BASE_URL);
    }
    @AfterTest()
    public void tearDown(){
        Selenide.closeWebDriver();
    }
}