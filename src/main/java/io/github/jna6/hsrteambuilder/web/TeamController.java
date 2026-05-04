package io.github.jna6.hsrteambuilder.web;

import io.github.jna6.hsrteambuilder.model.Team;
import io.github.jna6.hsrteambuilder.service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
@AllArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @GetMapping
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    @PostMapping("/create")
    public Team createTeam(@RequestBody Team team) {
        return teamService.saveTeam(team);
    }
}