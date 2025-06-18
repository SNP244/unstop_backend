# AuthDemo - Basic Authentication Backend

This is a Spring Boot-based backend application that implements secure user registration and login functionality with JWT-based authentication and input validation.

---

## Problem Statement

Design and implement a basic backend system that allows users to register and log in using their credentials.

---

## Features

- User Registration (Full Name, Email, Password)
- Password Hashing using BCrypt
- Input Validation with informative error handling
- User Login with email/password verification
- JWT Token Generation on successful login
- JWT Token Validation on secured endpoints
- Stateless authentication (no session used)
- REST APIs tested via Postman

---

## Tech Stack

| Layer     | Technology              |
|-----------|-------------------------|
| Language  | Java 17+                |
| Framework | Spring Boot             |
| Security  | Spring Security, JWT    |
| Validation| Jakarta Bean Validation |
| Database  | H2 (in-memory)          |
| Build     | Maven                   |

---

## Project Structure

unstop_backend/
├── pom.xml
├── README.md
├── src/
│ └── main/
│ └── java/
│ └── com/
│ └── shreyapatil/
│ └── authdemo/
│ ├── controller/
│ ├── model/
│ ├── repository/
│ ├── security/
│ ├── service/
│ └── util/



---

## Sample API Endpoints

| Method | Endpoint             | Description               | Auth Required |
|--------|----------------------|---------------------------|---------------|
| POST   | /api/auth/register   | Register new user         | No            |
| POST   | /api/auth/login      | Login and get JWT token   | No            |
| GET    | /api/test/hello      | Sample protected endpoint | Yes           |

---

## Sample Test Credentials

Use the following payload to register a user in Postman:

```json
{
  "fullName": "Shreya Patil",
  "email": "shreyaa@example.com",
  "password": "secret123"
}
Then log in with the same credentials to receive a JWT token.

Authorization Header
Use the received token in secured requests like this:

Authorization: Bearer <your_token_here>

Setup Instructions
Clone the Repository

git clone https://github.com/yourusername/unstop_backend.git
cd unstop_backend
Build and Run the Project

./mvnw spring-boot:run
The application will start at:

http://localhost:8080

Bonus Implemented
JWT Authentication (stateless)

Global validation error handling using @ControllerAdvice

License
This project was developed as part of the Unstop Hackathon: Backend Developer Intern Challenge — Eliminator Round.



---









