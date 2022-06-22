package edu.sanvalero.starwarslibrary.ships.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShipInDto {
    String name;
    String model;
    String constructor;
    float length;
}
