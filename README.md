# Calculator Spring Boot Application with Docker and Jenkins

A simple calculator implemented as a Spring Boot application, available via a REST API. The project is containerized using Docker and uses Jenkins for CI/CD pipeline automation.

## Description
This project provides a REST API for basic arithmetic operations such as addition, subtraction, multiplication, and division. It is designed to demonstrate the integration of Spring Boot with Docker and Jenkins for continuous integration and deployment.

## Technologies
- **Spring Boot 3.2**: Framework for the Java application.
- **Docker**: Containerization of the application.
- **Jenkins**: Automated builds and deployments.
- **Maven**: Build tool and dependency management.
- **Java 21**: Programming language.

## Functionality
The application provides a REST API for basic arithmetic operations:
- Addition
- Subtraction
- Multiplication
- Division

Each endpoint returns the result of the operation in JSON format.

## Project Structure
```
.
├── src
│   ├── main
│   │   ├── java/com/tomwey2/calculator
│   │   │   ├── CalculatorApplication.java  # Main class of the Spring Boot application
│   │   │   ├── CalculatorController.java    # REST controller for the API
│   │   │   └── CalculatorService.java       # Logic for arithmetic operations
│   │   └── resources
│   │       └── application.properties       # Application configuration
│   └── test
│       └── java/com/tomwey2/calculator
│           ├── CalculatorApplicationTests.java  # Tests for the application
│           └── CalculatorServiceTest.java       # Tests for arithmetic logic
├── Dockerfile                                # Docker configuration
├── Jenkinsfile                               # Jenkins pipeline
├── pom.xml                                   # Maven configuration
└── README.md                                 # Project description
```

## Prerequisites
- Java 21 or higher
- Maven
- Docker
- Jenkins (optional, for CI/CD)

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
3. Build the application using Maven:
   ```bash
   mvn clean install
   ```
4. Start the application:
   ```bash
   mvn spring-boot:run
   ```
   The application will be available at `http://localhost:8080`.

### Execution with Docker
1. Build the Docker image:
   ```bash
   docker build -t calculator-spring-app .
   ```
2. Run the container:
   ```bash
   docker run -p 8080:8080 calculator-spring-app
   ```
   The application will be available at `http://localhost:8080`.

### CI/CD with Jenkins
The project includes a `Jenkinsfile` for automated build and deployment pipelines. Ensure Jenkins is properly configured to execute the pipeline.

## Tests
The application includes unit tests for arithmetic logic and integration tests for the API. To run the tests, use the following command:
```bash
mvn test
```

## API Endpoints
The application provides the following endpoints:

- **Addition**: `GET /api/calculate/add?a={a}&b={b}`
  Example: `GET /api/calculate/add?a=5&b=3` → Response: `{"result": 8}`

- **Subtraction**: `GET /api/calculate/subtract?a={a}&b={b}`
  Example: `GET /api/calculate/subtract?a=5&b=3` → Response: `{"result": 2}`

- **Multiplication**: `GET /api/calculate/multiply?a={a}&b={b}`
  Example: `GET /api/calculate/multiply?a=5&b=3` → Response: `{"result": 15}`

- **Division**: `GET /api/calculate/divide?a={a}&b={b}`
  Example: `GET /api/calculate/divide?a=6&b=3` → Response: `{"result": 2}`

### Error Handling
- Division by zero returns a `400 Bad Request` response with an error message.

## License
This project is licensed under the MIT License. See [LICENSE](LICENSE) for more information.