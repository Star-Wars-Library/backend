package edu.sanvalero.starwarslibrary.ships;

import edu.sanvalero.starwarslibrary.ships.dto.ShipOutDto;
import edu.sanvalero.starwarslibrary.ships.dto.ShipInDto;
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
public class ShipController {
    private static final String PATH = "/ships";
    private final Logger log = LoggerFactory.getLogger(ShipController.class);

    @Autowired
    private ShipService shipService;

    @GetMapping(PATH)
    public ResponseEntity<Set<ShipOutDto>> get() {
        return ResponseEntity.ok(shipService.get());
    }

    @PostMapping(PATH)
    public ResponseEntity<ShipOutDto> post(@RequestBody ShipInDto shipInDto) throws URISyntaxException {
        ShipOutDto shipOutDto = shipService.post(shipInDto);
        return ResponseEntity
                .created(new URI(PATH + "/" + shipOutDto.getId()))
                .body(shipOutDto);
    }

    @GetMapping(PATH + "/{id}")
    public ResponseEntity<ShipOutDto> get(@PathVariable long id) {
        ShipOutDto shipOutDto = shipService.get(id);
        return ResponseEntity.ok(shipOutDto);
    }

    @DeleteMapping(PATH + "/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        shipService.delete(id);
        log.info("Ship removed");
        return ResponseEntity.noContent().build();
    }

    @PutMapping(PATH + "/{id}")
    public ResponseEntity<ShipOutDto> put(@PathVariable long id,
                                          @RequestBody ShipInDto shipInDto) {
        return ResponseEntity.ok(shipService.put(id, shipInDto));
    }

    @PatchMapping(PATH + "/{id}")
    public ResponseEntity<ShipOutDto> patch(@PathVariable long id,
                                            @RequestBody Map<String, Object> patchParameters) {
        ShipOutDto shipOutDto = shipService.patch(id, patchParameters);
        log.info("Ship modified");
        return ResponseEntity.ok(shipOutDto);
    }
}