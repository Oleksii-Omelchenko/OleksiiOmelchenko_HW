import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/**
 * Created by Admin on 19.09.2015.
 */
public class TestLogin_pos {
    WebDriver driver = new FirefoxDriver();

    @Test
    public void LoginPositiveTest() throws InterruptedException {
        driver.navigate().to("http://193.138.245.222:81/auth/login");
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123");
        driver.findElement(By.id("logIn")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//a[img [@alt='logout']][span[@class='logout']]")).click();
        driver.close();
    }
}
