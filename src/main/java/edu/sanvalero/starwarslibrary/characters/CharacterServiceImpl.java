package edu.sanvalero.starwarslibrary.characters;

import edu.sanvalero.starwarslibrary.characters.dto.CharacterInDto;

import edu.sanvalero.starwarslibrary.characters.dto.CharacterOutDto;
import edu.sanvalero.starwarslibrary.characters.exception.CharacterInvalidPatchParameterException;
import edu.sanvalero.starwarslibrary.characters.exception.CharacterNotFoundException;
import edu.sanvalero.starwarslibrary.characters.model.Character;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class CharacterServiceImpl implements CharacterService {
    @Autowired
    private CharacterRepository characterRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Set<CharacterOutDto> get() {
        Set<Character> characters = characterRepository.findAll();
        return getCharacterOutDtos(characters);
    }


    @Override
    public CharacterOutDto get(long id) {
        Character character = characterRepository.findById(id).orElseThrow(() -> new CharacterNotFoundException(id));
        return getCharacterOutDto(character);
    }

    @Override
    public CharacterOutDto post(CharacterInDto characterInDto) {
        Character newCharacter = new Character();
        modelMapper.map(characterRepository, newCharacter);
        characterRepository.save(newCharacter);
        return getCharacterOutDto(newCharacter);
    }

    @Override
    public CharacterOutDto put(long id, CharacterInDto characterInDto) {
        Character character = getCharacterOrFail(id);
        modelMapper.map(characterInDto, character);
        characterRepository.save(character);
        return getCharacterOutDto(character);
    }

    @Override
    public CharacterOutDto patch(long id, Map<String, Object> patchParameters) {
        Character character = getCharacterOrFail(id);
        patchParameters.forEach((key, value) -> {
            switch (key) {
                case "name":
                    character.setName(String.valueOf(value));
                    break;
                case "gender":
                    character.setGender(String.valueOf(value));
                    break;
                case "yearBirth":
                    character.setYearBirth(LocalDate.parse(String.valueOf(value)));
                    break;
                case "forceSensitive":
                    character.setForceSensitive(Boolean.parseBoolean(String.valueOf(value)));
                    break;
                case "species":
                    character.setSpecies(Long.parseLong(String.valueOf(value)));
                case "ship":
                    character.setShip(Long.parseLong(String.valueOf(value)));
                    break;
                case "weapon":
                    character.setWeapon(Long.parseLong(String.valueOf(value)));
                    break;
                case "homeWorld":
                    character.setHomeWorld(Long.parseLong(String.valueOf(value)));
                    break;
                default:
                    throw new CharacterInvalidPatchParameterException(key);
            }
        });
        characterRepository.save(character);
        return getCharacterOutDto(character);
    }

    @Override
    public void delete(long id) {
        getCharacterOrFail(id);
        characterRepository.deleteById(id);
    }

    private Character getCharacterOrFail(long id) {
        return characterRepository.findById(id).orElseThrow(() -> new CharacterNotFoundException(id));
    }

    private CharacterOutDto getCharacterOutDto(Character character) {
        CharacterOutDto out = new CharacterOutDto();
        modelMapper.map(character, out);
        return out;
    }

    private Set<CharacterOutDto> getCharacterOutDtos(Set<Character> characters) {
        Set<CharacterOutDto> out = new HashSet<>();
        characters.forEach(character -> out.add(getCharacterOutDto(character)));
        return out;
    }
}
