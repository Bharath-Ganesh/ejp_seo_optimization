# Order Service

## Overview
The **Order Service** is a Spring Boot microservice within the Education Justice Project portal responsible for managing guide distribution orders. It supports:

- Placing new orders for printed Reentry Guides
- Assigning orders to delivery agents
- Tracking and updating order status
- Querying orders by user, agent, or status

## Tech Stack
- Java 11
- Spring Boot 2.x
- Spring Data JPA
- Spring Security + JWT
- SpringFox Swagger 2
- MySQL 8 (or compatible)
- Maven 3.6+
- Lombok

## Prerequisites
- JDK 11 or higher
- Maven 3.6+
- MySQL 8 (or Docker)
- Git

## Setup & Configuration

1. **Clone the Monorepo**
   ```bash
   git clone https://github.com/Bharath-Ganesh/ejp_seo_optimization.git
   cd ejp_seo_optimization/order-service
   ```

2. **Database**
    - Create the database:
      ```sql
      CREATE DATABASE parcel_xyz;
      ```
    - Configure `src/main/resources/application.properties`:
      ```properties
      spring.datasource.url=jdbc:mysql://localhost:3306/parcel_xyz
      spring.datasource.username=root
      spring.datasource.password=root
      spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
 
      spring.jpa.hibernate.ddl-auto=update
      spring.jpa.show-sql=true
      spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect
      ```

3. **Environment Variables**
    - `USER_SERVICE_BASE_URL`: URL of the User Service (e.g., `http://localhost:8001/userservice`)

## Build & Run

```bash
mvn clean package
mvn spring-boot:run
```
The service will start on `http://localhost:8003/orderservice`.

## API Documentation

- **Swagger UI**: `http://localhost:8003/orderservice/swagger-ui.html`
- **OpenAPI JSON**: `http://localhost:8003/orderservice/v2/api-docs`

## REST Endpoints

| Method | Path                               | Description                                      | Roles       |
|-------:|------------------------------------|--------------------------------------------------|-------------|
| POST   | `/orderservice/orders`             | Place a new guide order                          | `USER`      |
| POST   | `/orderservice/orders/assign`      | Assign an order to a delivery agent              | `ADMIN`     |
| GET    | `/orderservice/orders/{id}`        | Get order details by ID                          | `USER`, `ADMIN` |
| GET    | `/orderservice/orders/user/{userId}` | List orders placed by a specific user          | `USER`      |
| GET    | `/orderservice/orders/agent/{agentId}` | List orders assigned to a specific agent      | `ADMIN`     |
| GET    | `/orderservice/orders/status/{status}` | List orders by their current status          | `ADMIN`     |

## Security
- JWT-based authentication
- Role-based authorization via `@PreAuthorize`

## Logging
- SLF4J with Logback
- Default level: INFO
- Configurable in `application.properties`

## Testing
Run unit and integration tests:
```bash
mvn test
```

## Contributing
1. Fork the repo
2. Create a branch: `git checkout -b feature/xyz`
3. Commit: `git commit -m "feat: ..."`
4. Push and open a Pull Request

## License
MIT License (see `LICENSE`)
