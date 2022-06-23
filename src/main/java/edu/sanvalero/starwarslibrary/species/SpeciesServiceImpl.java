package edu.sanvalero.starwarslibrary.species;

import edu.sanvalero.starwarslibrary.species.dto.SpeciesInDto;
import edu.sanvalero.starwarslibrary.species.dto.SpeciesOutDto;
import edu.sanvalero.starwarslibrary.species.exception.SpeciesInvalidPatchParameterException;
import edu.sanvalero.starwarslibrary.species.exception.SpeciesNotFoundException;
import edu.sanvalero.starwarslibrary.species.model.Species;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SpeciesServiceImpl implements SpeciesService {
    @Autowired
    private SpeciesRepository speciesRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<SpeciesOutDto> get() {
        List<Species> species = speciesRepository.findAll();
        List<SpeciesOutDto> out = getSpeciesOutDtos(species);
        return out;
    }

    @Override
    public SpeciesOutDto get(long id) {
        return getSpeciesOutDto(getSpeciesOrFail(id));
    }

    @Override
    public SpeciesOutDto post(SpeciesInDto speciesInDto) {
        Species newSpecies = new Species();
        modelMapper.map(speciesInDto, newSpecies);
        speciesRepository.save(newSpecies);
        return getSpeciesOutDto(newSpecies);
    }

    @Override
    public SpeciesOutDto put(long id, SpeciesInDto speciesInDto) {
        Species species = getSpeciesOrFail(id);
        modelMapper.map(speciesInDto, species);
        speciesRepository.save(species);
        return getSpeciesOutDto(species);
    }

    @Override
    public SpeciesOutDto patch(long id, Map<String, Object> patchParameters) {
        Species species = getSpeciesOrFail(id);
        patchParameters.forEach((key, value) -> {
            switch (key) {
                case "name":
                    species.setName(String.valueOf(value));
                    break;
                case "nativePlanet":
                    species.setNativePlanet(Long.parseLong(String.valueOf(value)));
                    break;
                case "language":
                    species.setLanguage(String.valueOf(value));
                    break;
                case "meanHeight":
                    species.setMeanHeight(Float.parseFloat(String.valueOf(value)));
                    break;
                case "meanLifespan":
                    species.setMeanLifespan(Float.parseFloat(String.valueOf(value)));
                    break;
                default:
                    throw new SpeciesInvalidPatchParameterException(key);
            }
        });
        speciesRepository.save(species);
        return getSpeciesOutDto(species);
    }

    @Override
    public void delete(long id) {
        getSpeciesOrFail(id);
        speciesRepository.deleteById(id);
    }

    private Species getSpeciesOrFail(long id) {
        return speciesRepository.findById(id).orElseThrow(() -> new SpeciesNotFoundException(id));
    }

    private SpeciesOutDto getSpeciesOutDto(Species species) {
        SpeciesOutDto out = new SpeciesOutDto();
        modelMapper.map(species, out);
        return out;
    }

    private List<SpeciesOutDto> getSpeciesOutDtos(List<Species> species) {
        List<SpeciesOutDto> out = new ArrayList<>();
        species.forEach(s -> out.add(getSpeciesOutDto(s)));
        return out;
    }
}
