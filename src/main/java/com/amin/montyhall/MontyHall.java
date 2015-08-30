package com.amin.montyhall;

/**
 * Main class for the MontyHall game.
 * 
 * @author Amin
 * 
 */
public class MontyHall {

    public static void main(String[] args) {
        InputOutputI userInteraction = new InputOutputFactory().getInputOutput();
        GameEngine montyHall = GameEngine.getGameEngine(userInteraction);
        montyHall.playGame();
    }
}
