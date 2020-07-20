package int5153;

import inf5153.Directions.Direction;
import inf5153.Rules.Actions.Action;
import inf5153.Rules.Dice.Die;
import inf5153.Rules.Dice.DieFace;
import inf5153.Rules.Player;
import inf5153.Views.GameConsoleInterface;

import java.util.List;
import java.util.Optional;

/**
 * Created by wflag on 2020-07-20.
 */
public class ConsoleMock implements GameConsoleInterface {
    private int promptDieSize;
    private List<Integer> lastDieSizes;
    private Direction direction;
    private List<Direction> directions;
    private int distance;

    @Override
    public int promptNumberOfPlayers(int max) {
        return 0;
    }

    @Override
    public void printPlayer(Player p) {

    }

    @Override
    public void printFace(DieFace f) {

    }

    @Override
    public void printGrid(String[][] printedGrid) {

    }

    @Override
    public Optional<Direction> promptDirection(List<Direction> directions) {
        this.directions = directions;
        return Optional.of(direction);
    }

    @Override
    public Optional<Action> promptAction(List<Action> actions) {
        return null;
    }

    @Override
    public int promptDistance(int maxPower) {
        return distance;
    }

    @Override
    public int promptDieSize(List<Integer> dieSizes) {
        lastDieSizes = dieSizes;
        return promptDieSize;
    }

    @Override
    public Optional<Die> promptSellDie(List<Die> dice) {
        return null;
    }

    @Override
    public Optional<DieFace> promptNewDieFace(List<DieFace> faces) {
        return null;
    }

    @Override
    public Optional<DieFace> promptReplaceDieFace(List<DieFace> faces) {
        return null;
    }

    @Override
    public void declareWinner(Player p) {

    }

    public void setPromptDieSize(int promptDieSize) {
        this.promptDieSize = promptDieSize;
    }

    public List<Integer> getLastDieSizes() {
        return lastDieSizes;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public List<Direction> getDirections() {
        return directions;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
