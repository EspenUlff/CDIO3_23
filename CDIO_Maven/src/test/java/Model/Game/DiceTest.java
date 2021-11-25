package Model.Game;

import static org.junit.jupiter.api.Assertions.*;

class DiceTest {
    @org.junit.jupiter.api.Test
    void testRoll() {
        int[] rolls = Dice.roll(2, 6);
        assertEquals(2, rolls.length);
        assertTrue(rolls[0] <= 6 && rolls[0] >= 1);
        assertTrue(rolls[1] <= 6 && rolls[1] >= 1);
    }
}