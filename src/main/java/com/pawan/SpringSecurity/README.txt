                            🛡️ Spring Security + JWT + PostgreSQL Example

This project is a demonstration of securing REST APIs using Spring Boot, Spring Security,JWT (JSON Web Tokens), and PostgreSQL. It follows a stateless session architecture and includes
endpoints for user registration, login, and secured student-related actions.

🔐 Authentication Flow

Register via /register
Login via /login to receive a JWT token
Access protected endpoints with the token (e.g., /students, /student)

📁 Database Configuration
Database: PostgreSQL
Connection managed via Spring Data JPA
Ensure PostgreSQL is running and connection details are set in application.properties:
spring.datasource.url=jdbc:postgresql://localhost:5432/springsecurity
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.hibernate.ddl-auto=update

🔧 Endpoints & Usage
✅ Register a New User
POST /register
{
  "username": "pawan",
  "password": "123456"
}

🔐 Login to Get JWT Token
POST /login
{
  "username": "pawan",
  "password": "123456"
}

📥 Save a Student
POST /student (Requires JWT)
Headers:
Authorization: Bearer <JWT_TOKEN>
Body:
{
  "id": 1,
  "name": "Pawan",
  "marks": 98
}

📤 Get All Students
GET /students (Requires JWT)
Headers:
Authorization: Bearer <JWT_TOKEN>

⚠️ Optional: Get CSRF Token (Only if CSRF is enabled)
GET /csrf-token
Response:
{
  "token": "abc123..."
}

📆 Get Session ID
GET /session-id
This returns the current session ID. However, if the session policy is stateless, so session ID will
change for every request.

                            NOTE-> Student’s have been hardcoded!!

