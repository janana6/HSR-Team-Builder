package io.github.jna6.hsrteambuilder.service;

import io.github.jna6.hsrteambuilder.dto.MetaTeamResponse;
import io.github.jna6.hsrteambuilder.model.GameCharacter;
import io.github.jna6.hsrteambuilder.model.MetaTeam;
import io.github.jna6.hsrteambuilder.repository.GameCharacterRepository;
import io.github.jna6.hsrteambuilder.repository.MetaTeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MetaTeamService {

    private final MetaTeamRepository metaTeamRepository;
    private final GameCharacterRepository characterRepository;

    public MetaTeamService(MetaTeamRepository metaTeamRepository,
                           GameCharacterRepository characterRepository) {
        this.metaTeamRepository = metaTeamRepository;
        this.characterRepository = characterRepository;
    }

    public MetaTeam createMetaTeam(String teamName, List<String> characterNames) {
        List<GameCharacter> characters = characterNames.stream()
                .map(name -> characterRepository.findByName(name)
                        .orElseThrow(() -> new RuntimeException("Character not found: " + name))
                )
                .toList();

        MetaTeam team = new MetaTeam(teamName, characters);
        return metaTeamRepository.save(team);
    }
    public List<MetaTeamResponse> getAllMetaTeams() {
        return metaTeamRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public List<MetaTeamResponse> suggestMetaTeams(List<String> characterNames) {
        return metaTeamRepository.findAll().stream()
                .filter(team -> team.getCharacters().stream()
                        .anyMatch(c -> characterNames.contains(c.getName()))
                )
                .sorted((t1, t2) -> {
                    long t1Matches = t1.getCharacters().stream()
                            .filter(c -> characterNames.contains(c.getName())).count();
                    long t2Matches = t2.getCharacters().stream()
                            .filter(c -> characterNames.contains(c.getName())).count();
                    return Long.compare(t2Matches, t1Matches);
                })
                .map(this::mapToResponse)
                .toList();
    }
    private MetaTeamResponse mapToResponse(MetaTeam team) {
        List<String> characterNames = team.getCharacters()
                .stream()
                .map(GameCharacter::getName)
                .toList();

        return new MetaTeamResponse(team.getName(), characterNames);
    }
}