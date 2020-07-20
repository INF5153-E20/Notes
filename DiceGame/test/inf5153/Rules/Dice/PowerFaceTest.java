package inf5153.Rules.Dice;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by wflag on 2020-07-20.
 */
class PowerFaceTest {
    @Test
    void testToString() {
        // Arrange
        PowerFace face = new PowerFace(3);

        // Act
        String result = face.toString();

        // Assert
        assertEquals("Face: 3", result);
    }
}