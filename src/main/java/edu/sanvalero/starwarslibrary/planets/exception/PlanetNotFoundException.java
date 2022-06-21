package edu.sanvalero.starwarslibrary.planets.exception;

public class PlanetNotFoundException extends RuntimeException {

    public PlanetNotFoundException() {
        super();
    }

    public PlanetNotFoundException(String message) {
        super(message);
    }

    public PlanetNotFoundException(long id) {
        super("Error retrieving data for planet with ID: " + id);
    }
}
