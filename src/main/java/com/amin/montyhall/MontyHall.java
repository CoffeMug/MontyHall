package com.amin.montyhall;

/**
 * Main class for the MontyHall game.
 * 
 * @author Amin
 * 
 */
public class MontyHall {

    private static final int DOORS = 3; // Total number of doors in the game!

    public static void main(String[] args) {
        playGame(new InputOutputFactory().getInputOutput(), ConcreteDoor.createDoor());
    }

    /**
     * The actual game player method. It runs the game infinitely until the user
     * wishes to quit!
     * 
     */
    private static void playGame(InputOutput userInteraction, ConcreteDoor door) {
        while (true) {
            ConcreteDoor userChoice = userInteraction.getPrimaryDoorNumber(DOORS);
            ConcreteDoor prizeDoor = door.generateRandomDoorInRange(DOORS);
            ConcreteDoor hostChoice = door.pickAnotherDoor(prizeDoor, userChoice, DOORS);
            ConcreteDoor finalUserChoice = userInteraction.offerChange(userChoice, hostChoice, DOORS);
            userInteraction.showGameResult(finalUserChoice.getDoor().equals(prizeDoor.getDoor()));
            if (!userInteraction.continueOrEndGame()) {
                break;
            }
        }
    }

}
