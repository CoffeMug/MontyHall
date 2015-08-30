package com.amin.montyhall;

import java.util.Random;

public class GameEngine {

    private final Random generator;
    private final InputOutputI userInteraction;
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
    private GameEngine(InputOutputI userInteraction) {
        this.generator = new Random();
        this.userInteraction = userInteraction;
    }

    // using factory method instead of calling constructor directly
    public static GameEngine getGameEngine(InputOutputI userInteraction) {
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
            int userChoice = userInteraction.getPrimaryDoorNumber(DOORS);
            int prizeDoor = generateRandomNumberInRange(DOORS);
            int hostChoice = pickAnotherDoor(prizeDoor, userChoice);
            int finalUserChoice = userInteraction.offerChange(userChoice, hostChoice, DOORS);
            userInteraction.printGameResult(finalUserChoice == prizeDoor);
            if (!userInteraction.continueOrEndGame()) {
                break;
            }
        }
    }

    /**
     * Selects a door other than door1 and door2. Does this by keep generating a
     * random number until the requirement is met.
     * 
     * @param door1
     * @param door2
     * @return a door number other than door1 & door2
     */
    private int pickAnotherDoor(int door1, int door2) {
        int result;
        do
            result = generateRandomNumberInRange(DOORS);
        while (result == door1 || result == door2);
        return result;
    }

    /**
     * Generates a random number between 1 and total number of doors. It uses
     * java random class.
     * 
     * @param range
     *            Total number of doors available in the game.
     * @return A random door number.
     */
    public int generateRandomNumberInRange(int range) {
        return generator.nextInt(range) + 1;
    }

}
