# spring-security-rest-api

A Spring Boot REST API project secured with Spring Security and backed by MySQL.

## Tech stack
- Java 21
- Spring Boot 4.1.1
- Spring Security
- Spring Data JPA
- MySQL

## Project structure
- `hariom/` - main application module
- `hariom/src/main/java` - Java source files
- `hariom/src/main/resources` - configuration files
- `hariom/src/test/java` - test classes

## Run locally
```bash
cd hariom
./mvnw clean install
./mvnw spring-boot:run
```

## Configuration
Create or update `src/main/resources/application.properties` with your database and app settings.

Example:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/spring_security_api
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## Notes
This project is a learning/demo REST API and can be extended with JWT auth, role-based access, user management, and CRUD APIs.
