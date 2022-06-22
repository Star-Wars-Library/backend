package edu.sanvalero.starwarslibrary.species.dto;

import edu.sanvalero.starwarslibrary.shared.dto.BaseOutDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpeciesOutDto extends BaseOutDto {
    long nativePlanet;
    String language;
    float meanHeight;
    float meanLifespan;
}
