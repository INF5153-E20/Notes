package inf5153.Rules;

import inf5153.Directions.Direction;
import inf5153.Rules.Actions.Action;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created by wflag on 2020-07-20.
 */
public interface BoardInterface {
    void init(List<Player> players);

    Stream<Action> move(Player token, Direction direction, int distance);
}
