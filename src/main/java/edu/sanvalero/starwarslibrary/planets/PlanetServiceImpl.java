package edu.sanvalero.starwarslibrary.planets;

import edu.sanvalero.starwarslibrary.planets.dto.PlanetInDto;
import edu.sanvalero.starwarslibrary.planets.dto.PlanetOutDto;
import edu.sanvalero.starwarslibrary.planets.exception.PlanetInvalidPatchParameterException;
import edu.sanvalero.starwarslibrary.planets.exception.PlanetNotFoundException;
import edu.sanvalero.starwarslibrary.planets.model.Planet;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PlanetServiceImpl implements PlanetService {
    @Autowired
    private PlanetRepository planetRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<PlanetOutDto> get() {
        List<Planet> planets = planetRepository.findAll();
        List<PlanetOutDto> out = getPlanetOutDtos(planets);
        return out;
    }

    @Override
    public PlanetOutDto get(long id) {
        return getPlanetOutDto(getPlanetOrFail(id));
    }

    @Override
    public PlanetOutDto post(PlanetInDto planetInDto) {
        Planet newPlanet = new Planet();
        modelMapper.map(planetInDto, newPlanet);
        planetRepository.save(newPlanet);
        return getPlanetOutDto(newPlanet);
    }

    @Override
    public PlanetOutDto put(long id, PlanetInDto planetInDto) {
        Planet planet = getPlanetOrFail(id);
        modelMapper.map(planetInDto, planet);
        planetRepository.save(planet);
        return getPlanetOutDto(planet);
    }

    @Override
    public PlanetOutDto patch(long id, Map<String, Object> patchParameters) {
        Planet planet = getPlanetOrFail(id);
        patchParameters.forEach((key, value) -> {
            switch (key) {
                case "name":
                    planet.setName(String.valueOf(value));
                    break;
                case "meanTemperature":
                    planet.setMeanTemperature(Float.parseFloat(String.valueOf(value)));
                    break;
                case "terrain":
                    planet.setTerrain(String.valueOf(value));
                    break;
                case "climate":
                    planet.setClimate(String.valueOf(value));
                    break;
                default:
                    throw new PlanetInvalidPatchParameterException(key);
            }
        });
        planetRepository.save(planet);
        return getPlanetOutDto(planet);
    }

    @Override
    public void delete(long id) {
        getPlanetOrFail(id);
        planetRepository.deleteById(id);
    }

    private Planet getPlanetOrFail(long id) {
        return planetRepository.findById(id).orElseThrow(() -> new PlanetNotFoundException(id));
    }

    private PlanetOutDto getPlanetOutDto(Planet planet) {
        PlanetOutDto out = new PlanetOutDto();
        modelMapper.map(planet, out);
        return out;
    }

    private List<PlanetOutDto> getPlanetOutDtos(List<Planet> planets) {
        List<PlanetOutDto> out = new ArrayList<>();
        planets.forEach(planet -> out.add(getPlanetOutDto(planet)));
        return out;
    }
}
