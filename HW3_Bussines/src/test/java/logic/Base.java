package logic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.LoginPage;
import pages.PlayerEditPage;
import pages.PlayersInsertPage;
import pages.PlayersPage;

/**
 * Created by Admin on 24.09.2015.
 */
public class Base {
    public WebDriver driver;
    public LoginPage loginPage;
    public PlayersPage playersPage;
    public PlayersInsertPage playersInsertPage;
    public PlayerEditPage playerEditPage;
    public String getActualName;
    public String getActualEmail;
    public String getActualFirstName;
    public String getActualLastName;
    public String getActualCity;
    public String getActualAddress;
    public String getActualPhone;
    public String getActualGender;



    public void enter() {
        driver = new FirefoxDriver();
        loginPage = new LoginPage(driver);
        loginPage.setUrl("http://193.138.245.222:81/auth/login");
        loginPage.setName("admin");
        loginPage.setPassword("123");
        loginPage.clickLoginButton();
    }

    public void exit() {
        driver.close();
    }

    public void loginAction(String loginUrl, String login, String password) {
        driver = new FirefoxDriver();
        loginPage = new LoginPage(driver);
        loginPage.setUrl(loginUrl);
        loginPage.setName(login);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();

    }

    public void createPlayerAction() {
        //driver = new FirefoxDriver();
        playersPage = new PlayersPage(driver);
        playersPage.clickInsertButton();

    }

    public void insertPlayerAction(String name, String playersPassword, String expectedPlayersEmail, String expectedName, String playerPassword, String expectedEmail, String expectedFirstName,
                                   String expectedLastName, String expectedCity, String expectedAddress, String expectedPhone
    ) {
        playersInsertPage = new PlayersInsertPage(driver);
        playersInsertPage.setName(expectedName);
        playersInsertPage.setEmail(expectedEmail);
        playersInsertPage.setPlayersPassword(playerPassword);
        playersInsertPage.setConfirmPlayersPassword(playerPassword);
        playersInsertPage.setFirstName(expectedFirstName);
        playersInsertPage.setLastName(expectedLastName);
        playersInsertPage.setCity(expectedCity);
        playersInsertPage.setAddress(expectedAddress);
        playersInsertPage.setPhone(expectedPhone);
        playersInsertPage.getGender();
        playersInsertPage.clickSaveButton();

    }

    public void findNewPlayerAction(String expectedEmail) {

        //driver = new FirefoxDriver();
        playersPage.setSearchByEmailCell(expectedEmail);
        playersPage.clickSearchButton();
        playersPage.getActualPlayerBalance();
        playersPage.getActualPlayerFunBalance();
        playersPage.clickEditButton();

    }
    public Base() {
            playerEditPage = new PlayerEditPage(driver);
            playerEditPage.getActualName();
            playerEditPage.getActualEmail();
            playerEditPage.getActualFirstName();
            playerEditPage.getActualLastName();
            playerEditPage.getActualCity();
            playerEditPage.getActualAddress();
            playerEditPage.getActualPhone();
            playerEditPage.getActualGender();
        }

    }



