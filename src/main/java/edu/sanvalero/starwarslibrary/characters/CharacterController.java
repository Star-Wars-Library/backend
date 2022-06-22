package edu.sanvalero.starwarslibrary.characters;

import edu.sanvalero.starwarslibrary.characters.dto.CharacterInDto;
import edu.sanvalero.starwarslibrary.characters.dto.CharacterOutDto;
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
public class CharacterController {
    private static final String PATH = "/characters";
    private final Logger log = LoggerFactory.getLogger(CharacterController.class);

    @Autowired
    private CharacterService characterService;

    @GetMapping(PATH)
    public ResponseEntity<List<CharacterOutDto>> get() {
        return ResponseEntity.ok(characterService.get());
    }

    @PostMapping(PATH)
    public ResponseEntity<CharacterOutDto> post(@RequestBody CharacterInDto characterInDto) throws URISyntaxException {
        CharacterOutDto characterOutDto = characterService.post(characterInDto);
        return ResponseEntity
                .created(new URI(PATH + "/" + characterOutDto.getId()))
                .body(characterOutDto);
    }

    @GetMapping(PATH + "/{id}")
    public ResponseEntity<CharacterOutDto> get(@PathVariable long id) {
        CharacterOutDto characterOutDto = characterService.get(id);
        return ResponseEntity.ok(characterOutDto);
    }

    @DeleteMapping(PATH + "/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        characterService.delete(id);
        log.info("Character removed");
        return ResponseEntity.noContent().build();
    }

    @PutMapping(PATH + "/{id}")
    public ResponseEntity<CharacterOutDto> put(@PathVariable long id,
                                               @RequestBody CharacterInDto characterInDto) {
        return ResponseEntity.ok(characterService.put(id, characterInDto));
    }

    @PatchMapping(PATH + "/{id}")
    public ResponseEntity<CharacterOutDto> patch(@PathVariable long id,
                                                 @RequestBody Map<String, Object> patchParameters) {
        CharacterOutDto characterOutDto = characterService.patch(id, patchParameters);
        log.info("Character modified");
        return ResponseEntity.ok(characterOutDto);
    }
}