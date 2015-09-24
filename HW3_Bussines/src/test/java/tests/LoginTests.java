package tests;

import logic.Asserts;
import logic.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/**
 * Created by Admin on 24.09.2015.
 */
public class LoginTests extends Base{
    WebDriver driver;
    // test values
    /*protected String mainLogin = "admin";
    protected String invalidLogin = "test";
    protected String mainPassword = "123";*/
    protected String expectedTitle = "Players";

    @Test
    protected void LoginTestPositive() throws InterruptedException {
        Asserts checking = new Asserts(driver);
        //loginAction(mainLogin, mainPassword);
        loginAction("admin", "123");
        Thread.sleep(4000);
        checking.assertEquals(driver.getTitle(), expectedTitle);

    }

    @Test
    protected void LoginTestNegative() throws InterruptedException {
        Asserts checking = new Asserts(driver);
        //act
        //loginAction(invalidLogin, mainPassword);
        loginAction("test", "123");
        Thread.sleep(4000);
        String message = driver.findElement(By.cssSelector(".errors>li")).getText();
        //check result
       checking.assertEquals(message, "Invalid username or password");

    }
}
