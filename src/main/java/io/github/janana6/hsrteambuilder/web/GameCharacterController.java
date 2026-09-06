package io.github.janana6.hsrteambuilder.web;

import io.github.janana6.hsrteambuilder.dto.CharacterBuildResponse;
import io.github.janana6.hsrteambuilder.service.GameCharacterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/characters")
@RequiredArgsConstructor
public class GameCharacterController {

    private final GameCharacterService characterService;

    @GetMapping
    public List<?> getAllCharacters() {
        return characterService.getAllCharacters();
    }

    @GetMapping("/filter")
    public List<?> filterCharacters(
            @RequestParam(required = false) String role,
            @RequestParam(required = false) String element,
            @RequestParam(required = false) String path,
            @RequestParam(required = false) String rarity
    ) {
        return characterService.filterCharacters(role, element, path, rarity);
    }

    @GetMapping("/build/{name}")
    public CharacterBuildResponse getBuild(@PathVariable String name) {
        return characterService.getCharacterBuild(name);
    }
}