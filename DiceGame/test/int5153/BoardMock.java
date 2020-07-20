package int5153;

import inf5153.Directions.Direction;
import inf5153.Rules.Actions.Action;
import inf5153.Rules.Actions.DoNothingAction;
import inf5153.Rules.BoardInterface;
import inf5153.Rules.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by wflag on 2020-07-20.
 */
public class BoardMock implements BoardInterface {
    private List<Action> moveAction = new ArrayList<>();
    private int distance;
    private Direction direction;

    public BoardMock() {
        moveAction.add(new DoNothingAction());
    }

    @Override
    public void init(List<Player> players) {

    }

    @Override
    public Stream<Action> move(Player token, Direction direction, int distance) {
        this.direction = direction;
        this.distance = distance;
        return moveAction.stream();
    }

    public int getDistance() {
        return distance;
    }

    public Direction getDirection() {
        return direction;
    }
}
