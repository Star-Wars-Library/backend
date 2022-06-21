package edu.sanvalero.starwarslibrary.ships;

import edu.sanvalero.starwarslibrary.ships.model.Ship;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ShipRepository extends CrudRepository<Ship, Long> {
    Set<Ship> findAll();
}
