package com.amin.montyhall;

/**
 * The generic door class to support the domain model for the solution of the
 * MontyHall problem.
 * 
 * @author amin
 *
 * @param <T>
 *            Generic door type. It can be integer or String for example.
 */
public class Door<T> {

    private T door;

    public T getDoor() {
        return door;
    }

    public void setDoor(T door) {
        this.door = door;
    }

    @Override
    public String toString() {
        return "Door " + this.door.toString();
    }

}
