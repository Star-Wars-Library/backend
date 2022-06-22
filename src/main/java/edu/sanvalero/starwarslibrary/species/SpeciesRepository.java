package edu.sanvalero.starwarslibrary.species;

import edu.sanvalero.starwarslibrary.species.model.Species;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface SpeciesRepository extends CrudRepository<Species, Long> {
    Set<Species> findAll();
}
