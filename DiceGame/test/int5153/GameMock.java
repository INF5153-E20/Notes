package int5153;

import inf5153.Controllers.GameInterface;
import inf5153.Controllers.ShopController;
import inf5153.Rules.Player;

import java.util.List;

/**
 * Created by wflag on 2020-07-20.
 */
public class GameMock implements GameInterface {
    private Player currentPlayer;
    private List<Player> otherPlayers;
    private ShopController shop;

    @Override
    public ShopController getShop() {
        return shop;
    }

    @Override
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player p) {
        currentPlayer = p;
    }

    @Override
    public Iterable<Player> getOtherPlayers() {
        return otherPlayers;
    }

    public void setOtherPlayers(List<Player> otherPlayers) {
        this.otherPlayers = otherPlayers;
    }

    public void setShop(ShopController shop) {
        this.shop = shop;
    }
}
