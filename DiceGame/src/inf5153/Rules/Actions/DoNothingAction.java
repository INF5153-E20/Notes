package inf5153.Rules.Actions;

import inf5153.Controllers.GameInterface;

public class DoNothingAction implements Action {
    @Override
    public boolean execute(GameInterface controller) {
        return false;
    }

    @Override
    public boolean isAllowed(GameInterface controller) {
        return true;
    }

    @Override
    public String toString() {
        return "Do nothing";
    }
}
