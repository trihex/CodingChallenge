# CodingChallenge

This is a multi-module Maven project that contains an Angular 2 frontend and Spring Boot backend.

The project is configured so that Spring Boot will host and run the Angular 2 frontend as well as the Spring RESTful services in the backend.

To run the application:

1. From the main directory run mvn clean install.
2. CD to the backend directory
3. Run mvn spring-boot:run
4. Open http://localhost:8080 in your browser

The Angular 2 front end allows you to add a new user, displays a list of all added users, and allows you to remove existing users.

Users are stored in an H2 database which will be persisted on the local machine at ~\challenge.mv.db so added users should persist across application restarts.

The backend expsoes the following RESTful endpoints:

Add a User:
POST http://localhost:8080/user
Body User object in JSON format
Header Accept application/json

Get All Users:
GET http://localhost:8080/user
Header Accept application/json

Get Specific User:
GET http://localhost:8080/{id}
Header Accept application/json

Update a User record:
PUT http://localhost:8080/{id}
Body User object in JSON format
Header Accept application/json

Delete a User record:
DELETE http://localhost:8080/{id}


