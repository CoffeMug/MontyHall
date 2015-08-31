package com.amin.montyhall;

import static org.junit.Assert.*;

import org.junit.Test;

public class DoorTest {

    @Test
    public void testToStringIntegerDoor() {
        ConcreteDoor sampleDoor = ConcreteDoor.createDoor();
        sampleDoor.setDoor(2);

        assertTrue("The two strings are not the same", sampleDoor.toString().equals("Door 2"));
        assertFalse("The two strings are the same", sampleDoor.toString().equals(2));
    }
}