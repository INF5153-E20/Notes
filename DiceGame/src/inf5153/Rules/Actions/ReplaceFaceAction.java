package inf5153.Rules.Actions;

import inf5153.Controllers.GameInterface;
import inf5153.Rules.Player;

public class ReplaceFaceAction implements Action {
    @Override
    public boolean execute(GameInterface controller) {
        controller.getShop().BuyFace(controller.getCurrentPlayer());
        return false;
    }

    @Override
    public boolean isAllowed(GameInterface controller) {
        Player p = controller.getCurrentPlayer();
        return p.getCoins() > 0 && p.getDice().size() > 0;
    }

    @Override
    public String toString() {
        return "Replace a die face";
    }
}
