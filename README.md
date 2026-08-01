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

Smart Expense Tracker API demonstrates backend development practices using Spring Boot:

- RESTful API design
- Layered architecture
- DTO-based request handling
- Input validation
- Global exception handling
- Automated API testing
- OpenAPI documentation

The application currently uses **in-memory storage** as allowed by the assignment requirements.

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
git clone Ishika-45/expense-tracker-api
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
- Filtering expenses
- Calculating total expenses
- Category-wise calculations
- Deleting expenses
- Validation handling

---

# Test Verification

Latest local verification:

```text
.\mvnw.cmd clean test

BUILD SUCCESS
```

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

## Filter By Category

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

## Get Category Total

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

---

# Design Decisions

## Layered Architecture

The application follows a layered structure:

- **Controller Layer**
  - Handles HTTP requests and responses

- **Service Layer**
  - Contains business logic

- **Model Layer**
  - Represents expense entities

- **DTO Layer**
  - Separates API requests from internal models

---

## Additional Decisions

- Used in-memory storage because database setup was not required.
- Added DTO validation to prevent invalid expense data.
- Added global exception handling for consistent error responses.
- Added Swagger documentation for easier API exploration.
- Added automated tests to verify functionality.

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
