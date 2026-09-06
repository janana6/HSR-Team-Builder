package io.github.janana6.hsrteambuilder.repository;

import io.github.janana6.hsrteambuilder.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {
    List<Team> findByOwnerId(Long userId);
}
