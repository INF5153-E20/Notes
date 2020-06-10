package inf5153.Rules.Tiles;

import inf5153.Rules.Actions.Action;
import inf5153.Rules.Actions.EndGameAction;

import java.util.stream.Stream;

public class EndGameTile implements Tile {
    @Override
    public Stream<Action> getActions() {
        return Stream.of(new EndGameAction());
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return "E";
    }
}
