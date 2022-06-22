package edu.sanvalero.starwarslibrary.characters;

import edu.sanvalero.starwarslibrary.characters.model.Character;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CharacterRepository extends CrudRepository<Character, Long> {
    Set<Character> findAll();
}
