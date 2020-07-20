package inf5153.Controllers;

import inf5153.Rules.Player;

/**
 * Created by wflag on 2020-07-20.
 */
public interface GameInterface {
    ShopController getShop();

    Player getCurrentPlayer();

    Iterable<Player> getOtherPlayers();
}
