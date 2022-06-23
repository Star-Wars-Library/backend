package edu.sanvalero.starwarslibrary.species;

import edu.sanvalero.starwarslibrary.species.dto.SpeciesInDto;
import edu.sanvalero.starwarslibrary.species.dto.SpeciesOutDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
public class SpeciesController {
    private static final String PATH = "/species";
    private final Logger log = LoggerFactory.getLogger(SpeciesController.class);

    @Autowired
    private SpeciesService speciesService;

    @GetMapping(PATH)
    public ResponseEntity<List<SpeciesOutDto>> get() {
        return ResponseEntity.ok(speciesService.get());
    }

    @PostMapping(PATH)
    public ResponseEntity<SpeciesOutDto> post(@RequestBody SpeciesInDto speciesInDto) throws URISyntaxException {
        SpeciesOutDto speciesOutDto = speciesService.post(speciesInDto);
        return ResponseEntity
                .created(new URI(PATH + "/" + speciesOutDto.getId()))
                .body(speciesOutDto);
    }

    @GetMapping(PATH + "/{id}")
    public ResponseEntity<SpeciesOutDto> get(@PathVariable long id) {
        SpeciesOutDto speciesOutDto = speciesService.get(id);
        return ResponseEntity.ok(speciesOutDto);
    }

    @DeleteMapping(PATH + "/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        speciesService.delete(id);
        log.info("Species removed");
        return ResponseEntity.noContent().build();
    }

    @PutMapping(PATH + "/{id}")
    public ResponseEntity<SpeciesOutDto> put(@PathVariable long id,
                                             @RequestBody SpeciesInDto speciesInDto) {
        return ResponseEntity.ok(speciesService.put(id, speciesInDto));
    }

    @PatchMapping(PATH + "/{id}")
    public ResponseEntity<SpeciesOutDto> patch(@PathVariable long id,
                                               @RequestBody Map<String, Object> patchParameters) {
        SpeciesOutDto speciesOutDto = speciesService.patch(id, patchParameters);
        log.info("Species modified");
        return ResponseEntity.ok(speciesOutDto);
    }
}