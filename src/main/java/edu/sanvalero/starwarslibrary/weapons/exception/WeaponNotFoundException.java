package edu.sanvalero.starwarslibrary.weapons.exception;

public class WeaponNotFoundException extends RuntimeException {

    public WeaponNotFoundException() {
        super();
    }

    public WeaponNotFoundException(String message) {
        super(message);
    }

    public WeaponNotFoundException(long id) {
        super("Error retrieving data for weapon with ID: " + id);
    }
}
