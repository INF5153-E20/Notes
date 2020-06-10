package inf5153.Rules;

import inf5153.Rules.Dice.Die;
import inf5153.Rules.Dice.DieFace;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wflag on 2020-06-08.
 */
public class Player {
    private int number;
    private int coins;
    private Coordinates position;
    private List<Die> dice = new ArrayList<>();

    public int getNumber() {
        return number;
    }

    public Player(int number) {
        this.number = number;
    }

    public Coordinates getPosition() {
        return position;
    }

    public void setPosition(Coordinates position) {
        this.position = position;
    }

    public int getPower() {
        return dice.stream().map(Die::getPower).reduce(Integer::sum).get();
    }

    public int getCoins() {
        return coins;
    }

    public void gainCoins(int n) {
        coins += n;
    }

    public List<Die> getDice() {
        return dice;
    }

    public void addDie(Die die) {
        dice.add(die);
    }

    public void removeDie(Die die) {
        dice.remove(die);
    }

    public List<DieFace> rollDice() {
        return dice.stream().map(Die::roll).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return String.format("Player %d", number);
    }
}
