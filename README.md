# 🔐 Authentication System with Spring Boot + PostgreSQL (Java 21)

![Spring Initializr Setup](/public/springInitializr.png)
*Spring Boot project setup with dependencies*

![Postman JWT Test](/public/image.png)
*Postman test showing JWT authentication in action*

This project is a **JWT-based authentication system** built with **Spring Boot 3**, **Spring Security 6**, and **PostgreSQL**, fully compatible with **Java 21**.  

Inspired by 👉 [Implement JWT Authentication in a Spring Boot 3 Application](https://medium.com/@tericcabrel/implement-jwt-authentication-in-a-spring-boot-3-application-5839e4fd8fac).

---

# 🚀 Project Setup Guide

### 1️⃣ Initialize the Project
- Go to [Spring Initializr](https://start.spring.io/).
- **Do not select Spring Security** at this step.

---

### 2️⃣ Connect the Database
- Configure your database connection inside `application.properties` (MySQL/Postgres).

---

### 3️⃣ Create Users
- Define your **User entity**.
- Insert initial users into the database.

---

### 4️⃣ Add Security
- Once everything works, add **Spring Security**.
- Connect it with your users for authentication & authorization.

  
## 🎯 Features

- User registration & login
- JWT-based authentication & authorization
- Password hashing with BCrypt
- PostgreSQL as database
- Validation on incoming requests
- REST API endpoints (testable with Postman)
- Clean layered architecture
- Step-by-step learning via branches

---

## ⚙️ Dependencies

Your `pom.xml` includes:

- **Spring Data JPA** → ORM for database access  
- **Spring Security** → Authentication & Authorization  
- **Spring Web** → REST APIs  
- **PostgreSQL Driver** → PostgreSQL database integration  
- **Lombok** → Reduce boilerplate code (Getters, Setters, etc.)  
- **Validation** → Request validation using `jakarta.validation`  
- **JWT (JJWT)** → JSON Web Token library (`api`, `impl`, `jackson`)  
- **Spring Boot Starter Test + Security Test** → For unit & integration testing  

---

## 🗄️ PostgreSQL Setup

Run these commands in `psql`:

  -- Create database
  CREATE DATABASE springboot_auth;
  
  -- Create user
  CREATE USER demo_user WITH ENCRYPTED PASSWORD 'demo_pass';
  
  -- Grant privileges
  GRANT ALL PRIVILEGES ON DATABASE springboot_auth TO demo_user;
  
  -- Create schema
  \c springboot_auth
  CREATE SCHEMA IF NOT EXISTS springboot_schema AUTHORIZATION demo_user;

🛠️ Configuration

src/main/resources/application.properties:


spring.application.name=System

# PostgreSQL Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/springboot_demo
spring.datasource.username=demo_user
spring.datasource.password=demo_pass
spring.datasource.driver-class-name=org.postgresql.Driver

# Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.default_schema=springboot_schema


# Generate the JWT toker
security.jwt.secret-key=3cfa76ef14937c1c0ea519f8fc057a80fcd04a7420f8e8bcd0a7567c272e007b
# 1h in millisecond
security.jwt.expiration-time=3600000


🚀 How to Run
Clone repo
git clone https://github.com/your-username/springboot-authentication.git
cd springboot-authentication

Run with Maven
./mvnw spring-boot:run


or with Gradle:

./gradlew bootRun

📌 Branch Strategy (Step by Step)

To make this project beginner-friendly, each branch represents a step in the authentication system:

01-basic-setup → Spring Boot + PostgreSQL connection

02-entity-repository → Employee entity + repository

03-security-config → Spring Security config

04-jwt-implementation → JWT utilities + filters

05-register-login → User registration & login endpoints

06-final → Completed authentication system


🧪 API Testing

Use Postman (collection included in /postman folder).

Example endpoints:

Register User
POST http://localhost:8080/api/auth/login
{
  "email": "mouad.elbaz@example.com",
  "password": "password123"
}

📚 Resources

Spring Security Documentation

JWT.io Debugger

Original Medium Article

🤝 Contribution

Fork & clone the repo

Create a new branch (feature/xyz)

Submit a Pull Request 🚀

📬 Feedback


I’d love your feedback & suggestions for improvement! 🙌
