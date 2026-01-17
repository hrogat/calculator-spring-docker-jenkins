# Calculator Project

This project is a simple calculator API built with Spring Boot. It provides endpoints for performing basic arithmetic operations.

## Features
- Sum two integers
- Subtract two integers
- Multiply two integers

## API Endpoints

### Sum
- **Endpoint**: `/sum`
- **Method**: POST
- **Request Body**:
  ```json
  {
    "a": 2,
    "b": 3
  }
  ```
- **Response Body**:
  ```json
  {
    "result": 5
  }
  ```

### Subtract
- **Endpoint**: `/subtract`
- **Method**: POST
- **Request Body**:
  ```json
  {
    "a": 3,
    "b": 2
  }
  ```
- **Response Body**:
  ```json
  {
    "result": 1
  }
  ```

### Multiply
- **Endpoint**: `/multiply`
- **Method**: POST
- **Request Body**:
  ```json
  {
    "a": 2,
    "b": 3
  }
  ```
- **Response Body**:
  ```json
  {
    "result": 6
  }
  ```

## Running the Project

To run the project, use the following command:

```bash
mvn spring-boot:run
```

## Testing

To run the tests, use the following command:

```bash
mvn test
```

## Swagger Documentation

Swagger documentation is available at:

```bash
http://localhost:8080/swagger-ui.html
```

## License

This project is licensed under the MIT License.