package io.github.jna6.hsrteambuilder.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MetaTeam {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "meta_team_character",
            joinColumns = @JoinColumn(name = "meta_team_id"),
            inverseJoinColumns = @JoinColumn(name = "character_id")
    )
    private List<GameCharacter> characters;

    public MetaTeam(String name, List<GameCharacter> characters) {
        this.name = name;
        this.characters = characters;
    }

}
