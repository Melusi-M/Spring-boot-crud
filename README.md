# Simple CRUD Service with In-Memory H2 Database

This project is a simple CRUD (Create, Read, Update, Delete) service implemented in Java using the Spring Boot framework. The application uses an in-memory H2 database for data storage.

Getting Started
To run the application locally, follow these steps:

Clone the Repository:

bash
Copy code
git clone https://github.com/your-username/your-repository.git
cd your-repository
Build the Project:

bash
Copy code
./mvnw clean install
Run the Application:

bash
Copy code
./mvnw spring-boot:run
The application will start at http://localhost:8080.

Access the H2 Console:

H2 Console URL: http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:testdb
Username: sa
Password: (leave it blank)
You can use the H2 Console to inspect the in-memory database.

Endpoints
The following CRUD operations are supported:

Create Guest:

bash
Copy code
POST /guests
Body: {"name": "John", "surname": "Doe", "emailAddress": "john.doe@example.com", "country": "USA", "booked": false}
Get All Guests:

bash
Copy code
GET /guests
Get Guest by ID:

bash
Copy code
GET /guests/{id}
Update Guest:

bash
Copy code
PUT /guests/{id}
Body: {"name": "UpdatedName", "surname": "UpdatedSurname", "emailAddress": "updated.email@example.com", "country": "UpdatedCountry", "booked": true}
Delete Guest:

bash
Copy code
DELETE /guests/{id}
Get Guests by Country:

bash
Copy code
GET /guests/byCountry?country=USA
Get Booked Guests:

bash
Copy code
GET /guests/booked
Technologies Used
Java
Spring Boot
H2 Database
Maven
