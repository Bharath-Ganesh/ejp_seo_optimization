# User Service

## 1. Overview
The **User Service** is a Spring Boot microservice that manages user profiles for the Education Justice Project. It supports:

- User registration & login (JWT issuance)
- Profile retrieval & updates
- Full-text search on username/email
- Role-based status toggling (e.g., ACTIVE/INACTIVE)

## 2. Tech Stack
- **Language:** Java 11
- **Framework:** Spring Boot 2.x
- **Build Tool:** Maven
- **Database:** MySQL 8 (or Docker)
- **API Documentation:** Swagger 2 (SpringFox 2.9.1)
- **Security:** Spring Security + JWT
- **Logging:** Logback with SLF4J
- **Testing:** JUnit 5, Spring Boot Test

## 3. Prerequisites
- JDK 11
- Maven 3.6+
- MySQL 8 (or Docker)
- Git


## 4. Database
Local MySQL:
CREATE DATABASE parcel_xyz;

Docker MySQL:
docker run -d --name ejp-mysql \
-e MYSQL_ROOT_PASSWORD=root \
-e MYSQL_DATABASE=parcel_xyz \
-p 3306:3306 mysql:8.0

## 5. Building & Running

mvn clean package
mvn spring-boot:run

## 6. Project Structure
src/main/java/com/xyz/user/
├── UserApplication.java        # Main + Swagger config
├── controller/
│   └── UserController.java     # REST endpoints
├── service/
│   └── UserService.java        # Business logic & JWT handling
├── repository/
│   └── UserRepository.java     # JPA repository + search
└── entity/
└── User.java               # JPA entity mapping


## 7. API End Points
| Method | Path                                    | Description                           |
|-------:|-----------------------------------------|---------------------------------------|
| POST   | `/userservice/user/register`            | Register new user (returns JWT)       |
| POST   | `/userservice/user/login`               | Authenticate (returns JWT)            |
| GET    | `/userservice/user/{id}`                | Retrieve user profile                 |
| GET    | `/userservice/user/search?q={term}`     | Full-text search on username/email    |
| PUT    | `/userservice/user/{id}/status/{state}` | Update user availability/status       |


## 8. Security
1. JWT-based authentication
2. Role-based access control (USER, ADMIN)
3. Passwords stored as BCrypt hashes
