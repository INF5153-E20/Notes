package inf5153.Rules.Actions;

import inf5153.Controllers.GameInterface;

public class SellDieAction implements Action {
    @Override
    public boolean execute(GameInterface controller) {
        controller.getShop().SellDie(controller.getCurrentPlayer());
        return false;
    }

    @Override
    public boolean isAllowed(GameInterface controller) {
        return controller.getCurrentPlayer().getDice().size() > 0;
    }

    @Override
    public String toString() {
        return "Sell a die";
    }
}
