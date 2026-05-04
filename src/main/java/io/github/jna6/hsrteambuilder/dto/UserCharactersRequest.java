package io.github.jna6.hsrteambuilder.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class UserCharactersRequest {
    private List<String> characterNames;

    public void setCharacterNames(List<String> characterNames) { this.characterNames = characterNames; }
}