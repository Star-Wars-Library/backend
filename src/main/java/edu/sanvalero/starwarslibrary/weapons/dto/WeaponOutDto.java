package edu.sanvalero.starwarslibrary.weapons.dto;

import edu.sanvalero.starwarslibrary.shared.dto.BaseOutDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeaponOutDto extends BaseOutDto {
    String techLevel;
    int ammunition;
    float weight;
}
