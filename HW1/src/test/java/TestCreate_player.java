import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Admin on 19.09.2015.
 */
public class TestCreate_player {
    WebDriver driver = new FirefoxDriver();
    DateFormat nameCore = new SimpleDateFormat("MMddHHmmss");
    Date date = new Date();
    String expectedName = "a" + String.valueOf(nameCore.format(date));
    String password = "Password";
    String expectedMail = expectedName + "@test.com";
    String expectedFirstName = expectedName + "first";
    String expectedLastName = expectedName + "last";
    String expectedCity = expectedName + "city";
    String expectedAdress = expectedName + "adress";
    String expectedPhone = "+038";

    @Test
    public void CreatePlayerTest() throws InterruptedException {

        // act
        driver.navigate().to("http://193.138.245.222:81/auth/login");
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123");
        driver.findElement(By.id("logIn")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[text()='Insert']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id='ff14642ac1c__us_login']")).sendKeys(expectedName);
        driver.findElement(By.xpath("//input[@id='ff14642ac1c__us_email']")).sendKeys(expectedMail);
        driver.findElement(By.xpath("//input[@id='ff14642ac1c__us_password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='ff14642ac1c__confirm_password']")).sendKeys(password);
        driver.findElement(By.cssSelector("input[id='ff14642ac1c__us_fname']")).sendKeys(expectedFirstName);
        driver.findElement(By.cssSelector("input[id='ff14642ac1c__us_lname']")).sendKeys(expectedLastName);
        driver.findElement(By.cssSelector("input[id='ff14642ac1c__us_city']")).sendKeys(expectedCity);
        driver.findElement(By.cssSelector("textarea[id='ff14642ac1c__us_address']")).sendKeys((expectedAdress));
        driver.findElement(By.cssSelector("input[id='ff14642ac1c__us_phone']")).sendKeys(expectedPhone);
        String expectedGender = driver.findElement(By.cssSelector("select[id='ff14642ac1c__us_gender']")).getAttribute("value");
        driver.findElement(By.xpath("//input[@value='Save']")).click();
        Thread.sleep(3000);

        // get actual values
        driver.findElement(By.xpath("//input[@id='723a925886__email']")).sendKeys(expectedMail);
        driver.findElement(By.xpath("//input[@value='Search']")).click();
        Thread.sleep(3000);
        String actualPlayerBalance = driver.findElement(By.xpath("//parent::tbody/child::tr[position()=2]/child::td[position()=6]")).
                getAttribute("value");
        String actualFunBalance = driver.findElement(By.xpath("//parent::tbody/child::tr[position()=2]/child::td[position()=7]")).
                getAttribute("value");
        driver.findElement(By.cssSelector("img[alt=\"Edit\"]")).click();
        Thread.sleep(3000);
        String actualName = driver.findElement(By.cssSelector("input#ff14642ac1c__us_login")).getAttribute("value");
        String actualMail = driver.findElement(By.cssSelector("input#ff14642ac1c__us_email")).getAttribute("value");
        String actualFirstName = driver.findElement(By.id("ff14642ac1c__us_fname")).getAttribute("value");
        String actualLastName = driver.findElement(By.id("ff14642ac1c__us_lname")).getAttribute("value");
        String actualCity = driver.findElement(By.id("ff14642ac1c__us_city")).getAttribute("value");
        String actualPhone = driver.findElement(By.id("ff14642ac1c__us_phone")).getAttribute("value");
        String actualAdress = driver.findElement(By.cssSelector("textarea[id='ff14642ac1c__us_address']")).getAttribute("value");
        String actualGender = driver.findElement(By.cssSelector("select#ff14642ac1c__us_gender")).getAttribute("value");

        //assertion
        Assert.assertEquals(actualPlayerBalance, "0.00");
        Assert.assertEquals(actualFunBalance, "1,000.00");
        Assert.assertEquals(actualName, expectedName);
        Assert.assertEquals(actualMail, expectedMail);
        Assert.assertEquals(actualCity, expectedCity);
        Assert.assertEquals(actualPhone, expectedPhone);
        Assert.assertEquals(actualAdress, expectedAdress);
        Assert.assertEquals(actualGender, expectedGender);
        Assert.assertEquals(actualFirstName, expectedFirstName);
        Assert.assertEquals(actualLastName, expectedLastName);


    }
}
