package inf5153.Rules.Actions;

import inf5153.Controllers.GameController;
import inf5153.Rules.Board;
import inf5153.Rules.Player;

import java.util.stream.Stream;

public class LoseCoinsAction implements Action {
    @Override
    public boolean execute(GameController controller) {
        controller.getOtherPlayers().forEach(p -> p.gainCoins(-2));
        return false;
    }

    @Override
    public boolean isAllowed(GameController controller) {
        return true;
    }

    @Override
    public String toString() {
        return "Make everybody else lose 2 coins";
    }
}
