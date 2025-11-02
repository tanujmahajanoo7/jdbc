# JDBC Tutorial Project

This repository contains Java Database Connectivity (JDBC) programs demonstrating various JDBC concepts and operations.

## Project Structure

- `JDBC/` - Main package containing 8 programs demonstrating JDBC concepts
  - `FirstProgram.java` through `EighthProgram.java` - Various JDBC operations
- `disadvantages/` - Examples demonstrating certain approaches and their limitations
  - `Student.java` - Student entity class
  - `StudentPersist.java` - Student persistence example

## JDBC Steps (6-Step Process)

1. **Load the Driver**
2. **Establish Connection**
3. **Create the Statement Medium**
4. **Execute Query**
5. **Display the Result**
6. **Close the Resources**

## Prerequisites

### Adding MySQL JAR File in Eclipse

1. Right-click on your project
2. Go to **Build Path**
3. Click **Configure Build Path**
4. Select **Libraries** tab
5. Expand **Classpath**
6. Click **Add External JARs**
7. Browse and select your MySQL JDBC driver JAR file (e.g., `mysql-connector-java-8.0.x.jar`)
8. Click **Apply and Close**

### Database Setup

- MySQL Server should be installed and running
- Create a database named `june` (or modify the connection string in the code)
- Ensure the database contains the required tables (`batches`, `student`, etc.)
- Update connection credentials in the code:
  - Host: `localhost`
  - Port: `3306`
  - Database: `june`
  - Username: `root`
  - Password: `Tanuj@123` (change as per your setup)

## Running the Programs

1. Ensure MySQL database is running
2. Create the required database and tables
3. Update database credentials in the Java files
4. Run the desired program from the `JDBC` package

## Notes

- All programs demonstrate basic JDBC operations
- Connection strings use MySQL Connector/J driver
- Remember to close all database resources to avoid connection leaks
