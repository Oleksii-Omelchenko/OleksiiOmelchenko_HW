import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by Admin on 19.09.2015.
 */
public class LoginPageObject {
    private WebDriver driver;

    //username
    @FindBy(id = "username")
    WebElement login;
    //password
    @FindBy(id = "password")
    WebElement password;
    //login button
    @FindBy(id = "logIn")
    WebElement loginButton;



    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void typeName(String login) {
        driver.findElement(By.id("username")).sendKeys(login);

    }


    public void typePassword(String password) {
        driver.findElement(By.id("password")).sendKeys(password);

    }

    public void clickOnButtonLogin() {
        driver.findElement(By.id("logIn")).click();

    }
}
