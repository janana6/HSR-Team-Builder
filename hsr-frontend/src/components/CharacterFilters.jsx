export default function CharacterFilters({
    search, setSearch,
    rarityFilter, setRarityFilter,
    roleFilter, setRoleFilter,
    elementFilter, setElementFilter,
    pathFilter, setPathFilter,
    resetFilters,
    isEditingRoster, startEditRoster, saveEditRoster, cancelEditRoster,
    filteredCharacters, stagedOwnedIds, toggleSelectAllFor
}) {
    return (
        <div style={{ marginBottom: "10px" }}>
            <input
                type="text"
                placeholder="Search characters..."
                value={search}
                onChange={(e) => setSearch(e.target.value)}
                style={{
                    width: "100%",
                    padding: "6px",
                    marginBottom: "10px",
                    border: "1px solid #112234",
                    borderRadius: "6px",
                    background: "#080c1d",
                    color: "#fff"
                }}
            />

            <select value={rarityFilter} onChange={(e) => setRarityFilter(e.target.value)} style={{ width: "48%", marginTop: "10px", marginRight: "4%", background: "#080c1d", color: "#fff" }}>
                <option value="All">All Rarities</option>
                <option value="5">5 ★</option>
                <option value="4">4 ★</option>
            </select>
            <select value={roleFilter} onChange={(e) => setRoleFilter(e.target.value)} style={{ width: "48%", background: "#080c1d", color: "#fff" }}>
                <option value="All">All Roles</option>
                <option value="DPS">DPS</option>
                <option value="Support">Support</option>
                <option value="Sustain">Sustain</option>
                <option value="Flex">Flex</option>
            </select>

            <select value={elementFilter} onChange={(e) => setElementFilter(e.target.value)} style={{ width: "48%", marginRight: "4%", marginTop: "10px", background: "#080c1d", color: "#fff" }}>
                <option value="All">All Elements</option>
                <option value="Fire">Fire</option>
                <option value="Ice">Ice</option>
                <option value="Lightning">Lightning</option>
                <option value="Wind">Wind</option>
                <option value="Quantum">Quantum</option>
                <option value="Imaginary">Imaginary</option>
            </select>
            <select value={pathFilter} onChange={(e) => setPathFilter(e.target.value)} style={{ width: "48%", marginTop: "10px", background: "#080c1d", color: "#fff" }}>
                <option value="All">All Paths</option>
                <option value="Destruction">Destruction</option>
                <option value="Hunt">Hunt</option>
                <option value="Erudition">Erudition</option>
                <option value="Harmony">Harmony</option>
                <option value="Nihility">Nihility</option>
                <option value="Abundance">Abundance</option>
                <option value="Preservation">Preservation</option>
            </select>

            {!isEditingRoster ? (
                <div style={{ display: "flex", justifyContent: "flex-end", gap: "8px", marginTop: "10px" }}>
                    <button onClick={resetFilters} style={{ padding: "4px 10px", fontSize: "11px", borderRadius: "6px", border: "1px solid #112234", background: "#1a2235", color: "white", cursor: "pointer" }}>Reset</button>
                    <button onClick={startEditRoster} style={{ padding: "4px 10px", fontSize: "11px", borderRadius: "6px", border: "1px solid #112234", background: "#2563eb", color: "white", cursor: "pointer" }}>Edit Roster</button>
                </div>
            ) : (
                <div style={{ display: "flex", justifyContent: "flex-end", alignItems: "center", gap: "8px", marginTop: "10px" }}>
                    <label style={{ color: "#cbd5e1", fontSize: "13px", marginRight: "auto" }}>
                        <input
                            type="checkbox"
                            checked={filteredCharacters.length > 0 && filteredCharacters.every((ch) => stagedOwnedIds.has(ch.id))}
                            onChange={() => toggleSelectAllFor(filteredCharacters)}
                        /> Select all
                    </label>
                    <button onClick={saveEditRoster} style={{ padding: "4px 10px", fontSize: "11px", borderRadius: "6px", border: "1px solid #112234", background: "#16a34a", color: "white", cursor: "pointer" }}>Save</button>
                    <button onClick={cancelEditRoster} style={{ padding: "4px 10px", fontSize: "11px", borderRadius: "6px", border: "1px solid #112234", background: "#1a2235", color: "white", cursor: "pointer" }}>Cancel</button>
                </div>
            )}
        </div>
    );
}