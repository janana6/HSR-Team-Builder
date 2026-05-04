package io.github.jna6.hsrteambuilder.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class MetaTeamRequest {

    private String teamName;
    private List<String> characterNames;

    public MetaTeamRequest() {}

}