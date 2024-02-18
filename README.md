# Simple CRUD Service with In-Memory H2 Database

This project is a simple CRUD (Create, Read, Update, Delete) service implemented in Java using the Spring Boot framework. The application uses an in-memory H2 database for data storage.

Getting Started
To run the application locally, follow these steps:

 # 1. Clone the Repository:

git clone https://github.com/your-username/your-repository.git
cd your-repository

# 2. Build the Project:

./mvnw clean install

# 3. Run the Application:

./mvnw spring-boot:run
The application will start at http://localhost:8080.

# 4. Access the H2 Console:

H2 Console URL: http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:testdb
Username: sa
Password: (leave it blank)
You can use the H2 Console to inspect the in-memory database.

# Endpoints
The Endpoints can be accessed via swagger:
http://localhost:8080/swagger-ui/index.html

# Technologies Used
Java
Spring Boot
H2 Database
Maven

