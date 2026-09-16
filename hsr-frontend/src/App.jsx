import { Routes, Route } from "react-router-dom";
import TeamBuilder from "./TeamBuilder.jsx";

function App() {
    return (
        <Routes>
            <Route path="/" element={<TeamBuilder />} />
            <Route path="/characters" element={<TeamBuilder />} />
            <Route path="/build/:name" element={<TeamBuilder />} />
        </Routes>
    );
}

export default App;