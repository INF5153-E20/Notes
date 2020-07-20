package inf5153.Rules.Actions;

import inf5153.Rules.Player;
import int5153.GameMock;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by wflag on 2020-07-20.
 */
class LoseCoinsActionTest {
    private static Action action;

    @BeforeAll
    public static void Setup() {
        action = new LoseCoinsAction();
    }

    @Test
    void execute() {
        // Arrange
        List<Player> players = new ArrayList<>();
        players.add(new Player(1));
        players.add(new Player(2));
        players.add(new Player(3));
        for(Player p : players)
            p.gainCoins(5);

        int coins = players.get(0).getCoins();

        GameMock controller = new GameMock();
        controller.setOtherPlayers(players);

        // Act
        action.execute(controller);
        List<Integer> playerCoins =
                players.stream()
                        .map(Player::getCoins)
                        .collect(Collectors.toList());

        // Assert
        for(int results : playerCoins)
            assertEquals(coins - 2, results);
    }

    @Test
    void executeNoCoins() {
        // Arrange
        List<Player> players = new ArrayList<>();
        players.add(new Player(1));

        GameMock controller = new GameMock();
        controller.setOtherPlayers(players);

        // Act
        action.execute(controller);
        int result = players.get(0).getCoins();

        // Assert
        assertEquals(0, result);
    }

    @Test
    void executeOneCoins() {
        // Arrange
        List<Player> players = new ArrayList<>();
        players.add(new Player(1));
        players.get(0).gainCoins(1);

        GameMock controller = new GameMock();
        controller.setOtherPlayers(players);

        // Act
        action.execute(controller);
        int result = players.get(0).getCoins();

        // Assert
        assertEquals(0, result);
    }

    @Test
    void isAllowed() {
        assertTrue(action.isAllowed(new GameMock()));
    }
}