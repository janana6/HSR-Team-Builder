import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";

function TeamBuilder() {
    const [buildError, setBuildError] = useState(false);
    const navigate = useNavigate();
    const { name } = useParams();
    const [characters, setCharacters] = useState([]);
    const [selectedCharacter, setSelectedCharacter] = useState(null);
    const [roleFilter, setRoleFilter] = useState("All");
    const [elementFilter, setElementFilter] = useState("All");
    const [pathFilter, setPathFilter] = useState("All");
    const [rarityFilter, setRarityFilter] = useState("All");
    const resetFilters = () => {
        setRoleFilter("All");
        setElementFilter("All");
        setPathFilter("All");
        setRarityFilter("All");
        setSearch("");
    };
    const [search, setSearch] = useState("");
    const [characterBuild, setCharacterBuild] = useState(null);
    const [loadingBuild, setLoadingBuild] = useState(false);
    const scrollToTop = () => {
        window.scrollTo({
            top: 0,
            behavior: "smooth"
        });
    };
    // const roleLabels = {
    //     AMPLIFIER: "Amplifier",
    //     SUSTAIN: "Sustain",
    //     DOT_PARTNER: "Dot Partner",
    //     DPS: "DPS",
    //     DEBUFFER: "Debuffer"
    // };

    // const fetchCharacterBuild = (characterName) => {
    //     setLoadingBuild(true);
    //     fetch(`http://localhost:8080/characters/build/${characterName}`)
    //         .then((res) => res.json())
    //         .then((data) => {
    //             console.log("BUILD DATA:", data);
    //             setCharacterBuild(data);
    //         })
    //         .catch((err) => console.log("ERROR:", err))
    //         .finally(() => setLoadingBuild(false));
    // };

    useEffect(() => {
        fetch("http://localhost:8080/characters")
            .then((res) => res.json())
            .then((data) => setCharacters(data))
            .catch((err) => console.log("ERROR:", err));
    }, []);

    useEffect(() => {
        if (!name) return;
        const loadBuild = async () => {
            try {
                setLoadingBuild(true);
                setBuildError(false);

                const res = await fetch(
                    `http://localhost:8080/characters/build/${name}`
                );
                if (!res.ok) {
                    throw new Error("Character not found");
                }
                const data = await res.json();
                setCharacterBuild(data);

            } catch (err) {
                console.log(err);
                setCharacterBuild(null);
                setBuildError(true);
            } finally {
                setLoadingBuild(false);
            }
        };
        loadBuild();
    }, [name]);

    return (
        <div
            style={{
                margin: "0 100px",
                padding: "10px 20px",
                boxSizing: "border-box",
                // background: "#080c1d"
            }}>
            {/* TITLE */}
            <div style={{
                display: "flex",
                alignItems: "center",
                marginBottom: "15px",
                padding: "30px 0",
                gap: "12px"
            }}>
                {/* STAR ICON */}
                <div style={{
                    fontSize: "40px",
                    lineHeight: "1",
                    display: "flex",
                    alignItems: "center",
                    justifyContent: "center",
                    color: "#FFFFFF"
                }}>
                    ✦
                </div>
                {/* TEXT BLOCK */}
                <div>
                    <h1 style={{
                        margin: 0,
                        fontSize: "26px",
                        fontWeight: "800",
                        color: "#FFFFFF",
                        letterSpacing: "1px"
                    }}>
                        Honkai Star Rail — Team Builder
                    </h1>

                    <p style={{
                        margin: "5px 0 0 0",
                        fontSize: "12px",
                        color: "#999",
                        letterSpacing: "1px"
                    }}>
                        SELECT YOUR ROSTER · GET META TEAM SUGGESTIONS
                    </p>
                </div>

            </div>

            {/* PANELS */}
            <div style={{
                display: "flex",
                gap: "20px",
                alignItems: "flex-start"
            }}>

                {/* LEFT PANEL */}
                <div style={{
                    flex: "0 0 30%",
                    border: "1px solid #112234",
                    borderRadius: "20px",
                    padding: "15px",
                    background: "#0f1525",
                    boxShadow: "0 2px 8px rgba(0,0,0,0.05)",
                }}>

                    {/* FILTERS */}
                    <div style={{marginBottom: "10px"}}>
                        <input
                            type="text"
                            placeholder="Search characters..."
                            value={search}
                            onChange={(e) => setSearch(e.target.value)}
                            style={{
                                width: "97%",
                                padding: "6px",
                                marginBottom: "10px",
                                border: "1px solid #112234",
                                borderRadius: "6px"
                            }}
                        />

                        <select
                            value={rarityFilter}
                            onChange={(e) => setRarityFilter(e.target.value)}
                            style={{width: "48%", marginTop: "10px", marginRight: "4%"}}
                        >
                            <option value="All">All Rarities</option>
                            <option value="5">5 ★</option>
                            <option value="4">4 ★</option>
                        </select>
                        <select
                            value={roleFilter}
                            onChange={(e) => setRoleFilter(e.target.value)}
                            style={{width: "48%"}}
                        >
                            <option value="All">All Roles</option>
                            <option value="DPS">DPS</option>
                            <option value="Support">Support</option>
                            <option value="Sustain">Sustain</option>
                            <option value="Flex">Flex</option>
                        </select>

                        <select
                            value={elementFilter}
                            onChange={(e) => setElementFilter(e.target.value)}
                            style={{width: "48%", marginRight: "4%"}}
                        >
                            <option value="All">All Elements</option>
                            <option value="Fire">Fire</option>
                            <option value="Ice">Ice</option>
                            <option value="Lightning">Lightning</option>
                            <option value="Wind">Wind</option>
                            <option value="Quantum">Quantum</option>
                            <option value="Imaginary">Imaginary</option>
                        </select>
                        <select
                            value={pathFilter}
                            onChange={(e) => setPathFilter(e.target.value)}
                            style={{width: "48%", marginTop: "10px"}}
                        >
                            <option value="All">All Paths</option>
                            <option value="Destruction">Destruction</option>
                            <option value="Hunt">Hunt</option>
                            <option value="Erudition">Erudition</option>
                            <option value="Harmony">Harmony</option>
                            <option value="Nihility">Nihility</option>
                            <option value="Abundance">Abundance</option>
                            <option value="Preservation">Preservation</option>
                        </select>
                        <button
                            onClick={resetFilters}
                            style={{
                                width: "15%",
                                marginTop: "10px",
                                marginLeft: "auto",
                                display: "block",
                                padding: "2px 6px",
                                fontSize: "11px",
                                borderRadius: "6px",
                                border: "1px solid #112234",
                                background: "#1a2235",
                                color: "white",
                                cursor: "pointer"
                            }}
                        >
                            Reset
                        </button>
                    </div>

                    {/* CHARACTER GRID */}
                    <div
                        style={{
                            display: "grid",
                            gridTemplateColumns: "repeat(4, 1fr)",
                            gap: "6px"
                        }}
                    >
                        {characters
                            .filter((c) => {
                                const roleMatch =
                                    roleFilter === "All" || c.role === roleFilter;

                                const elementMatch =
                                    elementFilter === "All" || c.element === elementFilter;

                                const searchMatch =
                                    c.name.toLowerCase().includes(search.toLowerCase());
                                const pathMatch =
                                    pathFilter === "All" || c.path === pathFilter;

                                const rarityMatch =
                                    rarityFilter === "All" || String(c.rarity) === rarityFilter;

                                return roleMatch && elementMatch && pathMatch && rarityMatch && searchMatch;
                            })
                            .sort((a, b) => a.name.localeCompare(b.name))
                            .map((c) => (
                                <div
                                    key={c.id}
                                    onClick={() => {
                                        setSelectedCharacter(c);
                                        navigate(`/build/${c.name}`);
                                        scrollToTop();
                                    }}
                                    // onMouseEnter={(e) =>
                                    //     e.currentTarget.style.background = "#f0f4ff"
                                    // }
                                    // onMouseLeave={(e) =>
                                    //     e.currentTarget.style.background =
                                    //         selectedCharacter?.id === c.id
                                    //             ? "#e6f0ff"
                                    //             : "white"
                                    // }
                                    style={{
                                        width: "100%",
                                        aspectRatio: "1 / 1",
                                        display: "flex",
                                        flexDirection: "column",
                                        alignItems: "center",
                                        justifyContent: "flex-start",
                                        paddingTop:"2px",
                                        cursor: "pointer",
                                        transition: "0.2s",
                                        transform: selectedCharacter?.id === c.id ? "scale(1.1)" : "scale(1)",
                                    }}
                                >
                                    <img
                                        src={`http://localhost:8080${c.iconUrl}`}
                                        alt={c.name}
                                        style={{
                                            width: "70%",
                                            height: "70%",
                                            objectFit: "cover",
                                            borderRadius: "10px",
                                        }}
                                    />
                                    <div
                                        style={{
                                            marginTop:"4px",
                                            fontSize: "11px",
                                            color: "#cbd5e1",
                                            textAlign: "center",
                                            whiteSpace: "normal",
                                            maxWidth: "100%",
                                            wordBreak: "break-word",
                                            lineHeight: "1.1"
                                        }}
                                    >
                                        {c.name}
                                    </div>
                                </div>
                            ))}
                    </div>
                </div>
                {/* RIGHT PANEL */}
                <div style={{
                    flex: 1,
                    border: "1px solid #112234",
                    borderRadius: "20px",
                    padding: "15px",
                    background: "#0f1525",
                    boxShadow: "0 2px 8px rgba(0,0,0,0.05)"
                }}>

                    {buildError ? (
                        <p style={{color: "#ef4444"}}>Character not found</p>
                    ) : loadingBuild ? (
                        <p style={{color: "#cbd5e1"}}>Loading...</p>
                    ) : !characterBuild ? (
                        <p style={{color: "#cbd5e1"}}>Click a character to view build</p>
                    ) : (
                        <>
                            <h2 style={{color: "white", marginBottom: "4px"}}>
                                {characterBuild.name}
                            </h2>

                            <p style={{color: "#94a3b8"}}>
                                {characterBuild.element} • {characterBuild.path}
                            </p>

                            {characterBuild.variants?.map((variant, vIdx) => (
                                <div key={vIdx} style={{marginTop: "25px"}}>

                                    <h2 style={{
                                        color: "#ffffff",
                                        marginBottom: "10px",
                                        fontSize: "22px",
                                        fontWeight: "700",
                                        fontFamily: "Rajdhani",
                                    }}>
                                        {variant.playstyle}
                                    </h2>

                                    {/* ONE ROW: BIS + F2P */}
                                    <div style={{
                                        display: "flex",
                                        justifyContent: "space-between",
                                        flexWrap: "nowrap",
                                        gap: "70px",
                                        marginTop: "10px",
                                        // border: "1px solid #1b2a3a",
                                        // borderRadius: "12px",
                                        // padding: "12px",
                                    }}>

                                        {variant.teamCompositions?.map((team, i) => (
                                            <div key={i} style={{minWidth: "220px"}}>
                                                <strong style={{color: "#dbe7ff"}}>
                                                    {team.name}
                                                </strong>

                                                <div style={{
                                                    display: "flex",
                                                    gap: "15px",
                                                    marginTop: "10px"
                                                }}>
                                                    {team.characters.map((c, idx) => {
                                                        const charData = characters.find(x => x.name === c);

                                                        return (
                                                            <div
                                                                key={idx}
                                                                style={{
                                                                    display: "flex",
                                                                    flexDirection: "column",
                                                                    alignItems: "center"
                                                                }}
                                                            >
                                                                <img
                                                                    src={`http://localhost:8080${charData?.iconUrl}`}
                                                                    alt={c}
                                                                    title={c}
                                                                    style={{
                                                                        width: "90px",
                                                                        height: "90px",
                                                                        borderRadius: "12px",
                                                                        objectFit: "cover",
                                                                        border: "1px solid #2a3b4d"
                                                                    }}
                                                                />
                                                                <span style={{
                                                                    fontSize: "12px",
                                                                    color: "white",
                                                                    marginTop: "4px",
                                                                    maxWidth: "90px",
                                                                    textAlign: "center",
                                                                    wordWrap: "break-word",
                                                                    whiteSpace: "normal",
                                                                    lineHeight: "1.1"
                                                                }}>{c}</span>
                                                            </div>
                                                        );
                                                    })}
                                                </div>
                                            </div>
                                        ))}
                                    </div>

                                    {/* ================= TEAMMATE RECOMMENDATIONS ================= */}

                                    {/*<h4 style={{color: "white", marginTop: "25px"}}>*/}
                                    {/*    Teammate Recommendations*/}
                                    {/*</h4>*/}

                                    <div
                                        style={{
                                            display: "flex",
                                            flexDirection: "column",
                                            gap: "25px",
                                            marginTop: "25px",
                                            border: "1px solid #1b2a3a",
                                            borderRadius: "12px",
                                            padding: "12px",
                                        }}
                                    >

                                        {variant.teammateRecommendations?.map((group, i) => (
                                            <div
                                                key={i}
                                                style={{
                                                }}
                                            >
                                                {/* TYPE */}
                                                <div
                                                    style={{
                                                        color: "#dbe7ff",
                                                        fontWeight: "700",
                                                    }}
                                                >
                                                    {group.type}
                                                </div>
                                                <div
                                                    style={{
                                                        display: "grid",
                                                        gridTemplateColumns: "1fr 1fr 1fr",
                                                        gap: "20px",
                                                        alignItems: "start",
                                                        width: "100%",
                                                    }}
                                                >

                                                    {/* BIS COLUMN */}
                                                    <div>
                                                        <div style={{
                                                            color: "#d4af37",
                                                            fontSize: "13px",
                                                            marginBottom: "8px"
                                                        }}
                                                        > BiS
                                                        </div>

                                                        <div style={{display: "flex", gap: "10px"}}>
                                                            {group.bis.map((name, idx) => {
                                                                const charData = characters.find(c => c.name === name);

                                                                return (
                                                                    <div
                                                                        key={idx}
                                                                        style={{
                                                                            display: "flex",
                                                                            flexDirection: "column",
                                                                            alignItems: "center"
                                                                        }}>
                                                                        <img
                                                                            src={`http://localhost:8080${charData?.iconUrl}`}
                                                                            alt={name}
                                                                            title={name}
                                                                            style={{
                                                                                width: "70px",
                                                                                height: "70px",
                                                                                borderRadius: "12px",
                                                                                objectFit: "cover",
                                                                                border: "2px solid #d4af37"
                                                                            }}/>
                                                                        <div style={{
                                                                            fontSize: "12px",
                                                                            color: "white",
                                                                            marginTop: "4px",
                                                                            maxWidth: "90px",
                                                                            textAlign: "center",
                                                                            wordWrap: "break-word",
                                                                            whiteSpace: "normal",
                                                                            lineHeight: "1.1"
                                                                        }}>
                                                                            {name}
                                                                        </div>
                                                                    </div>
                                                                );
                                                            })}
                                                        </div>
                                                    </div>

                                                    {/* GENERALIST COLUMN */}
                                                    <div>
                                                        <div
                                                            style={{
                                                                color: "#64748b",
                                                                fontSize: "13px",
                                                                marginBottom: "8px"
                                                            }}
                                                        >
                                                            Generalist
                                                        </div>

                                                        <div style={{display: "flex", gap: "10px"}}>
                                                            {group.generalist.map((name, idx) => {
                                                                const charData = characters.find(c => c.name === name);

                                                                return (
                                                                    <div
                                                                        key={idx}
                                                                        style={{
                                                                            display: "flex",
                                                                            flexDirection: "column",
                                                                            alignItems: "center"
                                                                        }}
                                                                    >
                                                                        <img
                                                                            src={`http://localhost:8080${charData?.iconUrl}`}
                                                                            alt={name}
                                                                            title={name}
                                                                            style={{
                                                                                width: "70px",
                                                                                height: "70px",
                                                                                borderRadius: "12px",
                                                                                objectFit: "cover",
                                                                                border: "2px solid #64748b"
                                                                            }}
                                                                        />
                                                                        <div style={{
                                                                            fontSize: "12px",
                                                                            color: "white",
                                                                            marginTop: "4px",
                                                                            maxWidth: "90px",
                                                                            textAlign: "center",
                                                                            wordWrap: "break-word",
                                                                            whiteSpace: "normal",
                                                                            lineHeight: "1.1"
                                                                        }}>
                                                                            {name}
                                                                        </div>
                                                                    </div>
                                                                );
                                                            })}
                                                        </div>
                                                    </div>

                                                    {/* F2P COLUMN */}
                                                    <div>
                                                        <div
                                                            style={{
                                                                color: "#22c55e",
                                                                fontSize: "13px",
                                                                marginBottom: "8px"
                                                            }}
                                                        >
                                                            F2P
                                                        </div>

                                                        <div style={{display: "flex", gap: "10px"}}>
                                                            {group.f2p.map((name, idx) => {
                                                                const charData = characters.find(c => c.name === name);

                                                                return (
                                                                    <div
                                                                        key={idx}
                                                                        style={{
                                                                            display: "flex",
                                                                            flexDirection: "column",
                                                                            alignItems: "center"
                                                                        }}
                                                                    >
                                                                        <img
                                                                            src={`http://localhost:8080${charData?.iconUrl}`}
                                                                            alt={name}
                                                                            title={name}
                                                                            style={{
                                                                                width: "70px",
                                                                                height: "70px",
                                                                                borderRadius: "12px",
                                                                                objectFit: "cover",
                                                                                border: "2px solid #22c55e"
                                                                            }}
                                                                        />
                                                                        <div style={{
                                                                            fontSize: "12px",
                                                                            color: "white",
                                                                            marginTop: "4px",
                                                                            maxWidth: "90px",
                                                                            textAlign: "center",
                                                                            wordWrap: "break-word",
                                                                            whiteSpace: "normal",
                                                                            lineHeight: "1.1"
                                                                        }}>
                                                                            {name}
                                                                        </div>
                                                                    </div>
                                                                );
                                                            })}
                                                        </div>
                                                    </div>
                                                </div>

                                            </div>
                                        ))}
                                    </div>
                                </div>
                            ))}
                        </>
                    )}
                </div>
            </div>
        </div>
    );
}

export default TeamBuilder;