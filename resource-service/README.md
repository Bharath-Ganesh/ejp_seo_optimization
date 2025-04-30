# Resource Service

## Overview
The **Resource Service** is a Spring Boot microservice responsible for managing Reentry Guide metadata for the Education Justice Project. It provides:

- CRUD operations for guide metadata (title, slug, description, tags, PDF URL, coordinates)
- Slug-based lookup for clean URLs
- Full-text search over title, description, and tags
- Auto-generated Swagger 2 API documentation

This service will power the `/resources` endpoints consumed by the SSR frontend.

## Tech Stack
- Java 11
- Spring Boot 2.x
- Spring Data JPA
- MySQL 5.7+ (or Dockerized MySQL 8)
- Springfox Swagger 2.9.2
- Maven 3.6+

## Prerequisites
- JDK 11 installed and `JAVA_HOME` set
- Maven 3.6+ installed
- MySQL database named `parcel_xyz` (see Database Setup)
- Git

## Setup & Configuration

1. **Clone this module** into your monorepo under `resource-service/`:
   ```bash
   git clone <monorepo-url> --single-branch --branch main
   cd resource-service
   ```

2. **Configure the datasource** in `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/parcel_xyz
   spring.datasource.username=root
   spring.datasource.password=root
   spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver

   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
   ```

3. **Database Setup**
    - **Local MySQL**:
      ```sql
      CREATE DATABASE parcel_xyz;
      ```
    - **Docker**:
      ```bash
      docker run -d --name ejp-mysql \
        -e MYSQL_ROOT_PASSWORD=root \
        -e MYSQL_DATABASE=parcel_xyz \
        -p 3306:3306 mysql:8.0
      ```

## Building & Running

From within `resource-service/`:

```bash
# Build the JAR
mvn clean package

# Run the application
mvn spring-boot:run
```
The service will start on **http://localhost:8002/**.

## API Documentation

Once running, you can explore API docs at:

- Swagger UI:  http://localhost:8002/swagger-ui.html
- OpenAPI JSON: http://localhost:8002/v2/api-docs

## Endpoints

| Method | Path                   | Description                               |
|-------:|------------------------|-------------------------------------------|
| GET    | `/resources`           | List all guides                           |
| GET    | `/resources/{slug}`    | Retrieve guide by slug                    |
| GET    | `/resources/search`    | Full-text search: `?q={query}`            |
| POST   | `/resources`           | Create a new guide (ADMIN only)           |
| PUT    | `/resources/{id}`      | Update an existing guide (ADMIN only)     |
| DELETE | `/resources/{id}`      | Delete a guide by ID (ADMIN only)         |

## Security

- To be integrated with JWT-based authentication and role-based authorization.
- Future endpoints under `/admin/resources/**` should require the `ADMIN` role.

## Logging

Logs are output to the console by default. You can configure file-based logging in `application.properties` if needed.

## Contributing

1. Fork the monorepo and checkout the `resource-service/` module.
2. Create a feature branch: `git checkout -b feature/xyz`.
3. Implement your changes and add tests.
4. Commit, push, and open a Pull Request against `main`.

## License

This module is part of the Education Justice Project and is licensed under the MIT License. See the monorepo `LICENSE` file for details.
