package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.LoginPage;

/**
 * Created by Admin on 24.09.2015.
 */
public class BaseLogin {
    WebDriver driver;
    protected String loginUrl = "http://193.138.245.222:81/auth/login";
    protected String mainLogin = "admin";
    protected String mainPassword = "123";
    public void loginAction(){
            driver = new FirefoxDriver();
            driver.get(loginUrl);
            LoginPage loginPage = new LoginPage(driver);
            loginPage.setName(mainLogin);
            loginPage.setPassword(mainPassword);
            loginPage.clickLoginButton();
    }

}
