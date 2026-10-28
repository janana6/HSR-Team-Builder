import CharacterAvatar from "./CharacterAvatar";

export default function TeammateList({ recommendations, characters, ownedCharacterIds, onSelectCharacter }) {
    if (!recommendations || recommendations.length === 0) return null;

    return (
        <div style={{
            display: "flex",
            flexDirection: "column",
            gap: "25px",
            marginTop: "25px",
            // border: "1px solid #1b2a3a",
            // borderRadius: "12px",
            // padding: "16px",
            // background: "#0d1326",
        }}>
            {recommendations.map((group, i) => (
                <div key={i}>
                    <div style={{ color: "#dbe7ff", fontWeight: "700", marginBottom: "12px", fontSize: "18px" }}>
                        {group.type}
                    </div>

                    <div style={{
                        display: "grid",
                        gridTemplateColumns: "repeat(3, minmax(0, 1fr))",
                        gap: "15px",
                        alignItems: "start",
                        width: "100%",
                    }}>
                        <CharacterColumn title="BiS" color="#d4af37" names={group.bis} characters={characters} ownedCharacterIds={ownedCharacterIds} onSelectCharacter={onSelectCharacter} />
                        <CharacterColumn title="Generalist" color="#64748b" names={group.generalist} characters={characters} ownedCharacterIds={ownedCharacterIds} onSelectCharacter={onSelectCharacter}/>
                        <CharacterColumn title="F2P" color="#22c55e" names={group.f2p} characters={characters} ownedCharacterIds={ownedCharacterIds} onSelectCharacter={onSelectCharacter}/>
                    </div>
                </div>
            ))}
        </div>
    );
}

function CharacterColumn({ title, color, names, characters, ownedCharacterIds, onSelectCharacter }) {
    if (!names || names.length === 0) return null;

    return (
        <div>
            <div style={{ color: color, fontSize: "13px", marginBottom: "8px", fontWeight: "600" }}>
                {title}
            </div>
            <div style={{ display: "flex", gap: "12px", flexWrap: "wrap" }}>
                {names.map((name, idx) => {
                    const charData = characters.find((c) => c.name === name);
                    const isOwned = charData && ownedCharacterIds.has(charData.id);

                    return (
                        <div key={idx} style={{ width: "70px" }}>
                            <CharacterAvatar
                                name={name}
                                iconUrl={charData?.iconUrl}
                                isOwned={isOwned}
                                size="70px"
                                fontSize="12px"
                                border={`2px solid ${color}`}
                                onClick={() => onSelectCharacter && onSelectCharacter(name)}
                            />
                        </div>
                    );
                })}
            </div>
        </div>
    );
}