package com.amin.montyhall;

/**
 * The factory class which is used for instantiating the corresponding
 * input/output subsystem by the MontyHall class.
 * 
 * @author Amin
 *
 */
public class InputOutputFactory {
    public InputOutput getInputOutput() {
        return new ConsoleInputOutput();
    }
}
