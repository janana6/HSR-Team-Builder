import CharacterFilters from "./CharacterFilters";
import CharacterGrid from "./CharacterGrid";

export default function LeftPanel({
                                      search, setSearch,
                                      rarityFilter, setRarityFilter,
                                      roleFilter, setRoleFilter,
                                      elementFilter, setElementFilter,
                                      pathFilter, setPathFilter,
                                      resetFilters,
                                      isEditingRoster, startEditRoster, saveEditRoster, cancelEditRoster,
                                      filteredCharacters, stagedOwnedIds, toggleSelectAllFor,
                                      ownedCharacterIds, selectedCharacter, toggleStagedOwned, onSelectCharacter
                                  }) {
    return (
        <div style={{
            flex: "0 0 30%",
            border: "1px solid #112234",
            borderRadius: "20px",
            padding: "15px",
            background: "#0f1525",
            boxShadow: "0 2px 8px rgba(0,0,0,0.05)",
        }}>
            <CharacterFilters
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
            />

            <CharacterGrid
                characters={filteredCharacters}
                isEditingRoster={isEditingRoster}
                stagedOwnedIds={stagedOwnedIds}
                ownedCharacterIds={ownedCharacterIds}
                selectedCharacter={selectedCharacter}
                toggleStagedOwned={toggleStagedOwned}
                onSelectCharacter={onSelectCharacter}
            />
        </div>
    );
}