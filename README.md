# Honkai: Star Rail Team Builder

A full-stack web application for exploring Honkai: Star Rail characters, viewing build recommendations, and creating stronger team compositions.

The project combines a React frontend with a Spring Boot REST API and PostgreSQL database. Users can browse characters, filter the roster, open dedicated build pages, and find teammate recommendations suited to different investment levels.

## Features

- Browse Honkai: Star Rail characters
- Filter characters by:
    - Rarity
    - Role
    - Element
    - Path
- View character build pages through routes such as `/build/Acheron`
- Case-insensitive character URLs, so `/build/Acheron`, `/build/acheron`, and `/build/ACHERON` load the same character
- Character build data provided through a backend data loader
- Team composition support and teammate recommendations:
    - BiS (Best in Slot)
    - Generalist
    - F2P-friendly
- React Router navigation
- Smooth navigation back to the top of the page when selecting a character
- REST API for character data under `/characters`

## Tech Stack

### Frontend

- React
- React Router
- JavaScript
- CSS

### Backend

- Java
- Spring Boot
- Spring Web
- Spring Data JPA

### Database

- PostgreSQL

## Architecture

```text
React Frontend
   │
   │ HTTP requests
   ▼
Spring Boot REST API
   │
   ├── Character repository / PostgreSQL database
   └── Build DataLoader
```

The frontend requests character information from the Spring Boot API. The API retrieves character records from PostgreSQL and combines them with build data loaded through the application's `DataLoader`.

## Project Structure

```text
project-root/
├── pom.xml
├── src/
│   └── main/
│       ├── java/
│       │   └── io/
│       │       └── github/
│       │           └── jna6/
│       │               └── hsrteambuilder/
│       │                   ├── web/          # Controllers: GameCharacterController, TeamController, UserController
│       │                   ├── service/      # Service layer
│       │                   ├── repository/   # JPA repositories
│       │                   └── config/       # CorsConfig.java
│       └── resources/                         # application.properties, data.sql, DataLoader
├── hsr-frontend/
│   ├── package.json
│   └── src/
│       ├── App.jsx
│       ├── TeamBuilder.jsx
│       └── main.jsx
├── .gitignore
└── README.md

## API Endpoints

All character-related endpoints are available under:

```text
/characters
```

Typical character API functionality includes:

| Endpoint | Description |
| --- | --- |
| `GET /characters` | Returns the available character roster |
| `GET /characters/{name}` | Returns details for one character |
| `GET /characters/build/{name}` | Returns build information for one character |

Character names are matched without regard to capitalization. For example:

```text
/build/Acheron
/build/acheron
/build/ACHERON
```

all open the same Acheron build page.

## Running the Project

### 1. Set up PostgreSQL

Create or configure a PostgreSQL database for the Spring Boot backend.

Update the backend database configuration with your local PostgreSQL connection details, including:

- Database URL
- Username
- Password

Make sure PostgreSQL is running before starting the backend.

### 2. Start the Spring Boot Backend

Open the backend project in your preferred Java IDE or use the Spring Boot run command configured for your project.

The backend runs locally on:

```text
http://localhost:8080
```

### 3. Start the React Frontend

Open the frontend project and run its configured development script.

The frontend runs locally on:

```text
http://localhost:5173
```

### 4. Open the Application

Visit:

```text
http://localhost:5173
```

The React application communicates with the Spring Boot API at:

```text
http://localhost:8080
```

## Character Build Pages

Each character can be opened through a dedicated route:

```text
/build/{characterName}
```

Example:

```text
/build/Acheron
```

The backend resolves the character from PostgreSQL using a case-insensitive lookup. It then loads the corresponding build information from the build data loader and returns a combined build response containing character details and recommendations.

## Team Recommendations

Character build pages can include recommended teammates grouped by playstyle and availability:

- **BiS:** optimal teammates for the character’s strongest team
- **Generalist:** flexible options that work in many teams
- **F2P:** accessible alternatives for players with limited character availability

## Future Improvements

- Save custom team compositions
- Add detailed synergy explanations
- Add character comparison tools

## Local Development Notes

- Backend default port: `8080`
- Frontend default port: `5173`
- Ensure the frontend is configured to request data from the local backend.
- Ensure the backend accepts requests from the frontend development server if cross-origin configuration is required.

## License

This project is intended for educational and portfolio use. Honkai: Star Rail and its related assets are the property of HoYoverse.