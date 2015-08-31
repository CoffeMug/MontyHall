package com.amin.montyhall;

/**
 * Main class for the MontyHall game.
 * 
 * @author Amin
 * 
 */
public class MontyHall {

    public static void main(String[] args) {
        GameEngine montyHall = GameEngine.getGameEngine(new InputOutputFactory().getInputOutput(),
                ConcreteDoor.createDoor());
        montyHall.playGame();
    }
}
