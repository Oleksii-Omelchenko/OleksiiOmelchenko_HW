package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import tools.SoftAsserts;

/**
 * Created by Admin on 10.10.2015.
 */
public class LoginTests extends BaseTest {
    @Override
    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        SoftAsserts verification = new SoftAsserts();
        verification.clearListOfErrors();
        loginPage = new LoginPage(driver);
        loginPage.setUrl("http://193.138.245.222:81/auth/login");
    }
    @Test(priority = 1)
        public void LoginTestPositive() throws InterruptedException {
        //test value
        String expectedTitle = "Players";
        //act
        loginPage.setName("admin");
        loginPage.setPassword("123");
        loginPage.clickLoginButton();
        tools.waitForPageToLoad(driver);
        //check result
        SoftAsserts verification = new SoftAsserts();
        verification.assertEquals(driver.getTitle(), expectedTitle);
        //print errors
        verification.printErrors();

        }


    @Test(priority = 2)
    public void LoginTestNegative() throws InterruptedException {
        //act
        loginPage.setName("test");
        loginPage.setPassword("123");
        loginPage.clickLoginButton();
        tools.waitForPageToLoad(driver);
        SoftAsserts verification = new SoftAsserts();
        String message = driver.findElement(By.cssSelector(".errors>li")).getText();
        //check result
        verification.assertEquals(message, "Invalid username or password");
        //print errors
        verification.printErrors();

    }
}
