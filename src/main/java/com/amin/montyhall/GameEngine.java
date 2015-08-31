package com.amin.montyhall;

public class GameEngine {

    private final InputOutput userInteraction;
    private final ConcreteDoor door;
    private static final int DOORS = 3;

    public static int getDOORS() {
        return DOORS;
    }

    /**
     * Private constructor for the class. Called by the factory method
     * getGameEngine to instantiate the game engine.
     * 
     * @param userInteraction
     *            Interface to deal with users input and output stuff.
     * @see getGameEngine
     */
    private GameEngine(InputOutput userInteraction, ConcreteDoor door) {
        this.door = door;
        this.userInteraction = userInteraction;
    }

    // using factory method instead of calling constructor directly
    public static GameEngine getGameEngine(InputOutput userInteraction, ConcreteDoor door) {
        GameEngine gameEngine = new GameEngine(userInteraction, door);
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
            ConcreteDoor userChoice = userInteraction.getPrimaryDoorNumber(DOORS);
            ConcreteDoor prizeDoor = door.generateRandomDoorInRange(DOORS);
            ConcreteDoor hostChoice = door.pickAnotherDoor(prizeDoor, userChoice);
            ConcreteDoor finalUserChoice = userInteraction.offerChange(userChoice, hostChoice, DOORS);
            userInteraction.printGameResult(finalUserChoice.getDoor().equals(prizeDoor.getDoor()));
            if (!userInteraction.continueOrEndGame()) {
                break;
            }
        }
    }

}
