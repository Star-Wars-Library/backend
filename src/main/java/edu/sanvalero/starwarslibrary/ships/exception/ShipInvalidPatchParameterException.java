package edu.sanvalero.starwarslibrary.ships.exception;

public class ShipInvalidPatchParameterException extends RuntimeException {

    public ShipInvalidPatchParameterException() {
        super();
    }

    public ShipInvalidPatchParameterException(String key) {
        super(String.format("Parameter '%s' to update on ship unknown or not allowed", key));
    }
}
