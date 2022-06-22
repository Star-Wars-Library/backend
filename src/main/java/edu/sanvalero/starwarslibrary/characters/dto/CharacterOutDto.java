package edu.sanvalero.starwarslibrary.characters.dto;

import edu.sanvalero.starwarslibrary.shared.dto.BaseOutDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharacterOutDto extends BaseOutDto {
    String name;
    float meanTemperature;
    String terrain;
    String climate;
}
