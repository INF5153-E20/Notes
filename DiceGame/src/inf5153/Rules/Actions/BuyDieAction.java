package inf5153.Rules.Actions;

import inf5153.Controllers.GameController;

public class BuyDieAction implements Action {
    @Override
    public boolean execute(GameController controller) {
        controller.getShop().BuyDie(controller.getCurrentPlayer());
        return false;
    }

    @Override
    public boolean isAllowed(GameController controller) {
        return controller.getCurrentPlayer().getCoins() >= 2;
    }

    @Override
    public String toString() {
        return "Buy a new die";
    }
}
