package tests;

import logic.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Admin on 24.09.2015.
 */
public class LoginTests extends Base{
    WebDriver driver;
    // test values
    protected String loginUrl = "http://193.138.245.222:81/auth/login";
    protected String mainLogin = "admin";
    protected String invalidLogin = "test";
    protected String mainPassword = "123";
    protected String expectedTitle = "Players";

    @Test
    protected void LoginTestPositive() throws InterruptedException {
        //act
        loginAction(loginUrl, mainLogin, mainPassword);
        Thread.sleep(4000);
        //check result
        Assert.assertEquals(driver.getTitle(), expectedTitle);
        exit();
    }

    @Test
    protected void LoginTestNegative() throws InterruptedException {
        //act
        loginAction(loginUrl, invalidLogin, mainPassword);
        Thread.sleep(4000);
        String message = driver.findElement(By.cssSelector(".errors>li")).getText();
        //check result
        Assert.assertEquals(message, "Invalid username or password");
        exit();
    }
}
