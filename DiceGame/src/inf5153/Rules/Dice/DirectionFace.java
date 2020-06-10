package inf5153.Rules.Dice;

import inf5153.Directions.Direction;

import java.util.Optional;

/**
 * Created by wflag on 2020-06-08.
 */
public class DirectionFace extends DieFace {
    private Direction direction;

    public DirectionFace(Direction d) {
        direction = d;
    }

    @Override
    public Optional<Direction> getDirection() {
        return Optional.of(direction);
    }

    @Override
    public int getPrice() {
        return 1;
    }

    @Override
    public String toString() {
        return direction.toString();
    }
}
