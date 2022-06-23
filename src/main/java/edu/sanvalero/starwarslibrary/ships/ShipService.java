package edu.sanvalero.starwarslibrary.ships;

import edu.sanvalero.starwarslibrary.ships.dto.ShipInDto;
import edu.sanvalero.starwarslibrary.ships.dto.ShipOutDto;

import java.util.List;
import java.util.Map;

public interface ShipService {
    List<ShipOutDto> get();

    ShipOutDto get(long id);

    ShipOutDto post(ShipInDto shipInDto);

    ShipOutDto put(long id, ShipInDto shipInDto);

    ShipOutDto patch(long id, Map<String, Object> patchParameters);

    void delete(long id);
}
