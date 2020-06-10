package inf5153.Controllers;

import inf5153.Directions.CardinalDirection;
import inf5153.Rules.Dice.Die;
import inf5153.Rules.Dice.DieFace;
import inf5153.Rules.Dice.DirectionFace;
import inf5153.Rules.Dice.PowerFace;
import inf5153.Rules.Player;
import inf5153.Views.GameConsoleView;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.List;

public class ShopController {
    private GameConsoleView view;

    public ShopController(GameConsoleView view) {
        this.view = view;
    }

    public void BuyDie(Player p) {
        int size = view.promptDieSize(
                IntStream.of(2, 4, 6, 8)
                .filter(s -> p.getCoins() >= s)
                .boxed()
                .collect(Collectors.toList())
        );

        p.addDie(new Die(size));
        p.gainCoins(-size);
    }

    public void SellDie(Player p) {
        Die die = view.promptSellDie(p.getDice()).get();

        p.removeDie(die);
        p.gainCoins(die.size());
    }

    public void BuyFace(Player p) {
        List<DieFace> faces =
                Stream.concat(
                        Stream.of(new DirectionFace(CardinalDirection.North),
                                new DirectionFace(CardinalDirection.South),
                                new DirectionFace(CardinalDirection.East),
                                new DirectionFace(CardinalDirection.West)),
                        IntStream.range(1, 6)
                                .mapToObj(i -> new PowerFace(i)))
                        .filter(df -> p.getCoins() >= df.getPrice())
                .collect(Collectors.toList());


        DieFace face = view.promptNewDieFace(faces).get();
        Die die = view.promptSellDie(p.getDice()).get();
        DieFace replace = view.promptReplaceDieFace(die.getFaces()).get();

        die.replaceFace(replace, face);
    }
}
