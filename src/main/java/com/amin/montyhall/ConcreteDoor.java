package com.amin.montyhall;

import java.util.Random;

public class ConcreteDoor extends Door<Integer> {

    private final Random generator;

    private ConcreteDoor() {
        this.generator = new Random();
    }

    // using factory method instead of calling constructor directly
    public static ConcreteDoor createDoor() {
        ConcreteDoor door = new ConcreteDoor();
        return door;
    }

    /**
     * Selects a door other than door1 and door2. Does this by keep generating a
     * random number until the requirement is met.
     * 
     * @param prizeDoor
     *            The door which has the prize behind.
     * @param userChoice
     *            The door which user has picked as first selection.
     * @return a door number other than door1 & door2
     */
    @Override
    public ConcreteDoor pickAnotherDoor(ConcreteDoor prizeDoor, ConcreteDoor userChoice) {

        ConcreteDoor anotherDoor = ConcreteDoor.createDoor();
        do
            anotherDoor = generateRandomDoorInRange(GameEngine.getDOORS());
        while (anotherDoor.getDoor().equals(prizeDoor.getDoor()) || anotherDoor.getDoor().equals(userChoice.getDoor()));
        return anotherDoor;
    }

    /**
     * Generates a random number between 1 and total number of doors. It uses
     * java random class.
     * 
     * @param range
     *            Total number of doors available in the game.
     * @return A random door number.
     */
    @Override
    public ConcreteDoor generateRandomDoorInRange(int range) {
        int randomNumber = generator.nextInt(range) + 1;
        ConcreteDoor randomDoor = ConcreteDoor.createDoor();
        randomDoor.setDoor(randomNumber);
        return randomDoor;
    }
    
    @Override
    public String toString() {
        return "Door " + super.getDoor().toString();
    }
}
