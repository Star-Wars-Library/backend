package edu.sanvalero.starwarslibrary.species.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpeciesInDto {
    long nativePlanet;
    String language;
    float meanHeight;
    float meanLifespan;
}
