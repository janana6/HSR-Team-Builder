import CharacterAvatar from "./CharacterAvatar";

export default function TeamCompositions({ teamCompositions, characters, ownedCharacterIds, onSelectCharacter }) {
    if (!teamCompositions || teamCompositions.length === 0) return null;

    return (
        <div style={{
            display: "flex",
            justifyContent: "space-between",
            flexWrap: "nowrap",
            gap: "70px",
            marginTop: "10px",
        }}>
            {teamCompositions.map((team, i) => (
                <div key={i} style={{ minWidth: "220px" }}>
                    <strong style={{ color: "#dbe7ff" }}>
                        {team.name}
                    </strong>

                    <div style={{ display: "flex", gap: "15px", marginTop: "10px" }}>
                        {team.characters.map((c, idx) => {
                            const charData = characters.find((x) => x.name === c);
                            const isOwned = charData && ownedCharacterIds.has(charData.id);

                            return (
                                <CharacterAvatar
                                    key={idx}
                                    name={c}
                                    iconUrl={charData?.iconUrl}
                                    isOwned={isOwned}
                                    size="90px"
                                    border="1px solid #2a3b4d"
                                    onClick={() => onSelectCharacter && onSelectCharacter(c)}
                                />
                            );
                        })}
                    </div>
                </div>
            ))}
        </div>
    );
}