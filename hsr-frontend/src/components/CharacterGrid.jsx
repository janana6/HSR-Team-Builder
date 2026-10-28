import CharacterAvatar from "./CharacterAvatar";

export default function CharacterGrid({
                                          characters,
                                          isEditingRoster,
                                          stagedOwnedIds,
                                          ownedCharacterIds,
                                          selectedCharacter,
                                          onSelectCharacter,
                                      }) {
    return (
        <div style={{ display: "grid", gridTemplateColumns: "repeat(4, 1fr)", gap: "6px", marginTop: "25px" }}>
            {characters.map((c) => {
                const isOwned = isEditingRoster ? stagedOwnedIds.has(c.id) : ownedCharacterIds.has(c.id);
                const isSelected = selectedCharacter?.id === c.id;

                return (
                    <div
                        key={c.id}
                        style={{
                            transform: isSelected ? "scale(1.05)" : "scale(1)",
                            transition: "transform 0.2s ease",
                        }}
                    >
                        <CharacterAvatar
                            name={c.name}
                            iconUrl={c.iconUrl}
                            isOwned={isOwned}
                            size="90%"
                            fontSize="13px"
                            border={isSelected ? "2px solid #2563eb" : "1px solid #112234"}
                            onClick={() => onSelectCharacter(c, isOwned)}
                        />
                    </div>
                );
            })}
        </div>
    );
}