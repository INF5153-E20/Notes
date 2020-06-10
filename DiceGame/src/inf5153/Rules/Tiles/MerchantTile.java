package inf5153.Rules.Tiles;

import inf5153.Rules.Actions.Action;
import inf5153.Rules.Actions.BuyDieAction;
import inf5153.Rules.Actions.ReplaceFaceAction;
import inf5153.Rules.Actions.SellDieAction;

import java.util.stream.Stream;

public class MerchantTile implements Tile {
    @Override
    public Stream<Action> getActions() {
        return Stream.of(new BuyDieAction(), new SellDieAction(), new ReplaceFaceAction());
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return "M";
    }
}
