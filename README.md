# Honkai Star Rail Team Builder

HSR Team Builder is a full-stack web app for exploring Honkai: Star Rail characters, filtering the roster, and viewing suggested team comps built around each character.

The project combines a Spring Boot backend with a React frontend. The backend exposes character data and build recommendations, while the frontend lets users browse the roster, filter characters, and open dedicated build pages.

## Features

- Browse the current Honkai: Star Rail roster
- Filter characters by rarity, role, element, and path
- Search characters by name
- Open per-character build pages at `/build/:name`
- View recommended teammates grouped by playstyle:
  - BiS
  - Generalist
  - F2P-friendly
- Track owned characters locally in the browser for roster planning
- Call the backend API from the frontend via CORS

## Tech Stack

- Frontend: React, Vite, React Router
- Backend: Java 21, Spring Boot 3.5, Spring Web, Spring Data JPA
- Database: PostgreSQL
- Local infrastructure: Docker Compose

## Project Structure

```text
.
├── .env
├── .gitignore
├── compose.yaml
├── HELP.md
├── mvnw
├── mvnw.cmd
├── pom.xml
├── README.md
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── io/github/janana6/hsrteambuilder/
│   │   │       ├── config/
│   │   │       ├── data/
│   │   │       ├── dto/
│   │   │       ├── model/
│   │   │       ├── repository/
│   │   │       ├── service/
│   │   │       └── web/
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── data.sql
│   │       └── static/avatar/
│   └── test/
│       └── java/io/github/janana6/hsrteambuilder/
├── hsr-frontend/
│   ├── package.json
│   ├── package-lock.json
│   ├── vite.config.js
│   ├── index.html
│   ├── public/
│   └── src/
│       ├── App.jsx
│       ├── TeamBuilder.jsx
│       ├── main.jsx
│       ├── index.css
│       └── components/
│           ├── CharacterAvatar.jsx
│           ├── CharacterFilters.jsx
│           ├── CharacterGrid.jsx
│           ├── LeftPanel.jsx
│           ├── RightPanel.jsx
│           ├── TeamCompositions.jsx
│           ├── TeammateList.jsx
└── target/
```

## Backend Overview

The backend is a Spring Boot application with a PostgreSQL data store and a lightweight service layer.

### Main backend packages

- `config/` – application configuration, including CORS setup
- `data/` – data loading logic for character build metadata
- `dto/` – request/response objects
- `model/` – JPA entities such as `GameCharacter`, `User`, and `Team`
- `repository/` – Spring Data repositories
- `service/` – business logic for characters, users, and team data
- `web/` – REST controllers such as `GameCharacterController` and `UserController`

## Frontend Overview

The frontend is a Vite + React app that renders the roster and build pages.

### Main frontend routes

- `/` – home roster view
- `/characters` – roster view
- `/build/:name` – dedicated character build page

The frontend fetches data from the backend at `http://localhost:8080` and renders it in the UI.

## Local Setup

### 1. Start PostgreSQL

The project includes a Docker Compose file for the database.

```bash
docker compose up -d postgres
```

This uses the values in the root `.env` file.

### 2. Configure environment variables

If you are not using Docker, make sure a PostgreSQL instance is running on `localhost:5432` with the same database name and credentials.

### 3. Start the backend

From the project root:

```bash
./mvnw spring-boot:run
```

The backend runs on:

```text
http://localhost:8080
```

### 4. Start the frontend

From the `hsr-frontend` directory:

```bash
npm install
npm run dev
```

The frontend runs on:

```text
http://localhost:5173
```

### 5. Open the app

Visit:

```text
http://localhost:5173
```

## API Endpoints

The backend exposes character data under the `/characters` route.

### Character endpoints

- `GET /characters` – return the full roster
- `GET /characters/filter` – filter the roster by query params such as:
  - `role`
  - `element`
  - `path`
  - `rarity`
- `GET /characters/build/{name}` – return build info and recommended teammates for a character

Examples:

```text
GET /characters
GET /characters/build/Acheron
```

Character names are resolved in a case-insensitive manner in the UI route and API flow.

## Future Improvements

- Save custom team compositions
- Add user authentication and profiles
- Add a "Favorites" feature for teams
- Add detailed synergy explanations

## Notes for Development

- The backend is configured for PostgreSQL and uses port `8080`.
- The React app uses Vite and runs on port `5173`.
- CORS is enabled for `http://localhost:5173`.
- Character avatar images are stored under `src/main/resources/static/avatar/`.

## License

This project is intended for educational and portfolio use. Honkai: Star Rail and its related assets are the property of HoYoverse.