# Smart Expense Tracker API

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)
![Maven](https://img.shields.io/badge/Maven-Build-blue)
![Swagger](https://img.shields.io/badge/API-Swagger%20OpenAPI-green)
![Testing](https://img.shields.io/badge/Tests-JUnit%205%20%7C%20Mockito-purple)

A RESTful API built using **Java Spring Boot** for managing personal expenses.

The application provides APIs to create, retrieve, filter, calculate, and delete expenses while following a clean layered architecture with validation, exception handling, API documentation, and automated testing.

Developed as part of the **Software Engineering Apprenticeship Program 2026 take-home assignment**.

---

# About The Project

Smart Expense Tracker API demonstrates practical backend engineering practices using Spring Boot, focusing on:

- REST API development
- Clean layered architecture
- DTO-based request handling
- Input validation
- Global exception handling
- Automated testing
- OpenAPI documentation

The application uses **in-memory storage** as allowed by the assignment requirements.

---

# Features

✅ Create a new expense  
✅ View all expenses  
✅ Filter expenses by category  
✅ Calculate total expenses  
✅ Calculate total expenses by category  
✅ Delete expenses  
✅ Request validation  
✅ Global exception handling  
✅ Swagger/OpenAPI documentation  
✅ Unit testing using JUnit 5 and Mockito  

---

# Tech Stack

| Technology | Purpose |
|---|---|
| Java 17 | Programming Language |
| Spring Boot 3 | Backend Framework |
| Spring Web | REST API Development |
| Jakarta Validation | Request Validation |
| Maven | Build & Dependency Management |
| JUnit 5 | Testing Framework |
| Mockito | Mocking Framework |
| Swagger/OpenAPI 3 | API Documentation |

---

# Prerequisites

Before running the application, make sure you have:

- Java 17 or higher
- Maven (or Maven Wrapper included in the project)

Verify Java installation:

```bash
java -version
```

---

# Project Structure

```
expense-tracker-api
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.ishika.expensetracker
│   │   │       ├── controller
│   │   │       ├── service
│   │   │       ├── model
│   │   │       ├── dto
│   │   │       ├── exception
│   │   │       └── config
│   │   │
│   │   └── resources
│   │
│   └── test
│       └── java
│           └── com.ishika.expensetracker
│               ├── controller
│               └── exception
│
├── pom.xml
├── README.md
└── AI_NOTES.md
```

---

# Installation

## Clone Repository

```bash
git clone https://github.com/Ishika-45/expense-tracker-api.git
```

Navigate into the project:

```bash
cd expense-tracker-api
```

---

# Running The Application

## Windows

```powershell
.\mvnw.cmd spring-boot:run
```

## Linux / macOS

```bash
./mvnw spring-boot:run
```

Application starts at:

```
http://localhost:8080
```

---

# Running Tests

## Windows

```powershell
.\mvnw.cmd clean test
```

## Linux / macOS

```bash
./mvnw clean test
```

Test coverage includes:

- Creating expenses
- Fetching all expenses
- Filtering expenses by category
- Calculating total expenses
- Category-wise calculations
- Deleting expenses
- Validation error handling

---

# API Documentation

Swagger UI:

```
http://localhost:8080/swagger-ui/index.html
```

OpenAPI specification:

```
http://localhost:8080/v3/api-docs
```

Swagger documentation was added as the optional bonus feature from the assignment.

---

# API Overview

| Method | Endpoint | Description |
|---|---|---|
| POST | `/expenses` | Create a new expense |
| GET | `/expenses` | Retrieve all expenses |
| GET | `/expenses?category={category}` | Filter expenses by category |
| GET | `/expenses/total` | Calculate total expenses |
| GET | `/expenses/total?category={category}` | Calculate category total |
| DELETE | `/expenses/{id}` | Delete an expense |

---

# API Examples

## Create Expense

### POST

```
/expenses
```

Request:

```json
{
  "title": "Pizza",
  "amount": 350,
  "category": "Food",
  "date": "2026-08-01"
}
```

Response:

```json
{
  "id": "uuid",
  "title": "Pizza",
  "amount": 350,
  "category": "Food",
  "date": "2026-08-01"
}
```

---

## Get All Expenses

### GET

```
/expenses
```

Returns all stored expenses.

---

## Filter Expenses By Category

### GET

```
/expenses?category=Food
```

Example:

```
/expenses?category=Travel
```

---

## Get Total Expenses

### GET

```
/expenses/total
```

Example response:

```json
1050
```

---

## Get Total Expenses By Category

### GET

```
/expenses/total?category=Food
```

Example response:

```json
550
```

---

## Delete Expense

### DELETE

```
/expenses/{id}
```

Example:

```
/expenses/550e8400-e29b-41d4-a716-446655440000
```

Successful response:

```
204 No Content
```

---

# Error Handling

The API provides structured error responses for invalid requests.

Example:

```json
{
  "timestamp": "2026-08-02T10:30:00",
  "status": 400,
  "message": "Validation failed",
  "path": "/expenses",
  "errors": {
    "title": "Title is required"
  }
}
```

Validation errors occur when:

- Expense title is empty
- Category is missing
- Amount is invalid
- Date is missing

---

# Design Decisions

## Layered Architecture

The application follows a layered structure:

### Controller Layer

Handles HTTP requests and responses.

### Service Layer

Contains business logic and expense operations.

### Model Layer

Represents expense data.

### DTO Layer

Separates API request objects from internal models.

---

## Additional Decisions

- Used in-memory storage because database setup was not required by the assignment.
- Added DTO validation to prevent invalid expense data.
- Added global exception handling for consistent error responses.
- Added Swagger documentation for easier API exploration.
- Added automated tests to verify functionality.

---

# Project Status

Completed assignment implementation.

Implemented:

- Core expense management APIs
- Request validation
- Exception handling
- Swagger/OpenAPI documentation
- Automated tests

---

# Future Improvements

Possible enhancements:

- PostgreSQL database integration
- User authentication and authorization
- Expense search functionality
- Monthly expense reports
- Docker support

---

# Author

**Ishika Bansal**

Software Engineering Apprenticeship Assignment 2026
