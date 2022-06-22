package edu.sanvalero.starwarslibrary.weapons.exception;

public class WeaponInvalidPatchParameterException extends RuntimeException {

    public WeaponInvalidPatchParameterException() {
        super();
    }

    public WeaponInvalidPatchParameterException(String key) {
        super(String.format("Parameter '%s' to update on weapon unknown or not allowed", key));
    }
}
