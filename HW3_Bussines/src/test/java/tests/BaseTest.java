package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.PlayersPage;
import tools.SoftAsserts;
import tools.Tools;

/**
 * Created by Admin on 24.09.2015.
 */
public class BaseTest {
    public WebDriver driver;
    public LoginPage loginPage;
    public PlayersPage playersPage;
    public Tools tools = new Tools();


    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        loginPage = new LoginPage(driver);
        playersPage = new PlayersPage(driver);
        SoftAsserts verification = new SoftAsserts();
        verification.clearListOfErrors();
        loginPage.setUrl("http://193.138.245.222:81/auth/login");
        loginPage.setName("admin");
        loginPage.setPassword("123");
        loginPage.clickLoginButton();
        tools.waitForPageToLoad(driver);

    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    }





