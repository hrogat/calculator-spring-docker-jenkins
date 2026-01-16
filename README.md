# Calculator Project

This project is a simple calculator API built using Spring Boot 3.2. It provides basic arithmetic operations such as addition, subtraction, multiplication, and division.

## Features

- **Addition**: Add two integers using the `/api/calculate/add/{a}/{b}` endpoint.
- **Subtraction**: Subtract two integers using the `/api/calculate/subtract/{a}/{b}` endpoint.
- **Multiplication**: Multiply two integers using the `/api/calculate/multiply/{a}/{b}` endpoint.
- **Division**: Divide two integers using the `/api/calculate/divide/{a}/{b}` endpoint.

## API Endpoints

- **GET** `/api/calculate/add/{a}/{b}`: Returns the sum of `a` and `b`.
- **GET** `/api/calculate/subtract/{a}/{b}`: Returns the result of `a - b`.
- **GET** `/api/calculate/multiply/{a}/{b}`: Returns the product of `a` and `b`.
- **GET** `/api/calculate/divide/{a}/{b}`: Returns the result of `a / b`.

## Error Handling

- **Division by Zero**: Returns a `500 Internal Server Error` with the message "Division by zero is not allowed."

## Logging

- Logging is configured to provide detailed information for debugging and monitoring purposes.
- Logs are written at the `DEBUG` level for the `com.tomwey2.calculator` package.

## Testing

- Unit tests are provided for the service layer (`CalculatorServiceTest`).
- Integration tests are provided for the controller layer (`CalculatorControllerTest`).

## Configuration

- The server runs on port `8080` by default.
- Logging levels can be adjusted in the `application.properties` file.

## How to Run

1. Clone the repository.
2. Navigate to the project directory.
3. Run the application using `mvn spring-boot:run`.
4. Access the API endpoints using a tool like Postman or cURL.

## Example Requests

- **Addition**: `GET http://localhost:8080/api/calculate/add/2/3`
- **Subtraction**: `GET http://localhost:8080/api/calculate/subtract/5/3`
- **Multiplication**: `GET http://localhost:8080/api/calculate/multiply/2/3`
- **Division**: `GET http://localhost:8080/api/calculate/divide/6/3`

## License

This project is licensed under the MIT License.