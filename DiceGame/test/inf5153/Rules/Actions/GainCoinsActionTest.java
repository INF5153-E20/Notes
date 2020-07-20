package inf5153.Rules.Actions;

import inf5153.Rules.Player;
import int5153.GameMock;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by wflag on 2020-07-20.
 */
class GainCoinsActionTest {
    private static Action action;

    @BeforeAll
    public static void Setup() {
        action = new GainCoinsAction();
    }

    @Test
    void execute() {
        // Arrange
        Player player = new Player(1);
        int coins = player.getCoins();

        GameMock controller = new GameMock();
        controller.setCurrentPlayer(player);

        // Act
        action.execute(controller);
        int result = player.getCoins();

        // Assert
        assertEquals(coins + 5, result);
    }

    @Test
    void isAllowed() {
        assertTrue(action.isAllowed(new GameMock()));
    }
}