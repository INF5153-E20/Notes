package inf5153.Rules.Actions;

import inf5153.Controllers.GameController;
import inf5153.Controllers.GameInterface;
import inf5153.Rules.Board;
import inf5153.Rules.Player;

import java.util.stream.Stream;

public class LoseCoinsAction implements Action {
    @Override
    public boolean execute(GameInterface controller) {
        controller.getOtherPlayers().forEach(p -> {
            int remove = Math.min(2, p.getCoins());
            p.gainCoins(0 - remove);
        });
        return false;
    }

    @Override
    public boolean isAllowed(GameInterface controller) {
        return true;
    }

    @Override
    public String toString() {
        return "Make everybody else lose 2 coins";
    }
}
