# Smart Expense Tracker API

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)
![Maven](https://img.shields.io/badge/Maven-Build-blue)
![Swagger](https://img.shields.io/badge/API-Swagger%20OpenAPI-green)

A RESTful API built using **Java Spring Boot** for managing personal expenses.

This application allows users to create expenses, retrieve expenses, filter expenses by category, calculate total spending, and delete expenses.

Developed as part of the **Software Engineering Apprenticeship Program 2026 take-home assignment**.

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

| Technology | Usage |
|---|---|
| Java 17 | Programming Language |
| Spring Boot 3 | Backend Framework |
| Spring Web | REST API Development |
| Jakarta Validation | Request Validation |
| Maven | Dependency Management |
| JUnit 5 | Testing |
| Mockito | Mocking |
| Swagger OpenAPI 3 | API Documentation |

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
git clone <repository-url>
```

Navigate into the project:

```bash
cd expense-tracker-api
```

---

# Running the Application

## Windows

```powershell
.\mvnw.cmd spring-boot:run
```

## Linux / macOS

```bash
./mvnw spring-boot:run
```

Application runs on:

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

Tests cover:

- Creating expenses
- Fetching all expenses
- Filtering expenses by category
- Calculating total expenses
- Calculating category-wise totals
- Deleting expenses
- Validation error handling

---

# API Documentation

Swagger UI:

```
http://localhost:8080/swagger-ui/index.html
```

OpenAPI JSON:

```
http://localhost:8080/v3/api-docs
```

---

# API Endpoints

## Create Expense

### POST

```
/expenses
```

### Request

```json
{
  "title": "Pizza",
  "amount": 350,
  "category": "Food",
  "date": "2026-08-01"
}
```

### Response

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

Response:

```
204 No Content
```

---

# Error Handling

The API returns structured error responses for invalid requests.

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

# Data Storage

The application uses **in-memory storage** as allowed by the assignment requirements.

No external database configuration is required.

---

# Design Decisions

- Used layered architecture:
  - Controller layer handles HTTP requests
  - Service layer contains business logic
  - Model layer represents expense data

- Added DTO (`CreateExpenseRequest`) to separate API input from internal models.

- Added global exception handling to provide consistent error responses.

- Added Swagger documentation for easier API testing.

- Added automated tests to verify API behaviour.

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
