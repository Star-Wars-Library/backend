package edu.sanvalero.starwarslibrary.ships.dto;

import edu.sanvalero.starwarslibrary.shared.dto.BaseOutDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShipOutDto extends BaseOutDto {
    String model;
    String constructor;
    float length;
}
