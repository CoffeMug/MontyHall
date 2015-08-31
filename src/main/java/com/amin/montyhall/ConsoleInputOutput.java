package com.amin.montyhall;

import java.util.Scanner;

/**
 * The concrete class responsible for providing the user input and output via
 * the console. It implements the InputOutput interface and overrides the
 * Corresponding methods based on the console input/output requirements.
 * 
 * @author Amin
 *
 */
public class ConsoleInputOutput implements InputOutput {

    private Scanner scan = new Scanner(System.in);

    /**
     * Gets the door number from user on the normal console via interactive user
     * input. Returns the number selected by the player.
     * 
     * @return Integer containing the door number primarily selected by the
     *         user.
     * 
     */
    @Override
    public ConcreteDoor getPrimaryDoorNumber(int doors) {
        doorSelectionMenu();
        ConcreteDoor doorNumber = getDoor(scan, doors);
        return doorNumber;
    }

    /**
     * Print outs the final game results to the console.
     * 
     * @param result
     *            The final result of the game - win(true) or loose(false).
     */
    @Override
    public void showGameResult(boolean result) {

        if (result) {
            System.out.println("Congratulations! You won. :-)\n");
        } else {
            System.out.println("You loose! :-( \n");
        }
    }

    /**
     * This method is responsible for offering a suggestion to the user and ask
     * him/her if they want to change the primary selection based on the fact
     * that host has already shown an empty door.
     * 
     * @param primaryChoice
     *            The primary selected door by user
     * @param nullChoice
     *            The door opened by host which is empty
     * @param doors
     *            Total number of doors available in the game.
     * 
     * @return integer containing the final door selected by the player.
     * 
     */
    @Override
    public ConcreteDoor offerChange(ConcreteDoor primaryChoice, ConcreteDoor nullChoice, int doors) {
        System.out.println("You selected " + primaryChoice + ".\n");
        System.out.println(nullChoice + " is opened and is empty!\n");
        System.out.println("You can keep your selection or change it.\n");
        System.out.println("Enter the final door number to see the results!");
        ConcreteDoor choice = getDoor(scan, doors);
        return choice;
    }

    /**
     * Infinite loop asking user if to continue playing the game or quit.
     * 
     * @return true or false based on the decision by player to continue playing
     *         or to quit the game.
     */
    @Override
    public boolean continueOrEndGame() {
        System.out.println("Would you like to play again?(Y/N)");
        while (true) {
            char reply = scan.next().charAt(0);
            if (reply == 'y' || reply == 'Y') {
                return true;
            } else if (reply == 'n' || reply == 'N') {
                scan.close(); // Game ends. Close the scanner!
                return false;
            } else {
                System.out.println("Please answer with Y or N!");
            }
        }
    }

    /**
     * Tiny method which is responsible to printout the door selection menu.
     */
    private void doorSelectionMenu() {
        System.out.println("Please select a door number: \n");
        System.out.println("1     2     3");
    }

    /**
     * This function gets the door which player selects. It also checks if the
     * selection is valid which means that it is an integer between 1 and DOORS.
     * 
     * @param scan
     *            The scanner used for user interaction.
     * @param doors
     *            The total number of doors available in the game.
     * @return The door number selected by the player.
     */
    private ConcreteDoor getDoor(Scanner scan, int doors) {
        int doorNumber = scan.nextInt();

        while ((doorNumber < 1) || (doorNumber > doors)) {
            System.out.println("Please pick a valid door number!");
            doorNumber = scan.nextInt();
        }
        ConcreteDoor door = ConcreteDoor.createDoor();
        door.setDoor(doorNumber);
        return door;
    }

}
