package com.amin.montyhall;

/**
 * This interface is the specification for the input and output sub system. It
 * has some methods which must be implemented by every class which will be
 * responsible for taking care of input and output stuff.
 * 
 * @author Amin
 *
 */
public interface InputOutputI {

    /**
     * Get the primary door number selected first by player.
     * 
     * @param doors
     *            Total number of doors available in the game.
     * @return An integer containing the door number selected by the user.
     * @throws InvalidInputException
     */
    public int getPrimaryDoorNumber(int doors);

    /**
     * Specification of the output printer.
     * 
     * @param result
     *            Boolean representing the final game result (win or loose).
     */
    public void printGameResult(boolean result);

    /**
     * Infinite loop asking player to continue the game or to quit.
     * 
     * @return true if player says continue otherwise false.
     */
    public boolean continueOrEndGame();

    /**
     * Offers the player opportunity to change his/her mind after the host
     * showing one empty door.
     * 
     * @param primaryChoice
     *            First selected door by the player.
     * @param emptyChoice
     *            The door that host opens and is empty.
     * @param doors
     *            Total number of doors available in the game.
     * @return Door number as final selection of the player.
     */
    public int offerChange(int primaryChoice, int emptyChoice, int doors);

}
