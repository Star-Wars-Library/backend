package edu.sanvalero.starwarslibrary.weapons;

import edu.sanvalero.starwarslibrary.weapons.model.Weapon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface WeaponRepository extends CrudRepository<Weapon, Long> {
    List<Weapon> findAll();
}
