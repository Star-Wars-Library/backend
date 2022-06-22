package edu.sanvalero.starwarslibrary.characters;

import edu.sanvalero.starwarslibrary.characters.model.Character;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterRepository extends CrudRepository<Character, Long> {
    List<Character> findAll();
}
