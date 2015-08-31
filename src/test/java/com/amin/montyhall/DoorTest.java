package com.amin.montyhall;

import static org.junit.Assert.*;

import org.junit.Test;

public class DoorTest {

    @Test
    public void testToStringIntegerDoor() {
        Door<Integer> sampleDoor = new Door<>();
        sampleDoor.setDoor(2);

        assertTrue("The two strings are the same", sampleDoor.toString().equals("Door 2"));

    }
    
    @Test
    public void testToStringStringDoor() {
        Door<String> sampleDoor = new Door<>();
        sampleDoor.setDoor("3");
        
        assertFalse("The two strings are not the same", sampleDoor.toString().equals("Door 2"));
        assertTrue("The two strings are the same", sampleDoor.toString().equals("Door 3"));

    }
}
