package com.amin.montyhall;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameEngineTest {

    private final int RANGE = 10;
    private final int INVALIDRANGE = -10;

    @Test
    public void testGenerateRandomNumberInRange() {

        InputOutput userInteraction = new InputOutputFactory().getInputOutput();
        GameEngine testGameEngine = GameEngine.getGameEngine(userInteraction);

        Door<Integer> randomNum = testGameEngine.generateRandomDoorInRange(RANGE);

        assertTrue("Error, generated random number out of range", RANGE >= randomNum.getDoor());
        assertTrue("Error, generated random number out of range", 1 <= randomNum.getDoor());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGenerateRandomNumberInvalidRange() {

        InputOutput userInteraction = new InputOutputFactory().getInputOutput();
        GameEngine testGameEngine = GameEngine.getGameEngine(userInteraction);
        testGameEngine.generateRandomDoorInRange(INVALIDRANGE);

    }

}
