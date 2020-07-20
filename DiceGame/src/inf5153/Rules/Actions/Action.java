package inf5153.Rules.Actions;

import inf5153.Controllers.GameInterface;

/**
 * Created by wflag on 2020-06-08.
 */
public interface Action {
    boolean execute(GameInterface controller);
    boolean isAllowed(GameInterface controller);
}
