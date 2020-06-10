package inf5153.Rules.Actions;

import inf5153.Controllers.GameController;
import inf5153.Rules.Board;
import inf5153.Rules.Player;

import java.util.stream.Stream;

public class GainCoinsAction implements Action {
    @Override
    public boolean execute(GameController controller) {
        controller.getCurrentPlayer().gainCoins(5);
        return false;
    }

    @Override
    public boolean isAllowed(GameController controller) {
        return true;
    }

    @Override
    public String toString() {
        return "Gain 5 coins";
    }
}
