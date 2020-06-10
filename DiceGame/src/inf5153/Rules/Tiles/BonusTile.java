package inf5153.Rules.Tiles;

import inf5153.Rules.Actions.Action;
import inf5153.Rules.Actions.DoNothingAction;
import inf5153.Rules.Actions.GainCoinsAction;
import inf5153.Rules.Actions.LoseCoinsAction;

import java.util.stream.Stream;

public class BonusTile implements Tile {
    @Override
    public Stream<Action> getActions() {
        return Stream.of(new GainCoinsAction(), new LoseCoinsAction(), new DoNothingAction());
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return "B";
    }
}
