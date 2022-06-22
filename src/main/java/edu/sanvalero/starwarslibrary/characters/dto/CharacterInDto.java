package edu.sanvalero.starwarslibrary.characters.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharacterInDto {
    String name;
    String gender;
    LocalDate yearBirth;
    Boolean forceSensitive;
    long species;
    long ship;
    long weapon;
    long homeWorld;
}
