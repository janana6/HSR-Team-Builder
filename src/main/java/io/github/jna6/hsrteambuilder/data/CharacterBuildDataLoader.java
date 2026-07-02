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
        add("Mortenax Blade",mortenaxBuild());
        add("Aglaea",aglaeaBuild());
        add("Anaxa",anaxaBuild());
        add("Archer",archerBuild());
        add("Argenti",argentiBuild());


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
                                        List.of("Topaz & Numby", "Herta"),
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
                        "Mortenax Blade Team",
                        List.of(
                                team("BiS Team", "Acheron", "Mortenax Blade", "Tribbie", "Hyacine"),
                                team("Sustainless Team", "Acheron", "Mortenax Blade", "Tribbie", "Welt")
                        ),
                        List.of(
                                rec(DEBUFFER,
                                        List.of("Welt","Ashveil"),
                                        List.of("Silver Wolf","Cipher"),
                                        List.of("Pela")
                                ),
                                rec(SUSTAIN,
                                        List.of("Aventurine","Dan Heng Permansor Terrae","Hyacine"),
                                        List.of("Fu Xuan", "Huohuo"),
                                        List.of("Gallagher")
                                )
                        )
                ),
                variant(
                        "Acheron E2",
                        List.of(
                                team("BiS Team", "Acheron", "Mortenax Blade", "Sparkle", "Dan Heng Permansor Terrae")),
                        List.of(
                                rec(AMPLIFIER,
                                        List.of("Sunday","Sparkle"),
                                        List.of("Bronya"),
                                        List.of("Tingyun")
                                ),
                                rec(SUSTAIN,
                                        List.of("Aventurine","Dan Heng Permansor Terrae"),
                                        List.of("Fu Xuan", "Huohuo","Hyacine"),
                                        List.of("Gallagher")
                                )
                        )
                ),
                variant(
                        "Debuff Hypercarry",
                        List.of(
                                team("BiS Team", "Acheron", "Cipher", "Jiaoqiu", "Aventurine"),
                                team("F2P Team", "Acheron", "Pela", "Guinaifen", "Gallagher")
                        ),
                        List.of(
                                rec(DEBUFFER,
                                        List.of("Cipher", "Jiaoqiu","Welt"),
                                        List.of("Silver Wolf"),
                                        List.of("Pela", "Guinaifen")
                                ),
                                rec(SUSTAIN,
                                        List.of("Aventurine","Dan Heng Permansor Terrae"),
                                        List.of("Fu Xuan", "Huohuo"),
                                        List.of("Gallagher")
                                )
                        )
                )
        );
    }

    private CharacterBuildResponse mortenaxBuild() {
        return response(
                variant(
                        "Nihility Team",
                        List.of(
                                team("BiS Team", "Acheron", "Mortenax Blade", "Tribbie", "Hyacine"),
                                team("Sustainless Team", "Acheron", "Mortenax Blade", "Tribbie", "Welt") ),
                        List.of(
                                rec(DEBUFFER,
                                        List.of("Welt","Ashveil"),
                                        List.of("Silver Wolf","Cipher"),
                                        List.of("Pela")
                                ),
                                rec(SUSTAIN,
                                        List.of("Hyacine","Dan Heng Permansor Terrae"),
                                        List.of("Huohuo","Aventurine"),
                                        List.of("Gallagher")
                                )
                        )
                ),
                variant(
                        "Follow-Up Team",
                        List.of(
                                team("BiS Team", "Mortenax Blade", "Ashveil", "Tribbie", "Dan Heng Permansor Terrae")
                        ),
                        List.of(
                                rec(DPS,
                                        List.of("Feixiao"),
                                        List.of("Topaz & Numby","Dr. Ratio"),
                                        List.of("March 7th (Hunt)")
                                ),
                                rec(SUSTAIN,
                                        List.of("Dan Heng Permansor Terrae","Hyacine"),
                                        List.of("Lingsha","Aventurine"),
                                        List.of("Gallagher")
                                )
                        )
                ),
                variant(
                        "F2P Team",
                        List.of(
                                team("BiS Team", "Mortenax Blade", "March 7th (Hunt)", "Asta", "Dan Heng Permansor Terrae")
                        ),
                        List.of(
                                rec(SUSTAIN,
                                        List.of("Dan Heng Permansor Terrae","Lynx"),
                                        List.of(),
                                        List.of()
                                )
                        )
                )
        );
    }
    private CharacterBuildResponse aglaeaBuild() {
        return response(
                variant(
                        "Summon",
                        List.of(
                                team("BiS Team", "Aglaea", "Robin", "Sunday", "Dan Heng Permansor Terrae"),
                                team("Bis Team", "Aglaea", "Trailblazer (Remembrance)", "Asta", "Lynx")
                        ),
                        List.of(
                                rec(AMPLIFIER,
                                        List.of("Sunday","Robin","Cyrene"),
                                        List.of("Tribbie","Trailblazer (Remembrance)","Bronya"),
                                        List.of("Asta")
                                ),
                                rec(SUSTAIN,
                                        List.of("Dan Heng Permansor Terrae"),
                                        List.of("Huohuo","Fu Xuan"),
                                        List.of("Lynx","Gallagher")
                                )
                        )
                )
        );
    }
    private CharacterBuildResponse anaxaBuild() {
        return response(
                variant(
                        "Main DPS Team",
                        List.of(
                                team("BiS Team", "Anaxa", "Cerydra", "Cyrene", "Dan Heng Permansor Terrae"),
                                team("F2P Team", "Anaxa", "Trailblazer (Remembrance)", "Asta", "Gallagher") ),
                        List.of(
                                rec(AMPLIFIER,
                                        List.of("Cyrene","Cerydra","Sunday"),
                                        List.of("Robin","Tribbie","Ruan Mei"),
                                        List.of("Asta","Trailblazer (Remembrance)","Pela")
                                ),
                                rec(SUSTAIN,
                                        List.of("Dan Heng Permansor Terrae","Hyacine"),
                                        List.of("Huohuo","Aventurine"),
                                        List.of("Gallagher","Lynx","Natasha")
                                )
                        )
                ),
                variant(
                        "Dual DPS Team",
                        List.of(
                                team("BiS Team", "Anaxa", "The Herta", "Tribbie", "Dan Heng Permansor Terrae"),
                                team("F2P Team", "Anaxa", "Herta", "Trailblazer (Remembrance)", "Gallagher") ),
                        List.of(
                                rec(DPS,
                                        List.of("The Herta"),
                                        List.of("Jade"),
                                        List.of("Herta")
                                ),
                                rec(SUSTAIN,
                                        List.of("Dan Heng Permansor Terrae","Hyacine"),
                                        List.of("Huohuo","Aventurine"),
                                        List.of("Gallagher","Lynx","Natasha")
                                )
                        )
                )
        );
    }
    private CharacterBuildResponse archerBuild() {
        return response(
                variant(
                        "Main DPS Team",
                        List.of(
                                team("BiS Team", "Archer", "Sparkle", "Tribbie", "Dan Heng Permansor Terrae"),
                                team("F2P Team", "Archer", "Trailblazer (Remembrance)", "Hanya", "Lynx") ),
                        List.of(
                                rec(AMPLIFIER,
                                        List.of("Sparkle","Tribbie", "Cipher"),
                                        List.of("Yao Guang","Sunday","Silver Wolf"),
                                        List.of("Hanya","Trailblazer (Remembrance)","Tingyun")
                                ),
                                rec(SUSTAIN,
                                        List.of("Dan Heng Permansor Terrae","Gallagher"),
                                        List.of("Luocha","Aventurine"),
                                        List.of("Lynx")
                                )
                        )
                ),
                variant(
                        "Mortenax Blade Team",
                        List.of(
                                team("BiS Team", "Archer", "Mortenax Blade", "Sparkle", "Dan Heng Permansor Terrae")),
                        List.of(
                        )
                )
        );
    }
    private CharacterBuildResponse argentiBuild() {
        return response(
                variant(
                        "Main DPS Team",
                        List.of(
                                team("BiS Team", "Argenti", "Sunday", "Tribbie", "Huohuo"),
                                team("F2P Team", "Archer", "Trailblazer (Remembrance)", "Yukong", "Gallagher") ),
                        List.of(
                                rec(AMPLIFIER,
                                        List.of("Sunday","Tribbie"),
                                        List.of("Robin","Sparkle","Silver Wolf"),
                                        List.of("Tingyun","Trailblazer (Remembrance)","Yukong")
                                ),
                                rec(SUSTAIN,
                                        List.of("Dan Heng Permansor Terrae","Huohuo"),
                                        List.of("Aventurine"),
                                        List.of("Gallagher")
                                )
                        )
                ),
                variant(
                        "The Herta Team",
                        List.of(
                                team("BiS Team", "Argenti", "The Herta", "Tribbie", "Huohuo")),
                        List.of(

                        )
                )
        );
    }
    private CharacterBuildResponse ashveilBuild() {
        return response(
                variant(
                        "Dual DPS Team",
                        List.of(
                                team("BiS Team", "Ashveil", "Mortenax Blade", "Tribbie", "Hyacine"),
                                team("Sustainless Team", "Acheron", "Mortenax Blade", "Tribbie", "Welt") ),
                        List.of(
                                rec(DPS,
                                        List.of("Mortenax Blade","Feixiao"),
                                        List.of("Topaz & Numby","Welt","Dr. Ratio"),
                                        List.of("Moze")
                                ),
                                rec(AMPLIFIER,
                                        List.of("Tribbie"),
                                        List.of("Robin"),
                                        List.of("")
                                ),
                                rec(SUSTAIN,
                                        List.of("Hyacine","Dan Heng Permansor Terrae"),
                                        List.of("Huohuo","Aventurine","Luocha"),
                                        List.of("Gallagher")
                                )
                        )
                ),
                variant(
                        "Hypercarry Team",
                        List.of(
                                team("BiS Team", "Ashveil", "Sunday", "Tribbie", "Dan Heng Permansor Terrae"),
                                team("F2P","Ashveil","Bronya","Trailblazer (Remembrance)","Gallagher")
                        ),
                        List.of(
                                rec(AMPLIFIER,
                                        List.of("Tribbie","Sunday","Robin"),
                                        List.of("Bronya","Sparkle","Cipher"),
                                        List.of("Trailblazer (Remembrance)")
                                )
                        )
                )
        );
    }
    private CharacterBuildResponse bladeBuild() {
        return response(
                variant(
                        "Hypercarry Team",
                        List.of(
                                team("BiS Team", "Blade", "Sunday", "Tribbie", "Hyacine"),
                                team("F2P","Blade","Bronya","Trailblazer (Remembrance)","Lynx")
                        ),
                        List.of(
                                rec(AMPLIFIER,
                                        List.of("Tribbie","Sunday"),
                                        List.of("Silver Wolf","Cipher","Ruan Mei"),
                                        List.of("Trailblazer (Remembrance)")
                                ),
                                rec(SUSTAIN,
                                        List.of("Hyacine"),
                                        List.of("Huohuo","Luocha"),
                                        List.of("Gallagher")
                                )
                        )
                ),
                variant(
                        "Dual DPS Team",
                        List.of(
                                team("BiS Team", "Blade", "Castorice", "Tribbie", "Hyacine")
                                ),
                        List.of(
                                rec(DPS,
                                        List.of("Castorice"),
                                        List.of("Jingliu","Nortenax Blade"),
                                        List.of("")
                                )
                        )
                )
        );
    }
    private CharacterBuildResponse castoriceBuild() {
        return response(
                variant(
                        "Hypercarry Team",
                        List.of(
                                team("BiS Team", "Castorice", "Evernight", "Cyrene", "Hyacine"),
                                team("F2P","Castorice","Bronya","Trailblazer (Remembrance)","Gallagher")
                        ),
                        List.of(
                                rec(AMPLIFIER,
                                        List.of("Cyrene","Evernight","Tribbie"),
                                        List.of("Sunday","Ruan Mei"),
                                        List.of("Trailblazer (Remembrance)")
                                ),
                                rec(SUSTAIN,
                                        List.of("Hyacine"),
                                        List.of("Luocha"),
                                        List.of("Gallagher")
                                )
                        )
                )
        );
    }
    private CharacterBuildResponse cerydraBuild() {
        return response(
                variant(
                        "Generalist Team",
                        List.of(
                                team("BiS Team", "Phainon", "Cerydra", "Sunday", "Dan Heng Permansor Terrae")
                        ),
                        List.of(
                                rec(DPS,
                                        List.of("Phainon","Anaxa"),
                                        List.of("Mydei","Seele"),
                                        List.of("")
                                ),
                                rec(AMPLIFIER,
                                        List.of("Sunday","Cyrene"),
                                        List.of("Bronya","Sparkle"),
                                        List.of("Trailblazer (Remembrance)")
                                ),
                                rec(SUSTAIN,
                                        List.of("Dan Heng Permansor Terrae","Huohuo"),
                                        List.of("Luocha"),
                                        List.of("Gallagher","Lynx")
                                )
                        )
                )
        );
    }
    private CharacterBuildResponse cyreneBuild() {
        return response(
                variant(
                        " Team",
                        List.of(
                        ),
                        List.of(

                        )
                )
        );
    }


}