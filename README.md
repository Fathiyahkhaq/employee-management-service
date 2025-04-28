# Employee Management Application

This is a simple Employee Management application built with **Spring Boot 3.4.5** and **Java 21**. The application is designed to manage employee data with CRUD operations. The project uses **Flyway** for database migrations, and the backend is connected to a MySQL database.

## Prerequisites

Before running the application, please ensure you have the following tools installed:

- **Java 21** (JDK 21)
- **Maven 3.x** or later
- **Docker** and **Docker Compose**

### Required Docker Image

This application requires a MySQL database, which is provided through Docker Compose. The `docker-compose.yml` file will set up the MySQL container required for the application to run.

## Setup

### 1. **Start MySQL Docker Container**

Before running the Spring Boot application, you need to run the MySQL database container with Docker Compose.

Navigate to the root folder of this project, and run the following command:

```bash
docker-compose up -d
```

This will pull the MySQL image, start the container, and make the database accessible to the application.

- MySQL container will run on port 3306.

- The MySQL configuration is already set in the application.yml file.

Make sure Docker Compose is running and the MySQL container is up before proceeding to the next step.

### 1. **Build The Application**

Once the MySQL container is running, you can build and run the Spring Boot application.

To build the application and install the dependencies, run the following command:

```bash
mvn clean install
```

This command will:

- Download all dependencies (including Flyway and MySQL connectors)

- Run Flyway migrations to set up the database schema

### 1. **Run The Application**
After successfully building the application, you can run it using:
```bash
mvn spring-boot:run
```
This will start the application on the default port 8080.

### 4. **Access the API**
Once the application is running, you can interact with the following endpoints:

- Create Employee: POST /employees
- Get All Employees: GET /employees 
- Get Employee by ID: GET /employees/{id} 
- Update Employee by ID: PUT /employees/{id} 
- Delete Employee by ID: DELETE /employees/{id}

### 5. **Stop the Docker Compose**

After you're done, you can stop the Docker container with the following command:
```bash
docker compose down
```
This will stop and remove the MySQL container.

## Application Configuration
- Database: MySQL 
- Flyway: Database migrations are managed by Flyway. The SQL migration files are located in src/main/resources/db/migration/. 
- Spring Boot: The application is built with Spring Boot 3.4.5 and Java 21.

## Dependencies
- Spring Boot 3.4.5: Web and JPA 
- Flyway: Database migrations 
- MySQL: Database connector 
- Lombok: Simplify Java code with annotations 
- Docker Compose: Set up MySQL container