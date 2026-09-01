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
        add("Mortenax Blade", mortenaxBuild());
        add("Aglaea", aglaeaBuild());
        add("Anaxa", anaxaBuild());
        add("Archer", archerBuild());
        add("Argenti", argentiBuild());
        add("Ashveil", ashveilBuild());
        add("Blade", bladeBuild());
        add("Castorice", castoriceBuild());
        add("Cerydra", cerydraBuild());
        add("Cipher", cipherBuild());
        add("Cyrene", cyreneBuild());
        add("Clara", claraBuild());
        add("Evanescia", evanesciaBuild());
        add("Dan Heng Imbibitor Lunae", danhengilBuild());
        add("Evernight", evernightBuild());
        add("Himeko Nova", himekonovaBuild());
        add("Gilgamesh", gilgameshBuild());
        add("Feixiao", feixiaoBuild());
        add("Robin Summeretto", robinSummerettoBuild());
        add("Rin Tohsaka", rinBuild());
        add("The Herta", thehertaBuild());
        add("Jade", jadeBuild());
        add("Phainon", phainonBuild());
        add("Mydei", mydeiBuild());
        add("Jing Yuan", jingyuanBuild());
        add("Jingliu", jingliuBuild());
        add("Saber", saberBuild());
        add("Seele", seeleBuild());
        add("Silver Wolf", silverwolfBuild());
        add("Silver Wolf LV.999", silverwolflv999Build());
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
                                        List.of("The Herta", "Herta"),
                                        List.of("Anaxa"),
                                        List.of()
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
                                        List.of("Sampo", "Serval")
                                ),
                                rec(AMPLIFIER,
                                        List.of("Ruan Mei"),
                                        List.of(),
                                        List.of()
                                ),
                                rec(SUSTAIN,
                                        List.of("Dan Heng Permansor Terrae", "Huohuo"),
                                        List.of("Hyacine"),
                                        List.of("Gallagher")
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
                                        List.of("Sampo", "Serval")
                                ),
                                rec(AMPLIFIER,
                                        List.of("Ruan Mei"),
                                        List.of(),
                                        List.of()
                                ),
                                rec(SUSTAIN,
                                        List.of("Dan Heng Permansor Terrae", "Huohuo"),
                                        List.of("Hyacine"),
                                        List.of("Gallagher", "Natasha")
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
                                        List.of("Welt", "Ashveil"),
                                        List.of("Silver Wolf", "Cipher"),
                                        List.of("Pela")
                                ),
                                rec(SUSTAIN,
                                        List.of("Aventurine", "Dan Heng Permansor Terrae", "Hyacine"),
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
                                        List.of("Sunday", "Sparkle"),
                                        List.of("Bronya"),
                                        List.of("Tingyun")
                                ),
                                rec(SUSTAIN,
                                        List.of("Aventurine", "Dan Heng Permansor Terrae"),
                                        List.of("Fu Xuan", "Huohuo", "Hyacine"),
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
                                        List.of("Cipher", "Jiaoqiu", "Welt"),
                                        List.of("Silver Wolf"),
                                        List.of("Pela", "Guinaifen")
                                ),
                                rec(SUSTAIN,
                                        List.of("Aventurine", "Dan Heng Permansor Terrae"),
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
                                team("Sustainless Team", "Acheron", "Mortenax Blade", "Tribbie", "Welt")),
                        List.of(
                                rec(DEBUFFER,
                                        List.of("Welt", "Ashveil"),
                                        List.of("Silver Wolf", "Cipher"),
                                        List.of("Pela")
                                ),
                                rec(SUSTAIN,
                                        List.of("Hyacine", "Dan Heng Permansor Terrae"),
                                        List.of("Huohuo", "Aventurine"),
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
                                        List.of("Topaz & Numby", "Dr. Ratio"),
                                        List.of("March 7th (Hunt)")
                                ),
                                rec(SUSTAIN,
                                        List.of("Dan Heng Permansor Terrae", "Hyacine"),
                                        List.of("Lingsha", "Aventurine"),
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
                                        List.of("Dan Heng Permansor Terrae", "Lynx"),
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
                                team("F2P Team", "Aglaea", "Trailblazer (Remembrance)", "Asta", "Lynx")
                        ),
                        List.of(
                                rec(AMPLIFIER,
                                        List.of("Sunday", "Robin", "Cyrene"),
                                        List.of("Tribbie", "Trailblazer (Remembrance)", "Bronya"),
                                        List.of("Asta")
                                ),
                                rec(SUSTAIN,
                                        List.of("Dan Heng Permansor Terrae"),
                                        List.of("Huohuo", "Fu Xuan"),
                                        List.of("Lynx", "Gallagher")
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
                                team("F2P Team", "Anaxa", "Trailblazer (Remembrance)", "Asta", "Gallagher")),
                        List.of(
                                rec(AMPLIFIER,
                                        List.of("Cyrene", "Cerydra", "Sunday"),
                                        List.of("Robin", "Tribbie", "Ruan Mei"),
                                        List.of("Asta", "Trailblazer (Remembrance)", "Pela")
                                ),
                                rec(SUSTAIN,
                                        List.of("Dan Heng Permansor Terrae", "Hyacine"),
                                        List.of("Huohuo", "Aventurine"),
                                        List.of("Gallagher", "Lynx", "Natasha")
                                )
                        )
                ),
                variant(
                        "Dual DPS Team",
                        List.of(
                                team("BiS Team", "Anaxa", "The Herta", "Tribbie", "Dan Heng Permansor Terrae"),
                                team("F2P Team", "Anaxa", "Herta", "Trailblazer (Remembrance)", "Gallagher")),
                        List.of(
                                rec(DPS,
                                        List.of("The Herta"),
                                        List.of("Jade"),
                                        List.of("Herta")
                                ),
                                rec(SUSTAIN,
                                        List.of("Dan Heng Permansor Terrae", "Hyacine"),
                                        List.of("Huohuo", "Aventurine"),
                                        List.of("Gallagher", "Lynx", "Natasha")
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
                                team("BiS Team", "Archer", "Sparkle", "Rin Tohsaka", "Dan Heng Permansor Terrae"),
                                team("F2P Team", "Archer", "Trailblazer (Remembrance)", "Hanya", "Lynx")),
                        List.of(
                                rec(AMPLIFIER,
                                        List.of("Rin Tohsaka", "Sparkle", "Cipher"),
                                        List.of("Yao Guang", "Sunday", "Silver Wolf"),
                                        List.of("Hanya", "Trailblazer (Remembrance)", "Tingyun")
                                ),
                                rec(SUSTAIN,
                                        List.of("Huohuo", "Dan Heng Permansor Terrae", "Fu Xuan"),
                                        List.of("Hyacine", "Aventurine"),
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
                                team("F2P Team", "Archer", "Trailblazer (Remembrance)", "Yukong", "Gallagher")),
                        List.of(
                                rec(AMPLIFIER,
                                        List.of("Sunday", "Tribbie"),
                                        List.of("Robin", "Sparkle", "Silver Wolf"),
                                        List.of("Tingyun", "Trailblazer (Remembrance)", "Yukong")
                                ),
                                rec(SUSTAIN,
                                        List.of("Dan Heng Permansor Terrae", "Huohuo"),
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
                                team("Sustainless Team", "Acheron", "Mortenax Blade", "Tribbie", "Welt")),
                        List.of(
                                rec(DPS,
                                        List.of("Mortenax Blade", "Feixiao"),
                                        List.of("Topaz & Numby", "Welt", "Dr. Ratio"),
                                        List.of("Moze")
                                ),
                                rec(AMPLIFIER,
                                        List.of("Tribbie"),
                                        List.of("Robin"),
                                        List.of()
                                ),
                                rec(SUSTAIN,
                                        List.of("Hyacine", "Dan Heng Permansor Terrae"),
                                        List.of("Huohuo", "Aventurine", "Luocha"),
                                        List.of("Gallagher")
                                )
                        )
                ),
                variant(
                        "Hypercarry Team",
                        List.of(
                                team("BiS Team", "Ashveil", "Sunday", "Tribbie", "Dan Heng Permansor Terrae"),
                                team("F2P", "Ashveil", "Bronya", "Trailblazer (Remembrance)", "Gallagher")
                        ),
                        List.of(
                                rec(AMPLIFIER,
                                        List.of("Tribbie", "Sunday", "Robin"),
                                        List.of("Bronya", "Sparkle", "Cipher"),
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
                                team("F2P", "Blade", "Bronya", "Trailblazer (Remembrance)", "Lynx")
                        ),
                        List.of(
                                rec(AMPLIFIER,
                                        List.of("Tribbie", "Sunday"),
                                        List.of("Silver Wolf", "Cipher", "Ruan Mei"),
                                        List.of("Trailblazer (Remembrance)")
                                ),
                                rec(SUSTAIN,
                                        List.of("Hyacine"),
                                        List.of("Huohuo", "Luocha"),
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
                                        List.of("Jingliu", "Mortenax Blade"),
                                        List.of()
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
                                team("F2P", "Castorice", "Bronya", "Trailblazer (Remembrance)", "Gallagher")
                        ),
                        List.of(
                                rec(AMPLIFIER,
                                        List.of("Cyrene", "Evernight", "Tribbie"),
                                        List.of("Sunday", "Ruan Mei"),
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
                                        List.of("Phainon", "Anaxa"),
                                        List.of("Mydei", "Seele"),
                                        List.of()
                                ),
                                rec(AMPLIFIER,
                                        List.of("Sunday", "Cyrene"),
                                        List.of("Bronya", "Sparkle"),
                                        List.of("Trailblazer (Remembrance)")
                                ),
                                rec(SUSTAIN,
                                        List.of("Dan Heng Permansor Terrae", "Huohuo"),
                                        List.of("Luocha"),
                                        List.of("Gallagher", "Lynx")
                                )
                        )
                ),
                variant(
                        "Archer Team",
                        List.of(
                                team("BiS Team", "Archer", "Rin Tohsaka", "Cerydra", "Sparkle")
                        ),
                        List.of(

                        )
                )
        );
    }

    private CharacterBuildResponse cipherBuild() {
        return response(
                variant(
                        "Generalist Team",
                        List.of(
                                team("BiS Team", "Acheron", "Cipher", "Mortenax Blade", "Hyacine"),
                                team("BiS Team", "Archer", "Cipher", "Sparkle", "Dan Heng Permansor Terrae")
                        ),
                        List.of(

                        )
                )
        );
    }

    private CharacterBuildResponse cyreneBuild() {
        return response(
                variant(
                        "Castorice Team",
                        List.of(
                                team("BiS Team", "Castorice", "Evernight", "Cyrene", "Hyacine")
                        ),
                        List.of(

                        )
                ),
                variant(
                        "Phainon/Anaxa Team",
                        List.of(
                                team("BiS Team", "Phainon", "Cerydra", "Cyrene", "Dan Heng Permansor Terrae"),
                                team("BiS Team", "Anaxa", "Cerydra", "Cyrene", "Dan Heng Permansor Terrae")
                        ),
                        List.of(

                        )
                ),
                variant(
                        "Aglaea Team",
                        List.of(
                                team("BiS Team", "Aglaea", "Sunday", "Cyrene", "Dan Heng Permansor Terrae")
                        ),
                        List.of(

                        )
                ),
                variant(
                        "Mydei Team",
                        List.of(
                                team("BiS Team", "Mydei", "Tribbie", "Cyrene", "Hyacine")
                        ),
                        List.of(

                        )
                ),
                variant(
                        "DoT Team",
                        List.of(
                                team("BiS Team", "Kafka", "Hysilens", "Cyrene", "Dan Heng Permansor Terrae")
                        ),
                        List.of(

                        )
                )
        );
    }

    private CharacterBuildResponse mydeiBuild() {
        return response(
                variant(
                        "Main DPS Team",
                        List.of(
                                team("BiS Team", "Mydei", "Tribbie", "Cyrene", "Hyacine"),
                                team("F2P Team", "Mydei", "Trailblazer (Remembrance)", "Tingyun", "Gallagher")
                        ),
                        List.of(
                                rec(AMPLIFIER,
                                        List.of("Tribbie", "Cyrene", "Cerydra"),
                                        List.of("Sunday", "Sparkle", "Ruan Mei"),
                                        List.of("Trailblazer (Remembrance)")
                                ),
                                rec(SUSTAIN,
                                        List.of("Hyacine"),
                                        List.of("Huohuo", "Luocha"),
                                        List.of("Gallagher")
                                )
                        )
                )
        );
    }

    private CharacterBuildResponse phainonBuild() {
        return response(
                variant(
                        "Main DPS Team",
                        List.of(
                                team("BiS Team", "Phainon", "Cerydra", "Sunday", "Dan Heng Permansor Terrae"),
                                team("F2P Team", "Phainon", "Trailblazer (Remembrance)", "Tingyun", "Gallagher")
                        ),
                        List.of(
                                rec(AMPLIFIER,
                                        List.of("Sunday", "Cerydra", "Cyrene"),
                                        List.of("Sparkle", "Ruan Mei"),
                                        List.of("Trailblazer (Remembrance)")
                                ),
                                rec(SUSTAIN,
                                        List.of("Dan Heng Permansor Terrae", "Huohuo"),
                                        List.of("Aventurine"),
                                        List.of("Gallagher")
                                )
                        )
                )
        );
    }

    private CharacterBuildResponse claraBuild() {
        return response(
                variant(
                        "Hypercarry Team",
                        List.of(
                                team("BiS Team", "Clara", "Sunday", "Robin", "Dan Heng Permansor Terrae"),
                                team("F2P", "Clara", "Tingyun", "Trailblazer (Remembrance)", "Gallagher")
                        ),
                        List.of(
                                rec(AMPLIFIER,
                                        List.of("Sunday", "Robin"),
                                        List.of("Cypher", "Sparkle", "Tribbie"),
                                        List.of("Trailblazer (Remembrance)", "Tingyun")
                                ),
                                rec(SUSTAIN,
                                        List.of("Dan Heng Permansor Terrae", "Huohuo"),
                                        List.of("Aventurine", "Luocha"),
                                        List.of("Gallagher", "Lynx")
                                )
                        )
                ),
                variant(
                        "Dual DPS Team",
                        List.of(
                                team("BiS Team", "Clara", "Topaz & Numby", "Robin", "Dan Heng Permansor Terrae")
                        ),
                        List.of(
                                rec(DPS,
                                        List.of("Topaz & Numby", "Yunli"),
                                        List.of(),
                                        List.of()
                                )
                        )
                )
        );
    }

    private CharacterBuildResponse danhengilBuild() {
        return response(
                variant(
                        "Main DPS Team",
                        List.of(
                                team("BiS Team", "Dan Heng Imbibitor Lunae", "Sunday", "Sparkle", "Dan Heng Permansor Terrae"),
                                team("F2P", "Dan Heng Imbibitor Lunae", "Yukong", "Asta", "Gallagher")
                        ),
                        List.of(
                                rec(AMPLIFIER,
                                        List.of("Sunday", "Sparkle", "Cipher"),
                                        List.of("Robin", "Tribbie", "Ruan Mei"),
                                        List.of("Yukong", "Asta", "Tingyun")
                                ),
                                rec(SUSTAIN,
                                        List.of("Dan Heng Permansor Terrae", "Huohuo"),
                                        List.of("Aventurine", "Luocha"),
                                        List.of("Gallagher")
                                )
                        )
                ),
                variant(
                        "Mono-Imaginary Team",
                        List.of(
                                team("BiS Team", "Dan Heng Imbibitor Lunae", "Sparkle", "Silver Wolf", "Luocha")
                        ),
                        List.of(

                        )
                )
        );
    }

    private CharacterBuildResponse evanesciaBuild() {
        return response(
                variant(
                        "Main DPS Team",
                        List.of(
                                team("BiS Team", "Evanescia", "Yao Guang", "Trailblazer (Elation)", "Huohuo"),
                                team("F2P", "Evanescia", "Trailblazer (Elation)", "Ruan Mei", "Gallagher")
                        ),
                        List.of(
                                rec(AMPLIFIER,
                                        List.of("Yao Guang", "Trailblazer (Elation)"),
                                        List.of("Sparkle", "Tribbie", "Ruan Mei"),
                                        List.of()
                                ),
                                rec(SUSTAIN,
                                        List.of("Dan Heng Permansor Terrae", "Huohuo"),
                                        List.of("Aventurine", "Hyacine"),
                                        List.of("Gallagher")
                                )
                        )
                )
        );
    }

    private CharacterBuildResponse evernightBuild() {
        return response(
                variant(
                        "Castorice Team",
                        List.of(
                                team("BiS Team", "Castorice", "Evernight", "Cyrene", "Hyacine"),
                                team("F2P", "Castorice", "Evernight", "Trailblazer (Remembrance)", "Gallagher")
                        ),
                        List.of(
                        )
                )

        );
    }

    private CharacterBuildResponse himekonovaBuild() {
        return response(
                variant(
                        "Himeko Nova Premium - Decimation Team",
                        List.of(
                                team("BiS Team", "Himeko Nova", "Welt", "Mortenax Blade", "Huohuo")
                        ),
                        List.of(
                                rec(SUSTAIN,
                                        List.of("Dan Heng Permansor Terrae", "Huohuo"),
                                        List.of("Hyacine"),
                                        List.of("Gallagher")
                                )
                        )
                ),
                variant(
                        "Himeko Nova Premium - Verdict Team",
                        List.of(
                                team("BiS Team", "Himeko Nova", "Sunday", "Sparkle", "Dan Heng Permansor Terrae"),
                                team("BiS Team", "Himeko Nova", "Mortenax Blade", "Trailblazer (Remembrance)", "Dan Heng Permansor Terrae")

                        ),
                        List.of(

                        )
                ),
                variant(
                        "Himeko Nova Sustainless Team",
                        List.of(
                                team("BiS Team", "Himeko Nova", "Mortenax Blade", "Welt", "Trailblazer (Remembrance)")

                        ),
                        List.of(

                        )
                )
        );
    }

    private CharacterBuildResponse gilgameshBuild() {
        return response(
                variant(
                        "Saber Team",
                        List.of(
                                team("BiS Team", "Gilgamesh", "Saber", "Mortenax Blade", "Huohuo"),
                                team("F2P", "Gilgamesh", "Saber", "Trailblazer (Remembrance)", "Gallagher")
                        ),
                        List.of(
                                rec(AMPLIFIER,
                                        List.of("Mortenax Blade", "Tribbie"),
                                        List.of("Robin"),
                                        List.of("Trailblazer (Remembrance)")),
                                rec(SUSTAIN,
                                        List.of("Huohuo", "Dan Heng Permansor Terrae"),
                                        List.of("Hyacine"),
                                        List.of("Gallagher")
                                )
                        )
                ),
                variant(
                        "Follow-Up Team",
                        List.of(
                                team("BiS Team", "Gilgamesh", "Ashveil", "Mortenax Blade", "Dan Heng Permansor Terrae")
                        ),
                        List.of(

                        )
                )
        );
    }

    private CharacterBuildResponse saberBuild() {
        return response(
                variant(
                        "Gilgamesh Team",
                        List.of(
                                team("BiS Team", "Gilgamesh", "Saber", "Mortenax Blade", "Huohuo"),
                                team("F2P", "Gilgamesh", "Saber", "Trailblazer (Remembrance)", "Gallagher")
                        ), List.of(
                                rec(AMPLIFIER,
                                        List.of("Mortenax Blade", "Tribbie"),
                                        List.of("Robin"),
                                        List.of("Trailblazer (Remembrance)")),
                                rec(SUSTAIN,
                                        List.of("Huohuo", "Dan Heng Permansor Terrae"),
                                        List.of("Hyacine"),
                                        List.of("Gallagher")
                                )
                        )
                ),
                variant(
                        "Main DPS Team",
                        List.of(
                                team("BiS Team", "Saber", "Sunday", "Trailblazer (Remebrance)", "Dan Heng Permansor Terrae"),
                                team("F2P", "Saber", "Tingyun", "Trailblazer (Remebrance)", "Gallagher")
                        ),
                        List.of(
                                rec(AMPLIFIER,
                                        List.of("Trailblazer (Remebrance)", "Sunday"),
                                        List.of("Cyrene", "Robin", "Sparkle"),
                                        List.of("Tingyun")
                                ),
                                rec(SUSTAIN,
                                        List.of("Dan Heng Permansor Terrae", "Huohuo"),
                                        List.of("Hyacine", "Luocha"),
                                        List.of("Gallagher")
                                )
                        )
                )
        );
    }

    private CharacterBuildResponse feixiaoBuild() {
        return response(
                variant(
                        "Premium Follow-Up Team",
                        List.of(
                                team("BiS Team", "Feixiao", "Ashveil", "Tribbie", "Dan Heng Permansor Terrae"),
                                team("BiS Team", "Feixiao", "Ashveil", "Mortenax Blade", "Tribbie")
                        ),
                        List.of(
                                rec(DPS,
                                        List.of("Mortenax Blade", "Ashveil", "Cipher"),
                                        List.of("Topaz & Numby", "Dr. Ratio"),
                                        List.of("Moze", "March 7th (Hunt)")
                                ),
                                rec(AMPLIFIER,
                                        List.of("Tribbie", "Robin"),
                                        List.of("Sunday", "Silver Wolf"),
                                        List.of("Bronya", "Trailblazer (Remembrance)")
                                ),
                                rec(SUSTAIN,
                                        List.of("Dan Heng Permansor Terrae", "Aventurine"),
                                        List.of("Lingsha", "Hyacine"),
                                        List.of("Gallagher")
                                )
                        )
                )
        );
    }

    private CharacterBuildResponse robinSummerettoBuild() {
        return response(
                variant(
                        "Remembrance Team",
                        List.of(
                                team("BiS Team", "Castorice", "Robin Summeretto", "Evernight", "Hyacine"),
                                team("BiS Team", "Aglaea", "Robin Summeretto", "Cyrene", "Hyacine")
                        ),
                        List.of(
                                rec(AMPLIFIER,
                                        List.of("Evernight", "Cyrene", "Mortenax Blade"),
                                        List.of("Tribbie"),
                                        List.of("Trailblazer (Remembrance)")
                                )
                        )
                ),
                variant(
                        "Silver Wolf LV.999 Team",
                        List.of(
                                team("BiS Team", "Silver Wolf LV.999", "Robin Summeretto", "Yao Guang", "Huohuo")
                        ),
                        List.of(

                        )
                ),
                variant(
                        "AshBlade Team",
                        List.of(
                                team("BiS Team", "Ashveil", "Robin Summeretto", "Mortenax Blade", "Hyacine")
                        ),
                        List.of(

                        )
                ),
                variant(
                        "Himeko Nova Team",
                        List.of(
                                team("BiS Team", "Himeko Nova", "Robin Summeretto", "Welt", "Dan Heng Permansor Terrae")
                        ),
                        List.of(

                        )
                ),
                variant(
                        "Archer Team",
                        List.of(
                                team("BiS Team", "Archer", "Robin Summeretto", "Rin Tohsaka", "Huohuo")
                        ),
                        List.of(

                        )
                )
        );
    }

    private CharacterBuildResponse rinBuild() {
        return response(
                variant(
                        "Archer Team",
                        List.of(
                                team("BiS Team", "Archer", "Sparkle", "Rin Tohsaka", "Dan Heng Permansor Terrae")
                        ),
                        List.of(

                        )
                ),
                variant(
                        "Main DPS Team",
                        List.of(
                                team("BiS Team", "Rin Tohsaka", "Sparkle", "Cerydra", "Huohuo")
                        ),
                        List.of(
                                rec(AMPLIFIER,
                                        List.of("Sparkle", "Robin"),
                                        List.of("Mortenax Blade", "Cipher", "Tribbie"),
                                        List.of("Trailblazer (Remembrance)")
                                ),
                                rec(SUSTAIN,
                                        List.of("Huohuo", "Dan Heng Permansor Terrae", "Fu Xuan"),
                                        List.of("Hyacine", "Aventurine"),
                                        List.of("Lynx")
                                )
                        )
                )
        );
    }

    private CharacterBuildResponse thehertaBuild() {
        return response(
                variant(
                        "Generalist Team",
                        List.of(
                                team("BiS Team", "The Herta", "Anaxa", "Tribbie", "Dan Heng Permansor Terrae"),
                                team("F2P Team", "The Herta", "Serval", "Trailblazer (Remembrance)", "Gallagher")
                        ),
                        List.of(
                                rec(AMPLIFIER,
                                        List.of("Tribbie"),
                                        List.of("Robin"),
                                        List.of("Trailblazer (Remembrance)", "Asta")
                                ),
                                rec(SUSTAIN,
                                        List.of("Dan Heng Permansor Terrae", "Lingsha"),
                                        List.of("Huohuo", "Aventurine"),
                                        List.of("Gallagher", "Lynx")
                                )
                        )
                ),
                variant(
                        "Jade Team",
                        List.of(
                                team("BiS Team", "The Herta", "Jade", "Tribbie", "Huohuo")
                        ),
                        List.of(
                        )
                )

        );
    }

    private CharacterBuildResponse jadeBuild() {
        return response(
                variant(
                        "The Herta Team",
                        List.of(
                                team("BiS Team", "The Herta", "Jade", "Tribbie", "Huohuo")
                        ),
                        List.of(

                        )
                ),
                variant(
                        "Main DPS Team",
                        List.of(
                                team("BiS Team", "Jade", "Mortenax Blade", "Tribbie", "Hyacine")
                        ),
                        List.of(

                        )
                )
        );
    }

    private CharacterBuildResponse jingyuanBuild() {
        return response(
                variant(
                        "Main DPS Team",
                        List.of(
                                team("BiS Team", "Jing Yuan", "Tribbie", "Sunday", "Dan Heng Permansor Terrae"),
                                team("F2P Team", "Jing Yuan", "Tingyun", "Pela", "Gallagher")
                        ),
                        List.of(
                                rec(AMPLIFIER,
                                        List.of("Tribbie", "Sunday", "Robin"),
                                        List.of("Cipher", "Sparkle", "Ruan Mei"),
                                        List.of("Tingyun", "Pela", "Bronya")
                                ),
                                rec(SUSTAIN,
                                        List.of("Dan Heng Permansor Terrae", "Aventurine", "Huohuo"),
                                        List.of("Hyacine"),
                                        List.of("Gallagher")
                                )
                        )
                )
        );
    }

    private CharacterBuildResponse jingliuBuild() {
        return response(
                variant(
                        "Mortenax Blade Team",
                        List.of(
                                team("BiS Team", "Jingliu", "Mortenax Blade", "Trailblazer (Remebrance)", "Hyacine")),
                        List.of(

                        )
                ),
                variant(
                        "Main DPS Team",
                        List.of(
                                team("BiS Team", "Jingliu", "Tribbie", "Sunday", "Hyacine"),
                                team("F2P Team", "Jingliu", "Asta", "Trailblazer (Remebrance)", "Lynx")
                        ),
                        List.of(
                                rec(AMPLIFIER,
                                        List.of("Tribbie", "Sunday"),
                                        List.of("Cipher", "Silver Wolf", "Ruan Mei"),
                                        List.of("Trailblazer (Remebrance)", "Asta", "Bronya")
                                ),
                                rec(SUSTAIN,
                                        List.of("Hyacine"),
                                        List.of("Huohuo", "Luocha"),
                                        List.of("Lynx", "Gallagher")
                                )
                        )
                )
        );
    }

    private CharacterBuildResponse seeleBuild() {
        return response(
                variant(
                        "Main DPS Team",
                        List.of(
                                team("BiS Team", "Seele", "Sparkle", "Sunday", "Dan Heng Permansor Terrae"),
                                team("F2P Team", "Seele", "Tingyun", "Hanya", "Gallagher")
                        ),
                        List.of(
                                rec(AMPLIFIER,
                                        List.of("Sparkle", "Sunday", "Cerydra"),
                                        List.of("Tribbie", "Robin", "Cipher"),
                                        List.of("Trailblazer (Remebrance)", "Asta", "Bronya")
                                ),
                                rec(SUSTAIN,
                                        List.of("Dan Heng Permansor Terrae"),
                                        List.of("Hyacine"),
                                        List.of("Gallagher")
                                )
                        )
                )
        );
    }

    private CharacterBuildResponse silverwolfBuild() {
        return response(
                variant(
                        "Archer Team",
                        List.of(
                                team("BiS Team", "Archer", "Silver Wolf", "Sparkle", "Dan Heng Permansor Terrae"),
                                team("BiS Team", "Archer", "Silver Wolf", "Sparkle", "Rin Tohsaka")
                        ),
                        List.of(

                        )
                ),
                variant(
                        "Acheron Team",
                        List.of(
                                team("BiS Team", "Acheron", "Silver Wolf", "Mortenax Blade", "Hyacine"),
                                team("Sustainless Team", "Acheron", "Silver Wolf", "Mortenax Blade", "Tribbie")
                        ),
                        List.of(

                        )
                )
        );
    }

    private CharacterBuildResponse silverwolflv999Build() {
        return response(
                variant(
                        "Elation Team",
                        List.of(
                                team("BiS Team", "Silver Wolf LV.999", "Sparxie", "Yao Guang", "Huohuo"),
                                team("BiS Team", "Silver Wolf LV.999", "Tralblazer (Elation)", "Yao Guang", "Huohuo")
                        ),
                        List.of(
                                rec(AMPLIFIER,
                                        List.of("Sparxie", "Yao Guang", "Tralblazer (Elation)"),
                                        List.of("Evanescia"),
                                        List.of("Asta")
                                ),
                                rec(SUSTAIN,
                                        List.of("Huohuo"),
                                        List.of("Dan Heng Permansor Terrae", "Fu Xuan"),
                                        List.of("Gallagher")
                                )
                        )
                )
        );
    }


}