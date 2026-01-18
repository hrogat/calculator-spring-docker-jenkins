# Calculator Spring Boot Application

A simple calculator REST API built with Spring Boot 3.2 and Java 21. The application provides basic arithmetic operations through a clean, well-documented API.

## Technologies
- **Spring Boot 3.2**: Modern Java framework
- **Java 21**: Latest LTS version
- **Lombok**: Reduces boilerplate code
- **SpringDoc OpenAPI**: API documentation
- **SLF4J**: Logging framework
- **JUnit 5 & Mockito**: Testing framework

## Features
- **Addition**: Add two integers
- **Subtraction**: Subtract two integers  
- **Multiplication**: Multiply two integers
- **Division**: Divide two integers (with zero division protection)
- **Input Validation**: Validates all request parameters
- **Error Handling**: Comprehensive exception handling
- **API Documentation**: Swagger/OpenAPI documentation
- **Logging**: Detailed request/response logging

## Project Structure
```
.
├── src
│   ├── main
│   │   ├── java/com/tomwey2/calculator
│   │   │   ├── CalculatorApplication.java      # Spring Boot main class
│   │   │   ├── CalculatorController.java       # REST controller
│   │   │   ├── CalculatorService.java          # Business logic
│   │   │   ├── dto
│   │   │   │   ├── CalculationRequest.java      # Request DTO
│   │   │   │   └── CalculationResponse.java    # Response DTO
│   │   │   └── exception
│   │   │       └── CalculatorExceptionHandler.java # Global exception handler
│   │   └── resources
│   │       ├── application.properties          # Configuration
│   │       └── application-test.properties     # Test configuration
│   └── test
│       └── java/com/tomwey2/calculator
│           ├── CalculatorApplicationTests.java  # Context tests
│           ├── CalculatorServiceTest.java      # Service layer tests
│           └── CalculatorControllerTest.java   # Controller tests
├── pom.xml                                   # Maven configuration
└── README.md                                 # Project documentation
```

## API Endpoints

### POST /api/calculator/sum
Adds two integers

**Request Body:**
```json
{
  "a": 5,
  "b": 3
}
```

**Response:**
```json
{
  "result": 8
}
```

### POST /api/calculator/subtract
Subtracts two integers

**Request Body:**
```json
{
  "a": 5,
  "b": 3
}
```

**Response:**
```json
{
  "result": 2
}
```

### POST /api/calculator/multiply
Multiplies two integers

**Request Body:**
```json
{
  "a": 5,
  "b": 3
}
```

**Response:**
```json
{
  "result": 15
}
```

### POST /api/calculator/divide
Divides two integers

**Request Body:**
```json
{
  "a": 6,
  "b": 3
}
```

**Response:**
```json
{
  "result": 2
}
```

## Error Handling

The API returns appropriate HTTP status codes and error messages:

- **400 Bad Request**: Invalid input, missing parameters, or mathematical errors (overflow, division by zero)
- **500 Internal Server Error**: Unexpected server errors

## Installation and Execution

### Prerequisites
- Java 21
- Maven 3.8+

### Local Execution

1. Clone the repository:
   ```bash
   git clone https://github.com/tomwey2/calculator-spring-docker-jenkins.git
   ```

2. Navigate to the project directory:
   ```bash
   cd calculator-spring-docker-jenkins
   ```

3. Build the application:
   ```bash
   mvn clean install
   ```

4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

The application will be available at `http://localhost:8080`

### API Documentation

Access the Swagger UI documentation at:
- `http://localhost:8080/swagger-ui.html`

### Running Tests

Execute the test suite:
```bash
mvn test
```

## Testing Strategy

The project includes comprehensive tests:

- **Unit Tests**: Test individual service methods with various inputs
- **Integration Tests**: Test controller endpoints with mock services
- **Edge Case Testing**: Test overflow conditions, division by zero, null inputs
- **Validation Testing**: Test input validation and error responses

## Best Practices Implemented

1. **Clean Architecture**: Separation of concerns with Controller -> Service layers
2. **DTO Pattern**: Clear separation between API layer and business logic
3. **Input Validation**: Using Jakarta Validation annotations
4. **Exception Handling**: Global exception handler with appropriate HTTP status codes
5. **Logging**: Detailed request/response logging using SLF4J
6. **API Documentation**: Comprehensive Swagger/OpenAPI documentation
7. **Test Coverage**: Comprehensive unit and integration tests
8. **Error Handling**: Proper handling of mathematical errors (overflow, division by zero)

## Future Enhancements

- Add support for floating-point operations
- Implement operation history/logging
- Add user authentication for rate limiting
- Implement caching for frequent calculations
- Add more complex mathematical operations