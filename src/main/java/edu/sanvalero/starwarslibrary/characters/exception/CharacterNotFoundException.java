package edu.sanvalero.starwarslibrary.characters.exception;

public class CharacterNotFoundException extends RuntimeException {

    public CharacterNotFoundException() {
        super();
    }

    public CharacterNotFoundException(String message) {
        super(message);
    }

    public CharacterNotFoundException(long id) {
        super("Error retrieving data for planet with ID: " + id);
    }
}
