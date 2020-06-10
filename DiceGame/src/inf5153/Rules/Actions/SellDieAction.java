package inf5153.Rules.Actions;

import inf5153.Controllers.GameController;

public class SellDieAction implements Action {
    @Override
    public boolean execute(GameController controller) {
        controller.getShop().SellDie(controller.getCurrentPlayer());
        return false;
    }

    @Override
    public boolean isAllowed(GameController controller) {
        return controller.getCurrentPlayer().getDice().size() > 0;
    }

    @Override
    public String toString() {
        return "Sell a die";
    }
}
