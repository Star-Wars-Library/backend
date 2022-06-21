package edu.sanvalero.starwarslibrary.weapons;

import edu.sanvalero.starwarslibrary.weapons.dto.WeaponInDto;
import edu.sanvalero.starwarslibrary.weapons.dto.WeaponOutDto;
import edu.sanvalero.starwarslibrary.weapons.exception.WeaponInvalidPatchParameterException;
import edu.sanvalero.starwarslibrary.weapons.exception.WeaponNotFoundException;
import edu.sanvalero.starwarslibrary.weapons.model.Weapon;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class WeaponServiceImpl implements WeaponService {
    @Autowired
    private WeaponRepository weaponRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Set<WeaponOutDto> get() {
        Set<Weapon> weapons = weaponRepository.findAll();
        Set<WeaponOutDto> out = getWeaponOutDtos(weapons);
        return out;
    }

    @Override
    public WeaponOutDto get(long id) {
        return getWeaponOutDto(getWeaponOrFail(id));
    }

    @Override
    public WeaponOutDto post(WeaponInDto weaponInDto) {
        Weapon newWeapon = new Weapon();
        modelMapper.map(weaponInDto, newWeapon);
        weaponRepository.save(newWeapon);
        return getWeaponOutDto(newWeapon);
    }

    @Override
    public WeaponOutDto put(long id, WeaponInDto weaponInDto) {
        Weapon weapon = getWeaponOrFail(id);
        modelMapper.map(weaponInDto, weapon);
        weaponRepository.save(weapon);
        return getWeaponOutDto(weapon);
    }

    @Override
    public WeaponOutDto patch(long id, Map<String, Object> patchParameters) {
        Weapon weapon = getWeaponOrFail(id);
        patchParameters.forEach((key, value) -> {
            switch (key) {
                case "name":
                    weapon.setName(String.valueOf(value));
                    break;
                case "techLevel":
                    weapon.setTechLevel(String.valueOf(value));
                    break;
                case "ammunition":
                    weapon.setAmmunition(Integer.parseInt(String.valueOf(value)));
                    break;
                case "weight":
                    weapon.setWeight(Float.parseFloat(String.valueOf(value)));
                    break;
                default:
                    throw new WeaponInvalidPatchParameterException(key);
            }
        });
        weaponRepository.save(weapon);
        return getWeaponOutDto(weapon);
    }

    @Override
    public void delete(long id) {
        getWeaponOrFail(id);
        weaponRepository.deleteById(id);
    }

    private Weapon getWeaponOrFail(long id) {
        return weaponRepository.findById(id).orElseThrow(() -> new WeaponNotFoundException(id));
    }

    private WeaponOutDto getWeaponOutDto(Weapon weapon) {
        WeaponOutDto out = new WeaponOutDto();
        modelMapper.map(weapon, out);
        return out;
    }

    private Set<WeaponOutDto> getWeaponOutDtos(Set<Weapon> weapons) {
        Set<WeaponOutDto> out = new HashSet<>();
        weapons.forEach(weapon -> out.add(getWeaponOutDto(weapon)));
        return out;
    }
}
