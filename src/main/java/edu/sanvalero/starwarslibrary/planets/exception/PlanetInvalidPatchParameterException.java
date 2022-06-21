package edu.sanvalero.starwarslibrary.planets.exception;

public class PlanetInvalidPatchParameterException extends RuntimeException {

    public PlanetInvalidPatchParameterException() {
        super();
    }

    public PlanetInvalidPatchParameterException(String key) {
        super(String.format("Parameter '%s' to update on planet unknown or not allowed", key));
    }
}
