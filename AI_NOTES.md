# AI Usage Notes

## Summary

AI tools were used during the development of the **Smart Expense Tracker API** as a development assistant for architecture discussion, implementation guidance, debugging support, documentation improvement, and code review.

AI suggestions were not blindly accepted. All generated suggestions were reviewed, modified where required, tested locally, and integrated only after understanding their purpose and impact.

---

# 1. Areas Where AI Assisted

## Project Structure and Design

AI helped in planning a clean Spring Boot layered architecture:

- **Controller layer** for handling REST API requests
- **Service layer** for business logic
- **Model layer** for representing expense data
- **DTO layer** for request validation and separation of API input
- **Exception package** for centralized error handling

The final project structure was reviewed and adjusted according to the assignment requirements.

---

## REST API Implementation

AI provided suggestions related to:

- Designing REST endpoints
- Handling request and response objects
- Selecting appropriate HTTP status codes
- Improving Swagger/OpenAPI documentation

Implemented API functionality:

- Create expense
- Retrieve all expenses
- Filter expenses by category
- Calculate total expenses
- Calculate total expenses by category
- Delete expenses

---

## Validation and Exception Handling

AI suggested improvements for:

- Using Jakarta Bean Validation
- Implementing global exception handling
- Creating consistent API error responses

The final implementation was manually reviewed and modified to return structured validation errors containing:

- Timestamp
- HTTP status
- Error message
- Request path
- Validation details

---

## Testing

AI assisted with initial test case design using:

- JUnit 5
- Mockito
- Spring MockMvc

The generated suggestions were manually verified and updated to match the actual application behaviour.

Implemented test coverage includes:

- Creating expenses
- Fetching all expenses
- Filtering expenses by category
- Calculating totals
- Deleting expenses
- Validation error handling

---

## Documentation

AI assisted in improving:

- README.md structure
- API documentation format
- Swagger/OpenAPI descriptions

The final documentation was reviewed to ensure that:

- Installation commands are correct
- API examples match implementation
- Project structure is accurately represented

---

# 2. Validation and Changes Made After AI Suggestions

All AI-assisted output was reviewed before being included in the project.

## API Testing

The following endpoints were manually tested:

```
POST    /expenses
GET     /expenses
GET     /expenses?category={category}
GET     /expenses/total
GET     /expenses/total?category={category}
DELETE  /expenses/{id}
```

Validation scenarios were also tested to confirm proper error responses.

---

## Build and Test Verification

The project was verified using:

```powershell
.\mvnw.cmd clean test
```

Compilation issues and test failures were debugged and fixed by aligning implementation and test cases.

---

## Code Review

The following areas were manually reviewed:

- Request validation behaviour
- HTTP response status codes
- Exception response structure
- Swagger documentation
- Test coverage
- API behaviour

---

# 3. AI Suggestions Not Implemented

Some AI suggestions were intentionally not implemented because they were outside the assignment requirements or introduced unnecessary complexity.

---

## Database Integration

Suggested improvement:

- PostgreSQL database integration

Decision:

**Not implemented**

Reason:

The assignment explicitly allowed in-memory storage. Adding database configuration would increase setup complexity without providing additional value for the required evaluation criteria.

---

## Authentication and Authorization

Suggested improvement:

- User authentication and authorization

Decision:

**Not implemented**

Reason:

The assignment focuses on expense management functionality. Authentication was considered outside the current scope.

---

## Additional Custom Exceptions

Suggested improvement:

- Custom exceptions such as `ExpenseNotFoundException`
- Additional exception handlers

Decision:

**Not implemented currently**

Reason:

The required error handling functionality was already covered using global exception handling. Additional exceptions were considered future improvements.

---

# 4. Personal Contribution

The following parts were implemented, reviewed, and understood personally:

- Spring Boot project setup
- REST controller development
- Service layer implementation
- Expense model and DTO creation
- Validation configuration
- Exception handling implementation
- API testing
- Debugging build and test issues
- Reviewing and modifying AI-assisted suggestions

AI was used as a development assistant, while all final implementation decisions, testing, and verification were performed manually.

---

# 5. Key Learning Outcomes

Through this project, I gained practical experience with:

- Designing REST APIs using Spring Boot
- Applying layered architecture principles
- Implementing request validation
- Handling API errors globally
- Writing automated tests using JUnit and Mockito
- Documenting APIs using Swagger/OpenAPI
- Effectively using AI tools while maintaining code understanding
