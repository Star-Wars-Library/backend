package edu.sanvalero.starwarslibrary.planets;

import edu.sanvalero.starwarslibrary.planets.dto.PlanetInDto;
import edu.sanvalero.starwarslibrary.planets.dto.PlanetOutDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class PlanetController {
    private static final String PATH = "/planets";
    private final Logger log = LoggerFactory.getLogger(PlanetController.class);

    @Autowired
    private PlanetService planetService;

    @GetMapping(PATH)
    public ResponseEntity<List<PlanetOutDto>> get() {
        return ResponseEntity.ok(planetService.get());
    }

    @PostMapping(PATH)
    public ResponseEntity<PlanetOutDto> post(@RequestBody PlanetInDto planetInDto) throws URISyntaxException {
        PlanetOutDto planetOutDto = planetService.post(planetInDto);
        return ResponseEntity
                .created(new URI(PATH + "/" + planetOutDto.getId()))
                .body(planetOutDto);
    }

    @GetMapping(PATH + "/{id}")
    public ResponseEntity<PlanetOutDto> get(@PathVariable long id) {
        PlanetOutDto planetOutDto = planetService.get(id);
        return ResponseEntity.ok(planetOutDto);
    }

    @DeleteMapping(PATH + "/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        planetService.delete(id);
        log.info("Planet removed");
        return ResponseEntity.noContent().build();
    }

    @PutMapping(PATH + "/{id}")
    public ResponseEntity<PlanetOutDto> put(@PathVariable long id,
                                            @RequestBody PlanetInDto planetInDto) {
        return ResponseEntity.ok(planetService.put(id, planetInDto));
    }

    @PatchMapping(PATH + "/{id}")
    public ResponseEntity<PlanetOutDto> patch(@PathVariable long id,
                                              @RequestBody Map<String, Object> patchParameters) {
        PlanetOutDto planetOutDto = planetService.patch(id, patchParameters);
        log.info("Planet modified");
        return ResponseEntity.ok(planetOutDto);
    }
}