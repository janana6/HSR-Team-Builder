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
public class TeammateRecommendation {
    private String type; // Amplifiers / Sustain / etc
    private List<String> bis;
    private List<String> generalist;
    private List<String> f2p;
}