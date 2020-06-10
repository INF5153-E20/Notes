package inf5153.Rules.Tiles;

import inf5153.Rules.Actions.Action;
import inf5153.Rules.Actions.DoNothingAction;

import java.util.stream.Stream;

public class NormalTile implements Tile {
    @Override
    public Stream<Action> getActions() {
        return Stream.of(new DoNothingAction());
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return " ";
    }
}
