package io.github.jna6.hsrteambuilder.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class MetaTeamResponse {
    private String teamName;
    private List<String> characters;
}