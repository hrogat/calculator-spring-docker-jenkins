# Calculator Spring Boot Application with Docker and Jenkins

A simple calculator application built with Spring Boot, exposed as a REST API. The project is containerized using Docker and includes a Jenkins CI/CD pipeline for automated builds and deployments.

---

## Technologies
This project leverages the following technologies:
- **Spring Boot**: Enables rapid development with auto-configuration, an embedded server (Tomcat), and a robust ecosystem for building RESTful APIs.
- **Maven**: Manages dependencies and automates the build process.
- **Docker**: Ensures consistent deployment across environments by containerizing the application.
- **Jenkins**: Automates testing and deployment via a CI/CD pipeline.
- **JUnit 5**: Provides a framework for writing and executing unit tests.
- **JaCoCo**: Measures code coverage to ensure test effectiveness.
- **Checkstyle**: Enforces coding standards and best practices.

---

## Architecture Overview
This application follows a **Layered Architecture** with the following components:
- **Controller Layer**: Handles HTTP requests and responses (e.g., `CalculatorController`).
- **Service Layer**: Contains business logic (e.g., `CalculatorService`).
- **No Repository Layer**: There is no database interaction in the current implementation.

The architecture adheres to the **Spring Boot MVC** pattern, ensuring separation of concerns and maintainability.

---

## Component Interaction
The `CalculatorController` receives HTTP requests and delegates the calculation logic to the `CalculatorService`. The result is returned as a plain text response. **Dependency Injection (DI)** is used to inject the `CalculatorService` into the `CalculatorController`, promoting loose coupling and testability.

---

## Design Patterns
The application employs the following design patterns:
- **Dependency Injection (DI)**: Spring manages dependencies, allowing for flexible and testable code.
- **Singleton Pattern**: Spring beans (`@Service`, `@RestController`) are singletons by default, ensuring a single instance per application context.
- **MVC Pattern**: Separates concerns between the Controller (handling requests) and Service (business logic).

---

## API Design
The application exposes a RESTful API with the following endpoint:
- **Sum**: `GET /sum?a={a}&b={b}`
  Example: `GET /sum?a=5&b=3` → Response: `8`

The API follows RESTful principles, including statelessness and resource-based URLs. Requests are made via HTTP GET with query parameters, and responses are returned as plain text.

> **Note**: The `README.md` previously mentioned unimplemented endpoints (`add`, `subtract`, `multiply`, `divide`). These have been removed to avoid confusion, as only the `/sum` endpoint is currently implemented.

---

## Error Handling
Currently, the application does not implement explicit error handling. Future improvements include:
- Input validation for query parameters (e.g., ensuring `a` and `b` are valid integers).
- Exception handling for invalid inputs (e.g., `IllegalArgumentException` for division by zero or non-integer values).

---

## Testing Strategy
The application includes the following testing approaches:
- **Unit Tests**: `CalculatorServiceTest` verifies the business logic in isolation.
- **Integration Tests**: Planned for future implementation to test the API endpoints.
- **Code Coverage**: JaCoCo is configured to measure test coverage and ensure test effectiveness.

To execute the tests, run:
```bash
mvn test
```

---

## Deployment Architecture
The application is designed for containerized deployment:
- **Docker**: The application is packaged as a Docker image for consistent deployment across environments.
- **Jenkins**: A CI/CD pipeline automates builds, tests, and deployments. The `Jenkinsfile` defines the pipeline stages, including:
  - **Build**: Compiles the application and runs tests.
  - **Test**: Executes unit tests and generates code coverage reports.
  - **Deploy**: Deploys the application to a target environment (e.g., Docker container).

---

## Project Structure
```
.
├── src
│   ├── main
│   │   ├── java/com/tomwey2/calculator
│   │   │   ├── CalculatorApplication.java  # Main Spring Boot application class
│   │   │   ├── CalculatorController.java    # REST Controller for the API
│   │   │   └── CalculatorService.java       # Business logic for calculations
│   │   └── resources
│   │       └── application.properties       # Application configuration
│   └── test
│       └── java/com/tomwey2/calculator
│           ├── CalculatorApplicationTests.java  # Integration tests
│           └── CalculatorServiceTest.java       # Unit tests for business logic
├── Dockerfile                                # Docker configuration
├── Jenkinsfile                               # Jenkins CI/CD pipeline
├── pom.xml                                   # Maven configuration
└── README.md                                 # Project documentation
```

---

## Future Improvements
The following enhancements are planned for future iterations:
- Implement missing API endpoints (`add`, `subtract`, `multiply`, `divide`).
- Add input validation and error handling for robust API responses.
- Introduce logging for debugging and monitoring.
- Add integration tests for API endpoints.
- Consider adding a database for persistent storage if needed.

---

## Prerequisites
- Java 21 or higher
- Maven
- Docker
- Jenkins (optional, for CI/CD)

---

## Installation and Execution
### Local Execution
1. Clone the repository:
   ```bash
   git clone https://github.com/tomwey2/calculator-spring-docker-jenkins.git
   ```
2. Navigate to the project directory:
   ```bash
   cd calculator-spring-docker-jenkins
   ```
3. Build the application with Maven:
   ```bash
   mvn clean install
   ```
4. Start the application:
   ```bash
   mvn spring-boot:run
   ```
   The application will be available at `http://localhost:8080`.

### Docker Execution
1. Build the Docker image:
   ```bash
   docker build -t calculator-spring-app .
   ```
2. Start the container:
   ```bash
   docker run -p 8080:8080 calculator-spring-app
   ```
   The application will be available at `http://localhost:8080`.

---

## License
This project is licensed under the MIT License. See [LICENSE](LICENSE) for more information.