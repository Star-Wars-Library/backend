package edu.sanvalero.starwarslibrary.planets.dto;

import edu.sanvalero.starwarslibrary.shared.dto.BaseOutDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanetOutDto extends BaseOutDto {
    String name;
    float meanTemperature;
    String terrain;
    String climate;
}
