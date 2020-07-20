package inf5153.Controllers;

import inf5153.Directions.CardinalDirection;
import inf5153.Directions.Diagonal;
import inf5153.Directions.Direction;
import inf5153.Rules.Actions.Action;
import inf5153.Rules.BoardInterface;
import inf5153.Rules.Dice.Die;
import inf5153.Rules.Dice.DieFace;
import inf5153.Rules.Dice.DirectionFace;
import inf5153.Rules.Dice.PowerFace;
import inf5153.Rules.Player;
import inf5153.Views.GameConsoleInterface;
import inf5153.Views.GameConsoleView;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by wflag on 2020-06-08.
 */
public class GameController implements GameInterface {
    private List<Player> players;
    private BoardInterface board;
    private Player currentPlayer;
    private GameConsoleInterface view;
    private ShopController shopController;

    public GameController(BoardInterface board, GameConsoleInterface console) {
        this.board = board;
        this.view = console;
        this.shopController = new ShopController(view);
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public List<Player> getOtherPlayers() {
        return players.stream()
                .filter(p -> p != currentPlayer)
                .collect(Collectors.toList());
    }

    public ShopController getShop() {
        return shopController;
    }

    public void startGame() {
        int players = view.promptNumberOfPlayers(4);

        this.players = IntStream.range(1, players + 1)
                .mapToObj(this::createPlayer)
                .collect(Collectors.toList());

        board.init(this.players);

        runGame();

        view.declareWinner(calculateWinner());
    }

    private Player createPlayer(int number) {
        Player p = new Player(number);
        p.addDie(new Die(Stream.of(
                new DirectionFace(CardinalDirection.East),
                new DirectionFace(CardinalDirection.West),
                new DirectionFace(CardinalDirection.North),
                new DirectionFace(CardinalDirection.South))));
        p.addDie(new Die(Stream.of(
                new PowerFace(1),
                new PowerFace(2),
                new PowerFace(3),
                new PowerFace(4))));

        p.gainCoins(2);

        return p;
    }

    private void runGame() {
        while(true) {
            for (Player p : players) {
                //view.printGrid(board.print());
                if (playerTurn(p))
                    // End the game.
                    return;
            }
        }
    }

    private boolean playerTurn(Player player) {
        List<DieFace> faces = player.rollDice();

        //faces.forEach(view::printFace);

        List<Action> actions = movePlayer(player, faces);
        List<Action> allowedActions = actions.stream()
                .filter(a -> a.isAllowed(this))
                .collect(Collectors.toList());
        Optional<Action> action = chooseAction(allowedActions);

        if(action != null)
            return action.get().execute(this);
        else return false;
    }

    private Optional<Direction> chooseDirection(List<DieFace> faces) {
        List<Direction> cardinals = faces.stream()
                .map(DieFace::getDirection)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .distinct()
                .collect(Collectors.toList());

        List<Direction> diagonals = Diagonal.getDiagonals(cardinals);

        List<Direction> directions = Stream.concat(cardinals.stream(), diagonals.stream()).collect(Collectors.toList());

        return view.promptDirection(directions);
    }

    private int chooseDistance(List<DieFace> faces) {
        int power = faces.stream()
                .map(DieFace::getPower)
                .reduce(Integer::sum)
                .get();

        return view.promptDistance(power);
    }

    protected List<Action> movePlayer(Player p, List<DieFace> rollResults) {
        while(true) {
            view.printPlayer(p);

            Optional<Direction> direction = chooseDirection(rollResults);
            int distance = 0;

            if(direction.isPresent())
                distance = chooseDistance(rollResults);

            Stream<Action> actions = board.move(p, direction.orElse(CardinalDirection.North), distance);

            // Move is valid if an action list is returned.
            if(actions != null) {
                return actions.collect(Collectors.toList());
            }
        }
    }

    private Optional<Action> chooseAction(List<Action> actions) {
        return view.promptAction(actions.stream().collect(Collectors.toList()));
    }

    private Player calculateWinner() {
        // Get the maximum number of coins owned by a player.
        int maxCoins = players.stream()
                .map(Player::getCoins)
                .max(Integer::compare).get();

        // Gets the players owning that amount of coins.
        List<Player> maxCoinsPlayers = players.stream()
                .filter(p -> p.getCoins() == maxCoins)
                .collect(Collectors.toList());

        // If there's more than one, we need to check their power.
        if(maxCoinsPlayers.size() > 1)
        {
            // Get the maximum power owned by a player.
            int maxPower = maxCoinsPlayers.stream()
                    .map(Player::getPower)
                    .max(Integer::compare).get();

            // Gets the players owning that amount of power.
            List<Player> maxPowerPlayers = maxCoinsPlayers.stream()
                    .filter(p -> p.getPower() == maxPower)
                    .collect(Collectors.toList());

            // If there's more than one, no player wins.
            if(maxPowerPlayers.size() > 1)
                return null;

            // Return the only player.
            return maxPowerPlayers.get(0);
        }

        // Return the only player.
        return maxCoinsPlayers.get(0);
    }
}
