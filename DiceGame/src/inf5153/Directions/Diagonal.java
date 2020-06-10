package inf5153.Directions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by wflag on 2020-06-08.
 */
public class Diagonal implements Direction {
    private CardinalDirection direction1;
    private CardinalDirection direction2;

    public static List<Direction> getDiagonals(List<Direction> directions) {
        return Stream.of(
                new Diagonal(CardinalDirection.North, CardinalDirection.East),
                new Diagonal(CardinalDirection.North, CardinalDirection.West),
                new Diagonal(CardinalDirection.South, CardinalDirection.East),
                new Diagonal(CardinalDirection.South, CardinalDirection.West))
                .filter(d -> directions.contains(d.direction1) && directions.contains(d.direction2))
                .collect(Collectors.toList());
    }

    private Diagonal(CardinalDirection d1, CardinalDirection d2) {
        direction1 = d1;
        direction2 = d2;
    }

    @Override
    public List<CardinalDirection> getDirections() {
        ArrayList<CardinalDirection> list = new ArrayList<>();
        list.add(direction1);
        list.add(direction2);

        return list;
    }

    @Override
    public String toString() {
        return String.format("%s/%s", direction1, direction2);
    }
}
