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
                .withEmail(expectedName + "@test.com")
                .withPassword("password")
                .withCity("city")
                .withFirstName("first")
                .withLastName("last")
                .withAddress("address")
                .withPhone("+038")
                .withGender("Female")
                .withRealMoney("$0.00")
                .withFunMoney("1,000.00")
                .withBonusDollars("$0.00")
                .withLoyaltyPoints("0.00 LP")
                .withPayment(true).build();

        //get Players-Insert page
        PlayersInsertPage insertPage = playersPage.clickInsertButton();
        tools.waitForPageToLoad(driver);
        //set values
        InsertPageAct.setNewPlayerData(insertPage, expectedPlayer);
        //click save
        InsertPageAct.clickSaveButton(insertPage);
        tools.waitForPageToLoad(driver);
        //search for Player
        PlayersPageAct.searchPlayer(playersPage, expectedPlayer);
        //get Player-Edit page
        PlayerEditPage playerEditPage = playersPage.clickEditButton();

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
