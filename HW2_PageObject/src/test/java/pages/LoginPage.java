package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by Admin on 21.09.2015.
 */

public class LoginPage {
    protected WebDriver driver;

    //username
    @FindBy(id = "username")
    WebElement login;
    //password
    @FindBy(id = "password")
    WebElement password;
    //login button
    @FindBy(id = "logIn")
    WebElement loginButton;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setName(String log) {
        login.sendKeys(log);

    }


    public void setPassword(String pas) {
        password.sendKeys(pas);

    }

    public void clickLoginButton() {
        loginButton.click();

    }
}
