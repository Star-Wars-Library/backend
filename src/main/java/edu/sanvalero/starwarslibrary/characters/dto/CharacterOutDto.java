package edu.sanvalero.starwarslibrary.characters.dto;

import edu.sanvalero.starwarslibrary.shared.dto.BaseOutDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharacterOutDto extends BaseOutDto {
    String gender;
    LocalDate yearBirth;
    Boolean forceSensitive;
    long species;
    long ship;
    long weapon;
    long homeWorld;
}
