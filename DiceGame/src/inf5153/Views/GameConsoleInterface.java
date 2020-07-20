package inf5153.Views;

import inf5153.Directions.Direction;
import inf5153.Rules.Actions.Action;
import inf5153.Rules.Dice.Die;
import inf5153.Rules.Dice.DieFace;
import inf5153.Rules.Player;

import java.util.List;
import java.util.Optional;

/**
 * Created by wflag on 2020-07-20.
 */
public interface GameConsoleInterface {
    int promptNumberOfPlayers(int max);

    void printPlayer(Player p);

    void printFace(DieFace f);

    void printGrid(String[][] printedGrid);

    Optional<Direction> promptDirection(List<Direction> directions);

    Optional<Action> promptAction(List<Action> actions);

    int promptDistance(int maxPower);

    int promptDieSize(List<Integer> dieSizes);

    Optional<Die> promptSellDie(List<Die> dice);

    Optional<DieFace> promptNewDieFace(List<DieFace> faces);

    Optional<DieFace> promptReplaceDieFace(List<DieFace> faces);

    void declareWinner(Player p);
}
