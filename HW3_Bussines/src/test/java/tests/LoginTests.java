package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Admin on 24.09.2015.
 */
public class LoginTests {
    WebDriver driver;


    @Test
    public void LoginTestPositive() throws InterruptedException {

        BaseLogin baseLogin = new BaseLogin();
        baseLogin.loginAction(driver);

       /*// driver = new FirefoxDriver();
        //act
        //driver.get(loginUrl);
        LoginPage loginPage = new LoginPage(driver);
       /* loginPage.setName(mainLogin);
        loginPage.setPassword(mainPassword);
        loginPage.clickLoginButton();*/
        Thread.sleep(4000);
        //check result
        String expectedTitle = "Players";
        Assert.assertEquals(driver.getTitle(), expectedTitle);
        driver.close();
    }
/* @Test
    public void LoginTestNegative() throws InterruptedException {
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
    }*/
}
