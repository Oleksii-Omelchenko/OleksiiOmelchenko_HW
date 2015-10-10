package logic;

import objects.PokerPlayer;
import pages.PlayersPage;

/**
 * Created by Admin on 09.10.2015.
 */
public class PlayersPageAct {

    public static void searchPlayer(PlayersPage playersPage, PokerPlayer expectedPlayer){
        playersPage.setSearchByEmailCell(expectedPlayer.playerEmail);
        playersPage.clickSearchButton();
    }

}
