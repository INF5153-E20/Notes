package inf5153.Rules.Actions;

import inf5153.Controllers.GameInterface;

public class BuyDieAction implements Action {
    @Override
    public boolean execute(GameInterface controller) {
        controller.getShop().BuyDie(controller.getCurrentPlayer());
        return false;
    }

    @Override
    public boolean isAllowed(GameInterface controller) {
        return controller.getCurrentPlayer().getCoins() >= 2;
    }

    @Override
    public String toString() {
        return "Buy a new die";
    }
}
