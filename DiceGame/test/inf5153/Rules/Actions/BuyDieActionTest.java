package inf5153.Rules.Actions;

import inf5153.Controllers.ShopController;
import inf5153.Rules.Player;
import int5153.ConsoleMock;
import int5153.GameMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by wflag on 2020-07-20.
 */
class BuyDieActionTest {
    private ConsoleMock console;
    private ShopController shop;
    private GameMock game;
    private Action action;

    @BeforeEach
    void setUp() {
        console = new ConsoleMock();
        shop = new ShopController(console);
        game = new GameMock();
        game.setShop(shop);
        action = new BuyDieAction();
    }

    @Test
    void execute() {
        // Arrange
        Player p = new Player(1);
        p.gainCoins(5);

        game.setCurrentPlayer(p);
        console.setPromptDieSize(4);

        // Act
        action.execute(game);
        int resultDice = p.getDice().get(p.getDice().size() - 1).size();
        int resultCoins = p.getCoins();

        // Assert
        assertEquals(4, resultDice);
        assertEquals(1, resultCoins);
    }

    @Test
    void shopChoices() {
        // Arrange
        Player p = new Player(1);
        p.gainCoins(5);

        game.setCurrentPlayer(p);
        console.setPromptDieSize(4);

        // Act
        action.execute(game);
        List<Integer> result = console.getLastDieSizes();

        // Assert
        assertEquals(2, (int)result.get(0));
        assertEquals(4, (int)result.get(1));
        assertEquals(2, result.size());
    }

    @Test
    void isAllowed() {
        // Arrange
        Player p = new Player(1);
        p.gainCoins(2);

        game.setCurrentPlayer(p);

        // Act
        boolean result = action.isAllowed(game);

        // Assert
        assertTrue(result);
    }

    @Test
    void isNotAllowed() {
        // Arrange
        Player p = new Player(1);
        p.gainCoins(1);

        game.setCurrentPlayer(p);

        // Act
        boolean result = action.isAllowed(game);

        // Assert
        assertFalse(result);
    }
}