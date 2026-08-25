package io.github.jna6.hsrteambuilder.repository;

import io.github.jna6.hsrteambuilder.model.GameCharacter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GameCharacterRepository extends JpaRepository<GameCharacter, Long> {
    Optional<GameCharacter> findByNameIgnoreCase(String name);
}
