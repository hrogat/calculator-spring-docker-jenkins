# Calculator Project

This project is a simple calculator API built using Spring Boot. It provides endpoints for basic arithmetic operations like sum, subtract, and multiply.

## Features
- **Sum**: Add two integers.
- **Subtract**: Subtract two integers.
- **Multiply**: Multiply two integers.

## API Endpoints

### Sum
- **Endpoint**: `POST /sum`
- **Request Body**:
  ```json
  {
    "a": 5,
    "b": 3
  }
  ```
- **Response**:
  ```json
  {
    "result": 8
  }
  ```

### Subtract
- **Endpoint**: `POST /subtract`
- **Request Body**:
  ```json
  {
    "a": 5,
    "b": 3
  }
  ```
- **Response**:
  ```json
  {
    "result": 2
  }
  ```

### Multiply
- **Endpoint**: `POST /multiply`
- **Request Body**:
  ```json
  {
    "a": 5,
    "b": 3
  }
  ```
- **Response**:
  ```json
  {
    "result": 15
  }
  ```

## Error Handling
- **Invalid Input**: Returns a `400 Bad Request` if the input is invalid (e.g., both values are `Integer.MIN_VALUE`).
- **Overflow**: Returns a `400 Bad Request` if an overflow occurs during calculation.

## Testing
The project includes unit tests and integration tests to ensure the correctness of the calculator operations. Run the tests using:
```bash
mvn test
```

## Swagger Documentation
The API is documented using Swagger. You can access the Swagger UI at:
```
http://localhost:8080/swagger-ui.html
```

## How to Run
1. Clone the repository.
2. Navigate to the project directory.
3. Run the application:
   ```bash
   mvn spring-boot:run
   ```
4. Access the API endpoints as described above.

## Dependencies
- Java 21
- Spring Boot 3.2
- Lombok
- Springdoc OpenAPI (for Swagger)

## License
This project is licensed under the MIT License.