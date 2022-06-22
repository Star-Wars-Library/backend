package edu.sanvalero.starwarslibrary.species.exception;

public class SpeciesInvalidPatchParameterException extends RuntimeException {

    public SpeciesInvalidPatchParameterException() {
        super();
    }

    public SpeciesInvalidPatchParameterException(String key) {
        super(String.format("Parameter '%s' to update on species unknown or not allowed", key));
    }
}
