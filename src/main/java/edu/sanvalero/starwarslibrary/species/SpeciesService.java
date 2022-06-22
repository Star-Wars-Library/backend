package edu.sanvalero.starwarslibrary.species;

import edu.sanvalero.starwarslibrary.species.dto.SpeciesInDto;
import edu.sanvalero.starwarslibrary.species.dto.SpeciesOutDto;

import java.util.Map;
import java.util.Set;

public interface SpeciesService {
    Set<SpeciesOutDto> get();

    SpeciesOutDto get(long id);

    SpeciesOutDto post(SpeciesInDto speciesInDto);

    SpeciesOutDto put(long id, SpeciesInDto speciesInDto);

    SpeciesOutDto patch(long id, Map<String, Object> patchParameters);

    void delete(long id);
}
