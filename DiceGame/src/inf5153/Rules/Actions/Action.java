package inf5153.Rules.Actions;

import inf5153.Controllers.GameController;

/**
 * Created by wflag on 2020-06-08.
 */
public interface Action {
    boolean execute(GameController controller);
    boolean isAllowed(GameController controller);
}
