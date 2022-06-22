package edu.sanvalero.starwarslibrary.characters;

import edu.sanvalero.starwarslibrary.characters.dto.CharacterInDto;

import edu.sanvalero.starwarslibrary.characters.dto.CharacterOutDto;

import java.util.Map;
import java.util.Set;

public interface CharacterService {
    Set<CharacterOutDto> get();

    CharacterOutDto get(long id);

    CharacterOutDto post(CharacterInDto characterInDto);

    CharacterOutDto put(long id, CharacterInDto characterInDto);

    CharacterOutDto patch(long id, Map<String, Object> patchParameters);

    void delete(long id);
}
