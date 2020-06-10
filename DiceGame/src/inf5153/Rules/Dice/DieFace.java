package inf5153.Rules.Dice;

import inf5153.Directions.Direction;

import java.util.Optional;

/**
 * Created by wflag on 2020-06-08.
 */
public abstract class DieFace {
    public Optional<Direction> getDirection() {
        return Optional.empty();
    }

    public int getPower() {
        return 0;
    }

    public abstract int getPrice();
}
