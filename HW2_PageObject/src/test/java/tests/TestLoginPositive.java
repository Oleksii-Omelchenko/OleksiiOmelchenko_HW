package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

/**
 * Created by Admin on 19.09.2015.
 */
public class TestLoginPositive {
    WebDriver driver;
    // test values
    protected String loginUrl = "http://193.138.245.222:81/auth/login";
    protected String mainLogin = "admin";
    protected String mainPassword = "123";
    protected String expectedTitle = "Players";


    @Test
    public void LoginPositiveTest() throws InterruptedException {
        //act
        driver = new FirefoxDriver();
        driver.get(loginUrl);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setName(mainLogin);
        loginPage.setPassword(mainPassword);
        loginPage.clickLoginButton();
        Thread.sleep(4000);
        //check result
        Assert.assertEquals(driver.getTitle(), expectedTitle);
        driver.close();
    }
}