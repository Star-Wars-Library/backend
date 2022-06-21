package edu.sanvalero.starwarslibrary.weapons;

import edu.sanvalero.starwarslibrary.weapons.dto.WeaponInDto;
import edu.sanvalero.starwarslibrary.weapons.dto.WeaponOutDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Set;

@RestController
public class WeaponController {
    private static final String PATH = "/weapons";
    private final Logger log = LoggerFactory.getLogger(WeaponController.class);

    @Autowired
    private WeaponService weaponService;

    @GetMapping(PATH)
    public ResponseEntity<Set<WeaponOutDto>> get() {
        return ResponseEntity.ok(weaponService.get());
    }

    @PostMapping(PATH)
    public ResponseEntity<WeaponOutDto> post(@RequestBody WeaponInDto weaponInDto) throws URISyntaxException {
        WeaponOutDto weaponOutDto = weaponService.post(weaponInDto);
        return ResponseEntity
                .created(new URI(PATH + "/" + weaponOutDto.getId()))
                .body(weaponOutDto);
    }

    @GetMapping(PATH + "/{id}")
    public ResponseEntity<WeaponOutDto> get(@PathVariable long id) {
        WeaponOutDto weaponOutDto = weaponService.get(id);
        return ResponseEntity.ok(weaponOutDto);
    }

    @DeleteMapping(PATH + "/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        weaponService.delete(id);
        log.info("Weapon removed");
        return ResponseEntity.noContent().build();
    }

    @PutMapping(PATH + "/{id}")
    public ResponseEntity<WeaponOutDto> put(@PathVariable long id,
                                            @RequestBody WeaponInDto weaponInDto) {
        return ResponseEntity.ok(weaponService.put(id, weaponInDto));
    }

    @PatchMapping(PATH + "/{id}")
    public ResponseEntity<WeaponOutDto> patch(@PathVariable long id,
                                              @RequestBody Map<String, Object> patchParameters) {
        WeaponOutDto weaponOutDto = weaponService.patch(id, patchParameters);
        log.info("Weapon modified");
        return ResponseEntity.ok(weaponOutDto);
    }
}