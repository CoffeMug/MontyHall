package com.amin.montyhall;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameEngineTest {
    
    private final int RANGE = 10;
    private final int INVALIDRANGE = -10;

    @Test
    public void testGenerateRandomNumberInRange() {

        InputOutputI userInteraction = new InputOutputFactory().getInputOutput();
        GameEngine testGameEngine = GameEngine.getGameEngine(userInteraction);
        
        int randomNum = testGameEngine.generateRandomNumberInRange(RANGE);
        
        assertTrue("Error, generated random number out of range", RANGE >= randomNum);
        assertTrue("Error, generated random number out of range",  1  <= randomNum);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testGenerateRandomNumberInvalidRange() {

        InputOutputI userInteraction = new InputOutputFactory().getInputOutput();
        GameEngine testGameEngine = GameEngine.getGameEngine(userInteraction);
        testGameEngine.generateRandomNumberInRange(INVALIDRANGE);
        
    }

}
