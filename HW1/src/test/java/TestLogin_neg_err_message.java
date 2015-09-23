import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Admin on 19.09.2015.
 */
public class TestLogin_neg_err_message {
    WebDriver driver = new FirefoxDriver();

    @Test
    public void LoginNegativeTest() throws InterruptedException {
        driver.navigate().to("http://193.138.245.222:81/auth/login");
        driver.findElement(By.id("username")).sendKeys("1111");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("1111");
        driver.findElement(By.id("logIn")).click();
        Thread.sleep(4000);
        String message = driver.findElement(By.cssSelector(".errors>li")).getText();
        Assert.assertEquals(message, "Invalid username or password");
        driver.close();
    }

}
