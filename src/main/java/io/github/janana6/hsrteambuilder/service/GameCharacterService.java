package io.github.janana6.hsrteambuilder.service;

import io.github.janana6.hsrteambuilder.data.CharacterBuildDataLoader;
import io.github.janana6.hsrteambuilder.dto.CharacterBuildResponse;
import io.github.janana6.hsrteambuilder.model.GameCharacter;
import io.github.janana6.hsrteambuilder.repository.GameCharacterRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class GameCharacterService {

    private final GameCharacterRepository repo;
    private final CharacterBuildDataLoader dataLoader;

    public GameCharacterService(GameCharacterRepository repo,
                                CharacterBuildDataLoader dataLoader) {
        this.repo = repo;
        this.dataLoader = dataLoader;
    }

    public List<GameCharacter> getAllCharacters() {
        return repo.findAll();
    }

    public CharacterBuildResponse getCharacterBuild(String name) {
        GameCharacter character = repo.findByNameIgnoreCase(name)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Character not found"
                ));

        CharacterBuildResponse build = dataLoader.getBuild(
                character.getName()
        );

        if (build == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Build not found"
            );
        }

        // DB
        build.setName(character.getName());
        build.setElement(character.getElement());
        build.setPath(character.getPath());
        build.setIconUrl(character.getIconUrl());
        build.setRarity(character.getRarity());

        return build;
    }
    public List<GameCharacter> filterCharacters(String role, String element, String path, String rarity) {

        return repo.findAll().stream()
                .filter(c -> role == null || c.getRole().equalsIgnoreCase(role))
                .filter(c -> element == null || c.getElement().equalsIgnoreCase(element))
                .filter(c -> path == null || c.getPath().equalsIgnoreCase(path))
                .filter(c -> rarity == null || c.getRarity().equalsIgnoreCase(rarity))
                .toList();
    }
}
