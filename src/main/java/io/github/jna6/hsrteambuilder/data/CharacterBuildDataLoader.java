package io.github.jna6.hsrteambuilder.data;

import io.github.jna6.hsrteambuilder.dto.BuildVariant;
import io.github.jna6.hsrteambuilder.dto.CharacterBuildResponse;
import io.github.jna6.hsrteambuilder.dto.TeamComposition;
import io.github.jna6.hsrteambuilder.dto.TeammateRecommendation;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CharacterBuildDataLoader {

    private final Map<String, CharacterBuildResponse> builds = new HashMap<>();

    private static final String AMPLIFIER = "Amplifier";
    private static final String SUSTAIN = "Sustain";
    private static final String DPS = "DPS";
    private static final String DOT_PARTNER = "DoT Partner";
    private static final String DEBUFFER = "Debuffer";
    @PostConstruct
    public void init() {
        add("Firefly", fireflyBuild());
        add("Boothill", boothillBuild());
        add("Rappa", rappaBuild());
        add("Himeko", himekoBuild());
        add("Kafka", kafkaBuild());
        add("Acheron", acheronBuild());
        add("Black Swan", blackswanBuild());

    }

    private void add(String name, CharacterBuildResponse build) {
        builds.put(name, build);
    }

    public CharacterBuildResponse getBuild(String name) {
        return builds.get(name);
    }

    // ===== Helpers =====
    private TeamComposition team(String name, String... members) {
        return new TeamComposition(name, List.of(members));
    }

    private TeammateRecommendation rec(String type,
                                       List<String> bis,
                                       List<String> generalist,
                                       List<String> f2p) {
        return new TeammateRecommendation(type, bis, generalist, f2p);
    }

    private BuildVariant variant(String name,
                                 List<TeamComposition> teams,
                                 List<TeammateRecommendation> recs) {
        return new BuildVariant(name, teams, recs);
    }

    private CharacterBuildResponse response(BuildVariant... variants) {
        CharacterBuildResponse b = new CharacterBuildResponse();
        b.setVariants(List.of(variants));
        return b;
    }

    // ===== BREAK TEAMS=====
    private CharacterBuildResponse fireflyBuild() {
        return response(
                variant(
                        "Break",
                        List.of(
                                team("BiS Team", "Firefly", "Fugue", "The Dahlia", "Lingsha"),
                                team("F2P Team", "Firefly", "Trailblazer (Harmony)", "Ruan Mei", "Gallagher")
                        ),
                        List.of(
                                rec(AMPLIFIER,
                                        List.of("Fugue", "The Dahlia", "Ruan Mei"),
                                        List.of(),
                                        List.of("Trailblazer (Harmony)")
                                ),
                                rec(SUSTAIN,
                                        List.of("Lingsha", "Gallagher"),
                                        List.of("Huohuo", "Aventurine"),
                                        List.of("Gallagher")
                                )
                        )
                )
        );
    }

    private CharacterBuildResponse boothillBuild() {
        return response(
                variant(
                        "Break",
                        List.of(
                                team("BiS Team", "Boothill", "Fugue", "The Dahlia", "Lingsha"),
                                team("F2P Team", "Boothill", "Trailblazer (Harmony)", "Ruan Mei", "Gallagher")
                        ),
                        List.of(
                                rec(AMPLIFIER,
                                        List.of("Fugue", "The Dahlia", "Ruan Mei"),
                                        List.of("Sunday", "Bronya"),
                                        List.of("Trailblazer (Harmony)", "Asta")
                                ),
                                rec(SUSTAIN,
                                        List.of("Lingsha", "Gallagher"),
                                        List.of("Huohuo", "Hyacine", "Fu Xuan"),
                                        List.of("Gallagher")
                                )
                        )
                )
        );
    }

    private CharacterBuildResponse rappaBuild() {
        return response(
                variant(
                        "Break",
                        List.of(
                                team("BiS Team", "Rappa", "Fugue", "The Dahlia", "Lingsha"),
                                team("F2P Team", "Rappa", "Trailblazer (Harmony)", "Ruan Mei", "Gallagher")
                        ),
                        List.of(
                                rec(AMPLIFIER,
                                        List.of("Fugue", "The Dahlia", "Ruan Mei"),
                                        List.of("Tribbie"),
                                        List.of("Trailblazer (Harmony)")
                                ),
                                rec(SUSTAIN,
                                        List.of("Lingsha", "Gallagher"),
                                        List.of("Huohuo", "Hyacine"),
                                        List.of("Gallagher")
                                )
                        )
                )
        );
    }

    private CharacterBuildResponse himekoBuild() {
        return response(
                variant(
                        "Break",
                        List.of(
                                team("BiS Team", "Himeko", "Fugue", "The Dahlia", "Lingsha"),
                                team("F2P Team", "Himeko", "Trailblazer (Harmony)", "Asta", "Gallagher")
                        ),
                        List.of(
                                rec(AMPLIFIER,
                                        List.of("Fugue", "The Dahlia", "Ruan Mei"),
                                        List.of(),
                                        List.of("Trailblazer (Harmony)")
                                ),
                                rec(SUSTAIN,
                                        List.of("Lingsha", "Gallagher"),
                                        List.of("Huohuo", "Hyacine", "Aventurine"),
                                        List.of("Gallagher")
                                )
                        )
                ),
                variant(
                        "Dual DPS",
                        List.of(
                                team("BiS Team", "Himeko", "The Herta", "Tribbie", "Aventurine"),
                                team("F2P Team", "Himeko", "Herta", "Pela", "Gallagher")

                        ),
                        List.of(
                                rec(DPS,
                                        List.of("Topaz", "Herta"),
                                        List.of("Anaxa"),
                                        List.of("Herta")
                                ),
                                rec(AMPLIFIER,
                                        List.of("Tribbie", "Robin"),
                                        List.of("Ruan Mei", "Silver Wolf"),
                                        List.of("Pela")
                                ),
                                rec(SUSTAIN,
                                        List.of("Aventurine"),
                                        List.of("Hyacine", "Huohuo"),
                                        List.of("Gallagher")
                                )
                        )
                )
        );
    }

    //==== DOT TEAMS ====
    private CharacterBuildResponse kafkaBuild() {
        return response(
                variant(
                        "DoT",
                        List.of(
                                team("BiS Team", "Kafka", "Hysilens", "Black Swan", "Dan Heng Permansor Terrae"),
                                team("F2P Team", "Kafka", "Sampo", "Asta", "Gallagher")
                        ),
                        List.of(
                                rec(DOT_PARTNER,
                                        List.of("Hysilens", "Black Swan"),
                                        List.of("Jiaoqiu"),
                                        List.of("Sampo","Serval")
                                ),
                                rec(AMPLIFIER,
                                        List.of("Ruan Mei"),
                                        List.of("Tribbie","Cipher"),
                                        List.of("Guinaifen")
                                ),
                                rec(SUSTAIN,
                                        List.of("Dan Heng Permansor Terrae", "Huohuo"),
                                        List.of("Hyacine"),
                                        List.of("Gallagher","Natasha")
                                )
                        )
                )
        );
    }
    private CharacterBuildResponse blackswanBuild() {
        return response(
                variant(
                        "DoT",
                        List.of(
                                team("BiS Team", "Kafka", "Hysilens", "Black Swan", "Dan Heng Permansor Terrae"),
                                team("F2P Team", "Black Swan", "Sampo", "Asta", "Gallagher")
                        ),
                        List.of(
                                rec(DOT_PARTNER,
                                        List.of("Hysilens", "Kafka"),
                                        List.of("Jiaoqiu"),
                                        List.of("Sampo","Serval")
                                ),
                                rec(AMPLIFIER,
                                        List.of("Ruan Mei"),
                                        List.of("Tribbie","Cipher"),
                                        List.of("Asta")
                                ),
                                rec(SUSTAIN,
                                        List.of("Dan Heng Permansor Terrae", "Huohuo"),
                                        List.of("Hyacine"),
                                        List.of("Gallagher","Natasha")
                                )
                        )
                )
        );
    }

    private CharacterBuildResponse acheronBuild() {
        return response(
                variant(
                        "Debuff Hypercarry",
                        List.of(
                                team("BiS Team", "Acheron", "Cipher", "Jiaoqiu", "Aventurine"),
                                team("F2P Team", "Acheron", "Pela", "Guinaifen", "Gallagher")
                        ),
                        List.of(
                                rec(DEBUFFER,
                                        List.of("Cipher", "Jiaoqiu"),
                                        List.of("Silver Wolf"),
                                        List.of("Pela", "Guinaifen")
                                ),
                                rec(SUSTAIN,
                                        List.of("Aventurine"),
                                        List.of("Fu Xuan", "Huohuo"),
                                        List.of("Gallagher")
                                )
                        )
                )
        );
    }

}