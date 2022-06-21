package edu.sanvalero.starwarslibrary.planets;

import edu.sanvalero.starwarslibrary.planets.model.Planet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PlanetRepository extends CrudRepository<Planet, Long> {
    Set<Planet> findAll();
}
