package edu.sanvalero.starwarslibrary.weapons;

import edu.sanvalero.starwarslibrary.weapons.dto.WeaponInDto;
import edu.sanvalero.starwarslibrary.weapons.dto.WeaponOutDto;

import java.util.Map;
import java.util.Set;

public interface WeaponService {
    Set<WeaponOutDto> get();

    WeaponOutDto get(long id);

    WeaponOutDto post(WeaponInDto weaponInDto);

    WeaponOutDto put(long id, WeaponInDto weaponInDto);

    WeaponOutDto patch(long id, Map<String, Object> patchParameters);

    void delete(long id);
}
