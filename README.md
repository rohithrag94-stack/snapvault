# SnapVault

A private client-gallery platform for photographers, in the style of Pixieset. A photographer creates a gallery per shoot, uploads photos into it, and invites clients to view the gallery and mark favorites.

![CI](https://github.com/rohithrag94-stack/snapvault/actions/workflows/ci.yml/badge.svg)

## Tech stack

- Java 21
- Spring Boot 4.1.1 (`spring-boot-starter-parent`)
- Maven (wrapper included in `backend/`)
- Spring Data JPA (Hibernate)
- Spring Web MVC
- Bean Validation (`spring-boot-starter-validation`)
- PostgreSQL JDBC driver

## Working so far

- [x] Spring Boot backend scaffold in `backend/`
- [x] PostgreSQL datasource configuration
- [x] JPA entities: `UserEntity`, `GalleryEntity`, `InvitationEntity`, `PhotoEntity`, `FavoriteEntity`
- [x] UUID primary keys and `createdAt`/`updatedAt` audit columns via Hibernate timestamps
- [x] Many-to-one relationships with foreign keys, and a unique constraint on favorites per user and photo
- [x] Spring Data JPA repositories

services, controllers and tests are not implemented yet. The Angular frontend hasn’t been started yet.

## Domain model

- A `User` (`UserEntity`) is either a `PHOTOGRAPHER` or a `CLIENT`, set by its role.
- A photographer owns many `Gallery` (`GalleryEntity`) rows; a gallery holds many `Photo` (`PhotoEntity`) rows.
- A gallery has many `Invitation` (`InvitationEntity`) rows, each sent to a client email and linked to a `User` once the invitee registers.
- A `Favorite` (`FavoriteEntity`) links one client to one photo, at most once per pair.

The full data model is in `docs/SnapVault-Data-Model.pdf`, with a diagram in `docs/snapvault_erd.svg`.

## Run it locally

Prerequisites: JDK 21 and PostgreSQL 18.

Create the database once (psql comes with PostgreSQL):

```bash
psql -U postgres -c "CREATE DATABASE snapvault;"
```

Configuration lives in `backend/src/main/resources/application.yaml`:

| Property | Value |
| --- | --- |
| `spring.datasource.url` | `jdbc:postgresql://localhost:5432/snapvault` |
| `spring.datasource.username` | `postgres` |
| `spring.datasource.password` | `admin` |
| `spring.jpa.hibernate.ddl-auto` | `update` (Hibernate creates and updates the tables) |

Start the backend:

macOS / Linux:

```bash
cd backend && ./mvnw spring-boot:run
```

Windows (PowerShell):

```powershell
cd backend; .\mvnw.cmd spring-boot:run
```

## Roadmap (planned)

- Kafka event-driven photo processing
- JWT authentication
- Angular frontend
- Real-time notifications
