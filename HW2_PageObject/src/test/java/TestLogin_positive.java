import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/**
 * Created by Admin on 19.09.2015.
 */
public class TestLogin_positive {
    WebDriver driver;
    @Test
    public void LoginPositiveTest() {
        driver =  new FirefoxDriver();
        driver.get("http://193.138.245.222:81/auth/login");
        LoginPageObject loginPage = new LoginPageObject(driver);
        loginPage.typeName("admin");
        loginPage.typePassword("123");
        loginPage.clickOnButtonLogin();
    }
}