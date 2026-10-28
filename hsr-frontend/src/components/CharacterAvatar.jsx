export default function CharacterAvatar({
    name,
    iconUrl,
    isOwned = true,
    size = "70px",
    border = "1px solid #2a3b4d",
    fontSize = "13px",
    onClick
}) {
    return(
        <div
            onClick={onClick}
            style={{
                display: "flex",
                flexDirection: "column",
                alignItems: "center",
                width: size === "100%" ? "100%" : "size",
                cursor: onClick ? "pointer" : "default",
                opacity: isOwned ? 1 : 0.35,
                filter: isOwned ? "none" : "grayscale(1)",
                transition: "0.2s",
            }}
        >
            <img
                src={`http://localhost:8080${iconUrl}`}
                alt={name}
                title={name}
                style={{
                    width: size,
                    height: size === "100%" ? "auto" : size,
                    aspectRatio: "1 / 1",
                    borderRadius: "12px",
                    objectFit: "cover",
                    border: border,
                }}
            />
            <span style={{
                fontSize: fontSize,
                color: "white",
                marginTop: "4px",
                width: "100%",
                textAlign: "center",
                wordBreak: "break-word",
                overflowWrap: "break-word",
                whiteSpace: "normal",
                lineHeight: "1.1"
            }}>
                {name}
            </span>
        </div>
    );
}