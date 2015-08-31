package com.amin.montyhall;

import java.util.Random;

public class GameEngine {

    private final Random generator;
    private final InputOutput userInteraction;
    private final int DOORS = 3; // We assume there are only three doors
                                 // in the game.

    /**
     * Private constructor for the class. Called by the factory method
     * getGameEngine to instantiate the game engine.
     * 
     * @param userInteraction
     *            Interface to deal with users input and output stuff.
     * @see getGameEngine
     */
    private GameEngine(InputOutput userInteraction) {
        this.generator = new Random();
        this.userInteraction = userInteraction;
    }

    // using factory method instead of calling constructor directly
    public static GameEngine getGameEngine(InputOutput userInteraction) {
        GameEngine gameEngine = new GameEngine(userInteraction);
        return gameEngine;
    }

    /**
     * The actual game player method. This method calls another private method
     * (chooseOtherMethod). It runs the game infinitely until the user wishes to
     * quit!
     * 
     */
    public void playGame() {
        while (true) {
            Door<?> userChoice = userInteraction.getPrimaryDoorNumber(DOORS);
            Door<?> prizeDoor = generateRandomDoorInRange(DOORS);
            Door<?> hostChoice = pickAnotherDoor(prizeDoor, userChoice);
            Door<?> finalUserChoice = userInteraction.offerChange(userChoice, hostChoice, DOORS);
            userInteraction.printGameResult(finalUserChoice.getDoor().equals(prizeDoor.getDoor()));
            if (!userInteraction.continueOrEndGame()) {
                break;
            }
        }
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
    private Door<Integer> pickAnotherDoor(Door<?> prizeDoor, Door<?> userChoice) {
        Door<Integer> anotherDoor;
        do
            anotherDoor = generateRandomDoorInRange(DOORS);
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
    public Door<Integer> generateRandomDoorInRange(int range) {
        int randomNumber = generator.nextInt(range) + 1;
        Door<Integer> randomDoor = new Door<Integer>();
        randomDoor.setDoor(randomNumber);
        return randomDoor;
    }

}
