package io.github.jna6.hsrteambuilder.web;

import io.github.jna6.hsrteambuilder.dto.CharacterBuildResponse;
import io.github.jna6.hsrteambuilder.model.GameCharacter;

import io.github.jna6.hsrteambuilder.service.GameCharacterService;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/characters")
@AllArgsConstructor
public class GameCharacterController {

    private final GameCharacterService characterService;

    @GetMapping
    public List<GameCharacter> getAllCharacters(){
        return characterService.getAllCharacters();
    }

    @GetMapping("/filter")
    public List<GameCharacter> filterCharacters(
            @RequestParam(required = false) String role,
            @RequestParam(required = false) String element,
            @RequestParam(required = false) String path,
            @RequestParam(required = false) String rarity

    ) {
        return characterService.getAllCharacters().stream()
                .filter(c -> role == null || c.getRole().equalsIgnoreCase(role))
                .filter(c -> element == null || c.getElement().equalsIgnoreCase(element))
                .filter(c -> path == null || c.getPath().equalsIgnoreCase(path))
                .filter(c -> rarity == null || c.getRarity().equalsIgnoreCase(rarity))
                .toList();
    }

    @GetMapping("/build/{name}")
    public CharacterBuildResponse getBuild(@PathVariable String name) {
        return characterService.getCharacterBuild(name);
    }
}
