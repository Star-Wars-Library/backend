package edu.sanvalero.starwarslibrary.species.exception;

public class SpeciesNotFoundException extends RuntimeException {

    public SpeciesNotFoundException() {
        super();
    }

    public SpeciesNotFoundException(String message) {
        super(message);
    }

    public SpeciesNotFoundException(long id) {
        super("Error retrieving data for species with ID: " + id);
    }
}
