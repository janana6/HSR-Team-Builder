package io.github.jna6.hsrteambuilder.service;

import io.github.jna6.hsrteambuilder.dto.CharacterBuildResponse;
import io.github.jna6.hsrteambuilder.dto.TeamComposition;
import io.github.jna6.hsrteambuilder.dto.TeammateRecommendation;
import io.github.jna6.hsrteambuilder.model.GameCharacter;
import io.github.jna6.hsrteambuilder.repository.GameCharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameCharacterService {
    private final GameCharacterRepository repository;

    public GameCharacterService(GameCharacterRepository repository) {
        this.repository = repository;
    }

    public List<GameCharacter> getAllCharacters() {
        return repository.findAll();
    }

    public CharacterBuildResponse getCharacterBuild(String name) {
        Optional<GameCharacter> c = repository.findByName(name);

        if (c.isEmpty()) {
            throw new RuntimeException("Character not found");
        }

        // Kafka build
        if (c.get().getName().equalsIgnoreCase("Kafka")) {
            return new CharacterBuildResponse(
                    "Kafka",
                    c.get().getElement(),
                    c.get().getPath(),
                    List.of(
                            new TeammateRecommendation(
                                    "Amplifiers",
                                    List.of("Black Swan", "Hysilens"),
                                    List.of("Pela", "Sampo"),
                                    List.of("Guinaifen")
                            ),
                            new TeammateRecommendation(
                                    "Sustain",
                                    List.of("Huohuo"),
                                    List.of("Luocha"),
                                    List.of("Natasha")
                            )
                    ),
                    List.of(
                            new TeamComposition[]{new TeamComposition(
                                    "Kafka DoT Team",
                                    List.of("Kafka", "Black Swan", "Hysilens", "Huohuo")
                            )}
                    )
            );
        }

        // Firefly build
        if (c.get().getName().equalsIgnoreCase("Firefly")) {
            return new CharacterBuildResponse(
                    "Firefly",
                    c.get().getElement(),
                    c.get().getPath(),
                    List.of(
                            new TeammateRecommendation(
                                    "Break Supports",
                                    List.of("Fugue", "Ruan Mei"),
                                    List.of("Pela"),
                                    List.of("Harmony Trailblazer")
                            ),
                            new TeammateRecommendation(
                                    "Sustain",
                                    List.of("Lingsha"),
                                    List.of("Gallagher"),
                                    List.of("Natasha")
                            )
                    ),
                    List.of(
                            new TeamComposition[]{new TeamComposition(
                                    "Firefly Break Team",
                                    List.of("Firefly", "Fugue", "Ruan Mei", "Lingsha")
                            )}
                    )
            );
        }

        return new CharacterBuildResponse(
                c.get().getName(),
                c.get().getElement(),
                c.get().getPath(),
                List.of(),
                List.of()
        );
    }
}
