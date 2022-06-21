package edu.sanvalero.starwarslibrary.planets.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanetInDto {
    String name;
    float meanTemperature;
    String terrain;
    String climate;
}
