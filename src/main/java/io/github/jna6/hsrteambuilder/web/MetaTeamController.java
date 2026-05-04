package io.github.jna6.hsrteambuilder.web;

import io.github.jna6.hsrteambuilder.dto.MetaTeamRequest;
import io.github.jna6.hsrteambuilder.dto.MetaTeamResponse;
import io.github.jna6.hsrteambuilder.dto.UserCharactersRequest;
import io.github.jna6.hsrteambuilder.model.MetaTeam;
import io.github.jna6.hsrteambuilder.service.MetaTeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/metateams")
public class MetaTeamController {

    private final MetaTeamService metaTeamService;

    public MetaTeamController(MetaTeamService metaTeamService) {
        this.metaTeamService = metaTeamService;
    }

    @PostMapping("/create")
    public ResponseEntity<MetaTeamResponse> createMetaTeam(@RequestBody MetaTeamRequest request) {
        MetaTeam team = metaTeamService.createMetaTeam(
                request.getTeamName(),
                request.getCharacterNames()
        );
        return ResponseEntity.ok(new MetaTeamResponse(team.getName(), team.getCharacters().stream().map(c -> c.getName()).toList()));
    }

    @GetMapping("/all")
    public ResponseEntity<List<MetaTeamResponse>> getAllMetaTeams() {
        return ResponseEntity.ok(metaTeamService.getAllMetaTeams());
    }

    @PostMapping("/suggest")
    public ResponseEntity<List<MetaTeamResponse>> suggestMetaTeams(@RequestBody UserCharactersRequest request) {
        return ResponseEntity.ok(metaTeamService.suggestMetaTeams(request.getCharacterNames()));
    }
}