package inf5153;

import inf5153.Controllers.GameController;
import inf5153.Directions.CardinalDirection;
import inf5153.Directions.Diagonal;
import inf5153.Directions.Direction;
import inf5153.Rules.Dice.DieFace;
import inf5153.Rules.Dice.DirectionFace;

public class Main {

    public static void main(String[] args) {
        GameController game = new GameController();
        game.startGame();
    }
}
