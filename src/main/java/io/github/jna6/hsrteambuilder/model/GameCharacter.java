package io.github.jna6.hsrteambuilder.model;

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

    @ManyToMany(mappedBy = "ownedCharacters")
    private Set<User> users = new HashSet<>();
}
