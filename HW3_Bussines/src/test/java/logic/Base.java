package logic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.LoginPage;

/**
 * Created by Admin on 24.09.2015.
 */
public class Base {
    public WebDriver driver;
    public LoginPage loginPage;

    @BeforeTest
    public void enter() {
        driver = new FirefoxDriver();
        loginPage = new LoginPage(driver);
        loginPage.setUrl("http://193.138.245.222:81/auth/login");

    }

    @AfterTest
    public void exit() {
        driver.close();
    }

    public void loginAction(String login, String password) {
        loginPage.setName(login);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();

    }

    }



