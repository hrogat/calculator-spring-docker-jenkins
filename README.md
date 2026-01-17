# Calculator API

This is a simple RESTful API for performing arithmetic operations. The API is built using Spring Boot 3.2 and Java 21.

## Features
- Sum two integers
- Proper error handling for overflow and invalid inputs
- Logging for debugging and monitoring

## Endpoints

### Sum Two Integers
**POST** `/api/calculator/sum`

**Request Body:**
```json
{
  "a": 2,
  "b": 3
}
```

**Response:**
```json
{
  "result": 5
}
```

**Error Responses:**
- **400 Bad Request** if inputs are null or invalid
- **400 Bad Request** if the sum exceeds integer limits

## Error Handling
- **InvalidInputException**: Thrown when inputs are null or invalid.
- **OverflowException**: Thrown when the sum exceeds integer limits.

## Testing
The project includes unit tests for:
- Valid inputs
- Null inputs
- Overflow scenarios
- Edge cases (zero, negative numbers, max/min integer values)

## Running the Application
1. Clone the repository.
2. Build the project using Maven:
   ```sh
   mvn clean install
   ```
3. Run the application:
   ```sh
   mvn spring-boot:run
   ```
4. Access the API at `http://localhost:8080/api/calculator/sum`.

## Dependencies
- Java 21
- Spring Boot 3.2
- Lombok
- JUnit 5
- Mockito
