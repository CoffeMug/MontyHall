package com.amin.montyhall;

import static org.junit.Assert.*;

import org.junit.Test;

public class RandomGeneratorTest {

    private final int RANGE = 10;
    private final int INVALIDRANGE = -10;

    @Test
    public void testGenerateRandomNumberInRange() {

        ConcreteDoor door = ConcreteDoor.createDoor();
        ConcreteDoor randomNum = (ConcreteDoor) door.generateRandomDoorInRange(RANGE);

        assertTrue("Error, generated random number out of range", RANGE >= randomNum.getDoor());
        assertTrue("Error, generated random number out of range", 1 <= randomNum.getDoor());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGenerateRandomNumberInvalidRange() {

        ConcreteDoor door = ConcreteDoor.createDoor();
        door.generateRandomDoorInRange(INVALIDRANGE);

    }

}
