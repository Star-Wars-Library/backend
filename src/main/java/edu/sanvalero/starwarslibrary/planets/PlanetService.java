package edu.sanvalero.starwarslibrary.planets;

import edu.sanvalero.starwarslibrary.planets.dto.PlanetInDto;
import edu.sanvalero.starwarslibrary.planets.dto.PlanetOutDto;

import java.util.Map;
import java.util.Set;

public interface PlanetService {
    Set<PlanetOutDto> get();

    PlanetOutDto get(long id);

    PlanetOutDto post(PlanetInDto planetInDto);

    PlanetOutDto put(long id, PlanetInDto planetInDto);

    PlanetOutDto patch(long id, Map<String, Object> patchParameters);

    void delete(long id);
}
