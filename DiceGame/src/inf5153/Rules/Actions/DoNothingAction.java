package inf5153.Rules.Actions;

import inf5153.Controllers.GameController;

public class DoNothingAction implements Action {
    @Override
    public boolean execute(GameController controller) {
        return false;
    }

    @Override
    public boolean isAllowed(GameController controller) {
        return true;
    }

    @Override
    public String toString() {
        return "Do nothing";
    }
}
