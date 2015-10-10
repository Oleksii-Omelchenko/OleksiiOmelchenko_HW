package tests;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import tools.SoftAsserts;

import java.util.concurrent.TimeUnit;

/**
 * Created by Admin on 24.09.2015.
 */
public class LoginTestPositive extends BaseTest {


    @Override
    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        SoftAsserts verification = new SoftAsserts();
        verification.clearListOfErrors();
        loginPage = new LoginPage(driver);
        loginPage.setUrl("http://193.138.245.222:81/auth/login");
        loginPage.setName("admin");
        loginPage.setPassword("123");
        loginPage.clickLoginButton();
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
    }
    @Test
    public void LoginTestPositive() throws InterruptedException {
        //test value
        String expectedTitle = "Players";
        //check result
        SoftAsserts verification = new SoftAsserts();
        verification.assertEquals(driver.getTitle(), expectedTitle);
        //print errors
        verification.printErrors();

    }

}
