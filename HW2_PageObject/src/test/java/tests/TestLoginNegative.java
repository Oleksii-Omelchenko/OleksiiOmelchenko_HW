package tests;

import pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Admin on 21.09.2015.
 */
public class TestLoginNegative {
    WebDriver driver;
    //test values
    protected String loginUrl = "http://193.138.245.222:81/auth/login";
    protected String invalidLogin = "test";
    protected String mainPassword = "123";

    @Test
    public void LoginPositiveTest() throws InterruptedException {
        driver = new FirefoxDriver();
        //act
        driver.get(loginUrl);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setName(invalidLogin);
        loginPage.setPassword(mainPassword);
        loginPage.clickLoginButton();
        Thread.sleep(4000);
        String message = driver.findElement(By.cssSelector(".errors>li")).getText();
        //check result
        Assert.assertEquals(message, "Invalid username or password");
        driver.close();
    }
}
