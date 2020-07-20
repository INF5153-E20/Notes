package inf5153.Controllers;

import inf5153.Directions.CardinalDirection;
import inf5153.Directions.Direction;
import inf5153.Rules.Dice.DieFace;
import inf5153.Rules.Dice.DirectionFace;
import inf5153.Rules.Dice.PowerFace;
import inf5153.Rules.Player;
import int5153.BoardMock;
import int5153.ConsoleMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by wflag on 2020-07-20.
 */
class GameControllerTest {
    private BoardMock board;
    private GameController game;
    private ConsoleMock console;

    @BeforeEach
    void setUp() {
        board = new BoardMock();
        console = new ConsoleMock();
        game = new GameController(board, console);
    }

    @Test
    void movePlayerSingleDirection() {
        // Arrange
        Player p = new Player(1);
        List<DieFace> faces = new ArrayList<>();
        faces.add(new DirectionFace(CardinalDirection.South));
        faces.add(new PowerFace(4));
        console.setDirection(CardinalDirection.South);

        // Act
        game.movePlayer(p, faces);
        List<Direction> results = console.getDirections();

        // Assert
        assertEquals(1, results.size());
        assertEquals(CardinalDirection.South, results.get(0));
    }

    @Test
    void movePlayer() {
        // Arrange
        Player p = new Player(1);
        List<DieFace> faces = new ArrayList<>();
        faces.add(new DirectionFace(CardinalDirection.South));
        faces.add(new PowerFace(4));
        console.setDirection(CardinalDirection.South);
        console.setDistance(3);

        // Act
        game.movePlayer(p, faces);
        Direction direction = board.getDirection();
        int distance = board.getDistance();

        // Assert
        assertEquals(CardinalDirection.South, direction);
        assertEquals(3, distance);
    }
}