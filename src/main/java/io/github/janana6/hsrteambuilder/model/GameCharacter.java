package io.github.janana6.hsrteambuilder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "game_character")
public class GameCharacter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String rarity;
    private String path;
    private String role;
    private String element;
    private String playstyle;
    private String iconUrl;

    @ManyToMany(mappedBy = "ownedCharacters")
    @JsonIgnore
    private Set<User> users = new HashSet<>();

}
