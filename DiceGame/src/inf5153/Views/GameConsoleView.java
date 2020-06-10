package inf5153.Views;

import inf5153.Directions.Direction;
import inf5153.Rules.Actions.Action;
import inf5153.Rules.Dice.Die;
import inf5153.Rules.Dice.DieFace;
import inf5153.Rules.Player;

import java.util.Optional;
import java.util.Scanner;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameConsoleView {
    private Scanner scanner = new Scanner(System.in);

    private <T> Optional<T> prompt (String prompt, List<T> elements) {
        if(elements.size() > 0) {
            int choice = -1;
            boolean valid = false;

            while (!valid) {
                System.out.println(prompt);

                for (int i = 0; i < elements.size(); i++) {
                    System.out.println(String.format("%d) %s", i + 1, elements.get(i)));
                }

                System.out.print("Your choice: ");
                choice = scanner.nextInt();

                if (choice < 1 || choice > elements.size())
                    System.out.println("Invalid choice.");
                else
                    valid = true;
            }

            return Optional.of(elements.get(choice - 1));
        }

        return Optional.empty();
    }

    private int promptNumber(String prompt, int min, int max) {
        while (true) {
            System.out.println(String.format("%s (%d to %d)", prompt, min, max));

            System.out.print("Your choice: ");
            int choice = scanner.nextInt();

            if (choice < min || choice > max)
                System.out.println("Invalid choice.");
            else
                return choice;
        }
    }

    public int promptNumberOfPlayers(int max) {
        return promptNumber("Choose a number of players.", 2, max);
    }

    public void printPlayer(Player p) {
        System.out.println("----------");
        System.out.println(p);
        System.out.println(String.format("Coins: %d", p.getCoins()));
        System.out.println(String.format("Position: %s", p.getPosition()));
        System.out.println("----------");
    }

    public void printFace(DieFace f) {
        System.out.println(String.format("Rolled: %s", f));
    }

    public void printGrid(String[][] printedGrid) {
        for(int y = 0; y < printedGrid.length; y++) {
            for(int x = 0; x < printedGrid[y].length; x++)
                System.out.print(printedGrid[y][x]);
            System.out.println();
        }
    }

    public Optional<Direction> promptDirection(List<Direction> directions) {
        return prompt("Choose a direction.", directions);
    }

    public Optional<Action> promptAction(List<Action> actions) {
        return prompt("Choose an action.", actions);
    }

    public int promptDistance(int maxPower) {
        return promptNumber("Choose a distance.", 0, maxPower);
    }

    public int promptDieSize(List<Integer> dieSizes) {
        return prompt("Choose a die size.", dieSizes).orElse(0);
    }

    public Optional<Die> promptSellDie(List<Die> dice) {
        return prompt("Choose a die to sell.", dice);
    }

    public Optional<DieFace> promptNewDieFace(List<DieFace> faces) {
        return prompt("Choose a new die face.", faces);
    }

    public Optional<DieFace> promptReplaceDieFace(List<DieFace> faces) {
        return prompt("Choose a die face to replace.", faces);
    }

    public void declareWinner(Player p) {
        if(p != null)
            System.out.println(String.format("%d is the winner!", p));
        else
            System.out.println("Everybody loses!");
    }
}
