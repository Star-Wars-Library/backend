package edu.sanvalero.starwarslibrary.ships.exception;

public class ShipNotFoundException extends RuntimeException {

    public ShipNotFoundException() {
        super();
    }

    public ShipNotFoundException(String message) {
        super(message);
    }

    public ShipNotFoundException(long id) {
        super("Error retrieving data for ship with ID: " + id);
    }
}
