package edu.sanvalero.starwarslibrary.characters.exception;

public class CharacterInvalidPatchParameterException extends RuntimeException {

    public CharacterInvalidPatchParameterException() {
        super();
    }

    public CharacterInvalidPatchParameterException(String key) {
        super(String.format("Parameter '%s' to update on planet unknown or not allowed", key));
    }
}
