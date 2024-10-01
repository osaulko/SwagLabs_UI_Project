package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;

import java.io.IOException;

public abstract class BaseTest {

    public void setUp(){
        WebDriverManager.chromedriver().setup();
        Configuration.browser="chrome";
        Configuration.headless=false;
        Configuration.browserSize="1920x1080";
    }
    @BeforeMethod()
    public void init() throws IOException {
        setUp();
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("SwagLabs.properties"));
        String BASE_URL = System.getProperty("url");
        Selenide.open(BASE_URL);
    }
    @AfterTest()
    public void tearDown(){
        Selenide.sleep(1000);
        Selenide.closeWebDriver();
    }
}
