// src/components/RightPanel.jsx
import TeamCompositions from "./TeamCompositions";
import TeammateList from "./TeammateList";

export default function RightPanel({
                                       buildError,
                                       loadingBuild,
                                       characterBuild,
                                       characters,
                                       ownedCharacterIds,
                                       onSelectCharacter
                                   }) {
    return (
        <div style={{
            flex: 1,
            border: "1px solid #112234",
            borderRadius: "20px",
            padding: "15px",
            background: "#0f1525",
            boxShadow: "0 2px 8px rgba(0,0,0,0.05)"
        }}>
            {buildError ? (
                <p style={{ color: "#ef4444" }}>Character not found</p>
            ) : loadingBuild ? (
                <p style={{ color: "#cbd5e1" }}>Loading...</p>
            ) : !characterBuild ? (
                <p style={{ color: "#cbd5e1" }}>Click a character to view build</p>
            ) : (
                <>
                    <h2 style={{ color: "white", marginBottom: "4px", marginTop: "0" }}>
                        {characterBuild.name}
                    </h2>

                    <p style={{ color: "#94a3b8", marginTop: "0" }}>
                        {characterBuild.element} • {characterBuild.path}
                    </p>

                    {characterBuild.variants?.map((variant, vIdx) => (
                        <div key={vIdx} style={{ marginTop: "25px" }}>
                            <h3 style={{
                                color: "#ffffff",
                                marginBottom: "10px",
                                fontSize: "22px",
                                fontWeight: "700",
                            }}>
                                {variant.playstyle}
                            </h3>

                            <div style={{
                                background: "#0d1326",
                                border: "1px solid #1b2a3a",
                                borderRadius: "12px",
                                padding: "16px",
                                display: "flex",
                                flexDirection: "column",
                                gap: "20px"
                            }}>
                                <TeamCompositions
                                    teamCompositions={variant.teamCompositions}
                                    characters={characters}
                                    ownedCharacterIds={ownedCharacterIds}
                                    onSelectCharacter={onSelectCharacter}
                                />

                                <TeammateList
                                    recommendations={variant.teammateRecommendations}
                                    characters={characters}
                                    ownedCharacterIds={ownedCharacterIds}
                                    onSelectCharacter={onSelectCharacter}
                                />
                            </div>
                        </div>
                    ))}
                </>
            )}
        </div>
    );
}