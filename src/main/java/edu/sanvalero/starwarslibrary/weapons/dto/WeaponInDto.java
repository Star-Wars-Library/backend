package edu.sanvalero.starwarslibrary.weapons.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeaponInDto {
    String name;
    String techLevel;
    int ammunition;
    float weight;
}
