package io.github.jna6.hsrteambuilder.config;

import io.github.jna6.hsrteambuilder.service.MetaTeamService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataLoader {

    private final MetaTeamService metaTeamService;

    public DataLoader(MetaTeamService metaTeamService) {
        this.metaTeamService = metaTeamService;
    }

    @Bean
    CommandLineRunner loadMetaTeams() {
        return args -> {
            try {
                // Team 1
                metaTeamService.createMetaTeam(
                        "Aglaea BiS",
                        List.of("Aglaea", "Sunday", "Robin", "Huohuo")
                );

                // Team 2
                metaTeamService.createMetaTeam(
                        "Firefly BiS",
                        List.of("Firefly", "Fugue", "The Dahlia", "Lingsha")
                );

                // Team 3
                metaTeamService.createMetaTeam(
                        "Kafka DoT",
                        List.of("Kafka", "Hysilens", "Black Swan", "Huohuo")
                );

                System.out.println("Meta teams loaded successfully!");
            } catch (RuntimeException e) {
                System.out.println("Some meta teams were not loaded: " + e.getMessage());
            }
        };
    }
}