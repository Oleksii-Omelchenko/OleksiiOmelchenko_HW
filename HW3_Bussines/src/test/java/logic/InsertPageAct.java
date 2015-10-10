package logic;

import objects.PokerPlayer;
import pages.PlayersInsertPage;

/**
 * Created by Admin on 09.10.2015.
 */
public class InsertPageAct {
        public static void setNewPlayerData(PlayersInsertPage playersInsertPage, PokerPlayer expectedPlayer){

            //set values
            playersInsertPage.setName(expectedPlayer.playerName);
            playersInsertPage.setEmail(expectedPlayer.playerEmail);
            playersInsertPage.setPlayersPassword(expectedPlayer.playerPassword);
            playersInsertPage.setConfirmPlayersPassword(expectedPlayer.playerPassword);
            playersInsertPage.setFirstName(expectedPlayer.playerFirstName);
            playersInsertPage.setLastName(expectedPlayer.playerLastName);
            playersInsertPage.setCity(expectedPlayer.playerCity);
            playersInsertPage.setAddress(expectedPlayer.playerAddress);
            playersInsertPage.setPhone(expectedPlayer.playerPhone);

        }



        public static void clickSaveButton(PlayersInsertPage insertPage) {
            insertPage.clickSaveButton();
        }


}

