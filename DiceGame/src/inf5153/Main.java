package inf5153;

import inf5153.Controllers.GameController;
import inf5153.Rules.Board;
import inf5153.Views.GameConsoleView;

public class Main {

    public static void main(String[] args) {
        GameController game = new GameController(
                new Board(),
                new GameConsoleView());
        game.startGame();
    }
}
