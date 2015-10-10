package tests;

import logic.InsertPageAct;
import logic.PlayersPageAct;
import objects.BuilderPokerPlayer;
import objects.PokerPlayer;
import org.testng.annotations.Test;
import pages.PlayerEditPage;
import pages.PlayersInsertPage;
import tools.SoftAsserts;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Admin on 21.09.2015.
 */
public class CreatePlayerTest extends BaseTest {

    @Test
    public void testCreatePlayer() throws InterruptedException {
        //test values
        DateFormat nameCore = new SimpleDateFormat("MMddHHmmss");
        Date date = new Date();
        String expectedName = "A" + String.valueOf(nameCore.format(date));

        PokerPlayer expectedPlayer = new BuilderPokerPlayer()
                .withName(expectedName)
                .withPassword("password")
                .withEmail(expectedName + "@test.com")
                .withCity(expectedName + "city")
                .withFirstName(expectedName + "first")
                .withLastName(expectedName + "last")
                .withAddress(expectedName + "address")
                .withPhone("+038")
                .withGender("Male")
                .withRealMoney("$0.00")
                .withFunMoney("1000.00")
                .withBonusDollars("$0.000")
                .withLoyaltyPoints("0.00 LP")
                .withPayment(true).build();

        //get Players-Insert page
        playersPage.clickInsertButton(); // TODO вот здесь NullPointerException
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);

        //set values
        PlayersInsertPage insertPage = new PlayersInsertPage(driver);
        InsertPageAct.setNewPlayerData(insertPage, expectedPlayer);
        //click save
        InsertPageAct.clickSaveButton(insertPage);
        //search for Player
        PlayersPageAct.searchPlayer(playersPage, expectedPlayer);
        //get Player-Edit page
        playersPage.clickEditButton();
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        PlayerEditPage playerEditPage = new PlayerEditPage(driver);


        //get players values

        PokerPlayer actualPlayer = new BuilderPokerPlayer()

                .withName(playerEditPage.getActualName())
                .withEmail(playerEditPage.getActualEmail())
                .withFirstName(playerEditPage.getActualFirstName())
                .withLastName(playerEditPage.getActualLastName())
                .withCity(playerEditPage.getActualCity())
                .withAddress(playerEditPage.getActualAddress())
                .withPhone(playerEditPage.getActualPhone())
                .withGender(playerEditPage.getActualGender())
                .withRealMoney(playerEditPage.getActualRealMoney())
                .withFunMoney(playerEditPage.getActualFunMoney())
                .withBonusDollars(playerEditPage.getActualBonusDollars())
                .withLoyaltyPoints(playerEditPage.getActualLoyaltyPoints())
                .withPayment(playerEditPage.getPaymentActualValue()).build();

        //check result values
        SoftAsserts verification = new SoftAsserts();
        verification.assertEquals(actualPlayer.playerName, expectedPlayer.playerName);
        verification.assertEquals(actualPlayer.playerEmail, expectedPlayer.playerEmail);
        verification.assertEquals(actualPlayer.playerFirstName, expectedPlayer.playerFirstName);
        verification.assertEquals(actualPlayer.playerLastName, expectedPlayer.playerLastName);
        verification.assertEquals(actualPlayer.playerCity, expectedPlayer.playerCity);
        verification.assertEquals(actualPlayer.playerAddress, expectedPlayer.playerAddress);
        verification.assertEquals(actualPlayer.playerPhone, expectedPlayer.playerPhone);
        verification.assertEquals(actualPlayer.playerGender, expectedPlayer.playerGender);
        verification.assertEquals(actualPlayer.playerRealMoney, expectedPlayer.playerRealMoney);
        verification.assertEquals(actualPlayer.playerFunMoney, expectedPlayer.playerFunMoney);
        verification.assertEquals(actualPlayer.playerBonusDollars, expectedPlayer.playerBonusDollars);
        verification.assertEquals(actualPlayer.playerLoyaltyPoints, expectedPlayer.playerLoyaltyPoints);
        verification.assertEquals(actualPlayer.payment, expectedPlayer.payment);

        //print errors
        verification.printErrors();
    }
}
