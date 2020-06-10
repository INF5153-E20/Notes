package inf5153.Directions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wflag on 2020-06-08.
 */
public enum CardinalDirection implements Direction {
    North,
    East,
    South,
    West;

    public List<CardinalDirection> getDirections() {
        ArrayList<CardinalDirection> list = new ArrayList<>();
        list.add(this);

        return list;
    }
}
