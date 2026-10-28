import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import LeftPanel from "./components/LeftPanel";
import RightPanel from "./components/RightPanel";

const BASE_URL = "http://localhost:8080";

export default function TeamBuilder() {
    const navigate = useNavigate();
    const { name } = useParams();

    const [characters, setCharacters] = useState([]);
    const [selectedCharacter, setSelectedCharacter] = useState(null);
    const [search, setSearch] = useState("");
    const [roleFilter, setRoleFilter] = useState("All");
    const [elementFilter, setElementFilter] = useState("All");
    const [pathFilter, setPathFilter] = useState("All");
    const [rarityFilter, setRarityFilter] = useState("All");

    const [characterBuild, setCharacterBuild] = useState(null);
    const [loadingBuild, setLoadingBuild] = useState(false);
    const [buildError, setBuildError] = useState(false);

    const [ownedCharacterIds, setOwnedCharacterIds] = useState(() => {
        try { return new Set(JSON.parse(localStorage.getItem("ownedCharacterIds") || "[]")); }
        catch { return new Set(); }
    });

    const [isEditingRoster, setIsEditingRoster] = useState(false);
    const [stagedOwnedIds, setStagedOwnedIds] = useState(new Set());

    const resetFilters = () => {
        setRoleFilter("All"); setElementFilter("All"); setPathFilter("All"); setRarityFilter("All"); setSearch("");
    };

    const startEditRoster = () => { setStagedOwnedIds(new Set(ownedCharacterIds)); setIsEditingRoster(true); };
    const cancelEditRoster = () => { setStagedOwnedIds(new Set()); setIsEditingRoster(false); };
    const saveEditRoster = () => {
        setOwnedCharacterIds(new Set(stagedOwnedIds));
        localStorage.setItem("ownedCharacterIds", JSON.stringify([...stagedOwnedIds]));
        setIsEditingRoster(false);
    };

    const toggleStagedOwned = (id) => {
        setStagedOwnedIds((curr) => {
            const next = new Set(curr);
            next.has(id) ? next.delete(id) : next.add(id);
            return next;
        });
    };

    const toggleSelectAllFor = (chars) => {
        const ids = chars.map((c) => c.id);
        const allSelected = ids.length > 0 && ids.every((id) => stagedOwnedIds.has(id));
        setStagedOwnedIds((curr) => {
            const next = new Set(curr);
            allSelected ? ids.forEach((id) => next.delete(id)) : ids.forEach((id) => next.add(id));
            return next;
        });
    };

    useEffect(() => {
        fetch(`${BASE_URL}/characters`)
            .then((res) => {
                if (!res.ok) throw new Error("Failed to fetch characters");
                return res.json();
            })
            .then((data) => setCharacters(data))
            .catch((err) => console.error("ERROR:", err));
    }, []);

    useEffect(() => {
        if (!name) return;
        const loadBuild = async () => {
            try {
                setLoadingBuild(true);
                setBuildError(false);
                const res = await fetch(`${BASE_URL}/characters/build/${encodeURIComponent(name)}`);
                if (!res.ok) throw new Error("Failed to fetch character build");
                const data = await res.json();
                setCharacterBuild(data);
            } catch (err) {
                console.error(err);
                setCharacterBuild(null);
                setBuildError(true);
            } finally {
                setLoadingBuild(false);
            }
        };
        loadBuild();
    }, [name]);

    const filteredCharacters = characters
        .filter((c) => {
            const roleMatch = roleFilter === "All" || c.role === roleFilter;
            const elementMatch = elementFilter === "All" || c.element === elementFilter;
            const searchMatch = c.name.toLowerCase().includes(search.toLowerCase());
            const pathMatch = pathFilter === "All" || c.path === pathFilter;
            const rarityMatch = rarityFilter === "All" || String(c.rarity) === rarityFilter;
            return roleMatch && elementMatch && pathMatch && rarityMatch && searchMatch;
        })
        .sort((a, b) => a.name.localeCompare(b.name));

    return (
        <div style={{ margin: "0 100px", padding: "10px 20px", boxSizing: "border-box" }}>
            <div style={{ display: "flex", alignItems: "center", marginBottom: "15px", padding: "30px 0", gap: "12px" }}>
                <div style={{ fontSize: "55px", color: "#FFFFFF" }}>✦</div>
                <div>
                    <h1 style={{ margin: 0, fontSize: "30px", fontWeight: "800", color: "#FFFFFF" }}>Honkai Star Rail - Team Builder</h1>
                    <p style={{ margin: "5px 0 0 0", fontSize: "15px", color: "#999" }}>SELECT YOUR ROSTER · GET META TEAM SUGGESTIONS</p>
                </div>
            </div>

            <div style={{ display: "flex", gap: "20px", alignItems: "flex-start" }}>
                <LeftPanel
                    search={search} setSearch={setSearch}
                    rarityFilter={rarityFilter} setRarityFilter={setRarityFilter}
                    roleFilter={roleFilter} setRoleFilter={setRoleFilter}
                    elementFilter={elementFilter} setElementFilter={setElementFilter}
                    pathFilter={pathFilter} setPathFilter={setPathFilter}
                    resetFilters={resetFilters}
                    isEditingRoster={isEditingRoster} startEditRoster={startEditRoster}
                    saveEditRoster={saveEditRoster} cancelEditRoster={cancelEditRoster}
                    filteredCharacters={filteredCharacters} stagedOwnedIds={stagedOwnedIds}
                    toggleSelectAllFor={toggleSelectAllFor}
                    ownedCharacterIds={ownedCharacterIds} selectedCharacter={selectedCharacter}
                    toggleStagedOwned={toggleStagedOwned}
                    onSelectCharacter={(c) => {
                        if (isEditingRoster) {
                            toggleStagedOwned(c.id);
                        } else {
                            setSelectedCharacter(c);
                            navigate(`/build/${c.name}`);
                            window.scrollTo({ top: 0, behavior: "smooth" });
                        }
                    }}
                />

                <RightPanel
                    buildError={buildError}
                    loadingBuild={loadingBuild}
                    characterBuild={characterBuild}
                    characters={characters}
                    ownedCharacterIds={ownedCharacterIds}
                    onSelectCharacter={(name) => {
                        navigate(`/build/${name}`);
                        window.scrollTo({ top: 0, behavior: "smooth" });
                    }}
                />
            </div>
        </div>
    );
}