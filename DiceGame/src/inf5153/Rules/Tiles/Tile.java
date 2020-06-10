package inf5153.Rules.Tiles;

import inf5153.Rules.Actions.Action;

import java.util.stream.Stream;

/**
 * Created by wflag on 2020-06-08.
 */
public interface Tile {
    Stream<Action> getActions();
    boolean isSpecial();
}
