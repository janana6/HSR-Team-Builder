package io.github.janana6.hsrteambuilder.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CharacterBuildResponse {
    private String name;
    private String element;
    private String path;
    private String iconUrl;
    private String rarity;

    private List<BuildVariant> variants;
}