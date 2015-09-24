package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PlayerEditPage;
import pages.PlayersInsertPage;
import pages.PlayersPage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Admin on 21.09.2015.
 */
public class CreatePlayerTests {
    WebDriver driver;
    protected String loginUrl = "http://193.138.245.222:81/auth/login";
    protected String mainLogin = "admin";
    protected String mainPassword = "123";
    DateFormat nameCore = new SimpleDateFormat("MMddHHmmss");
    Date date = new Date();
    protected String expectedName = "a" + String.valueOf(nameCore.format(date));
    protected String playersPassword = "Password";
    protected String expectedPlayersEmail = (expectedName + "@test.com");
    protected String expectedFirstName = expectedName + "first";
    protected String expectedLastName = expectedName + "last";
    protected String expectedCity = expectedName + "city";
    protected String expectedAddress = expectedName + "adress";
    protected String expectedPhone = "+038";
    protected String expectedGender = "Male";
    protected String expectedPlayerBalance = "0.00";
    protected String expectedFunBalance = "1,000.00";


    @Test
    public void testCreatePlayer() throws InterruptedException {
        driver = new FirefoxDriver();

        //act on LoginPage
        BaseLogin baseLogin = new BaseLogin();
        baseLogin.loginAction();
        Thread.sleep(4000);

        //act on PlayersPage
        PlayersPage playersPage = new PlayersPage(driver);
        playersPage.clickInsertButton();
        Thread.sleep(4000);

        //act on PlayersInsertPage
        PlayersInsertPage playersInsertPage = new PlayersInsertPage(driver);
        playersInsertPage.setName(expectedName);
        playersInsertPage.setPlayersPassword(playersPassword);
        playersInsertPage.setConfirmPlayersPassword(playersPassword);
        playersInsertPage.setEmail(expectedPlayersEmail);
        playersInsertPage.setFirstName(expectedFirstName);
        playersInsertPage.setLastName(expectedLastName);
        playersInsertPage.setCity(expectedCity);
        playersInsertPage.setAddress(expectedAddress);
        playersInsertPage.setPhone(expectedPhone);
        playersInsertPage.getGender();
        playersInsertPage.clickSaveButton();
        Thread.sleep(4000);

        //act on PlayersPage
        playersPage.setSearchByEmailCell(expectedPlayersEmail);
        playersPage.clickSearchButton();
        Thread.sleep(4000);
        //get actual results
        String actualPlayerBalance = playersPage.getActualPlayerBalance();
        String actualFunBalance = playersPage.getActualPlayerFunBalance();
        playersPage.clickEditButton();
        Thread.sleep(4000);

        //act on PlayerEditPage
        PlayerEditPage playersEditPage = new PlayerEditPage(driver);
        String actualName = playersEditPage.getActualName();
        String actualEmail = playersEditPage.getActualEmail();
        String actualFirstName = playersEditPage.getActualFirstName();
        String actualLastName = playersEditPage.getActualLastName();
        String actualCity = playersEditPage.getCity();
        String actualAddress = playersEditPage.getAddress();
        String actualPhone = playersEditPage.getPhone();
        String actualGender = playersEditPage.getGender();


        // check results
        Assert.assertEquals(actualName, expectedName);
        Assert.assertEquals(actualEmail, expectedPlayersEmail);
        Assert.assertEquals(actualFirstName, expectedFirstName);
        Assert.assertEquals(actualLastName,expectedLastName);
        Assert.assertEquals(actualCity, expectedCity);
        Assert.assertEquals(actualAddress, expectedAddress);
        Assert.assertEquals(actualPhone, expectedPhone);
        Assert.assertEquals(actualGender,expectedGender);
        Assert.assertEquals(actualPlayerBalance, expectedPlayerBalance);
        Assert.assertEquals(actualFunBalance, expectedFunBalance);
        // postcondition
        driver.close();

    }
}
