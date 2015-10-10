package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.PlayersPage;
import tools.SoftAsserts;

import java.util.concurrent.TimeUnit;

/**
 * Created by Admin on 24.09.2015.
 */
public class BaseTest {
    public WebDriver driver;
    public LoginPage loginPage;
    public PlayersPage playersPage;


    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        loginPage = new LoginPage(driver);
        SoftAsserts verification = new SoftAsserts();
        verification.clearListOfErrors();
        loginPage.setUrl("http://193.138.245.222:81/auth/login");
        loginPage.setName("admin");
        loginPage.setPassword("123");
        loginPage.clickLoginButton();
        //driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    }





