package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import tools.SoftAsserts;

import java.util.concurrent.TimeUnit;

/**
 * Created by Admin on 09.10.2015.
 */
public class LoginTestNegative extends BaseTest{
    @Override
    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        SoftAsserts verification = new SoftAsserts();
        verification.clearListOfErrors();
        loginPage = new LoginPage(driver);
        loginPage.setUrl("http://193.138.245.222:81/auth/login");
        loginPage.setName("test");
        loginPage.setPassword("123");
        loginPage.clickLoginButton();
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
    }

    @Test
    public void LoginTestNegative() throws InterruptedException {
        SoftAsserts verification = new SoftAsserts();
        String message = driver.findElement(By.cssSelector(".errors>li")).getText();
        //check result
        verification.assertEquals(message, "Invalid username or password");
        //print errors
        verification.printErrors();

    }
}
