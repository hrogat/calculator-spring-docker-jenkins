# Calculator Spring Boot Application mit Docker und Jenkins

Ein einfacher Taschenrechner als Spring Boot-Anwendung, der über eine REST-API verfügbar ist. Das Projekt ist mit Docker containerisiert und verwendet Jenkins für die CI/CD-Pipeline.

## Technologien
- **Spring Boot**: Framework für die Java-Anwendung.
- **Docker**: Containerisierung der Anwendung.
- **Jenkins**: Automatisierte Builds und Deployments.
- **Maven**: Build-Tool und Abhängigkeitsmanagement.

## Architektur Overview
The application follows a **layered architecture** with clear separation of concerns:
- **Controller Layer**: Handles HTTP requests and responses (`CalculatorController`).
- **Service Layer**: Contains business logic (`CalculatorService`).
- **Configuration**: Managed via `application.properties`.

The project leverages **Spring Boot's Dependency Injection** to manage component interactions, ensuring loose coupling and testability. The RESTful API design adheres to standard HTTP methods and status codes.

### Component Interactions
- The `CalculatorController` exposes REST endpoints and delegates operations to the `CalculatorService`.
- The `CalculatorService` performs the actual calculations and returns results to the controller.

### Error Handling
- The application handles exceptions such as division by zero by returning appropriate HTTP error responses.
- Spring Boot's `@ControllerAdvice` can be used to centralize exception handling (not yet implemented).

## Funktionalität
Die Anwendung bietet eine REST-API für grundlegende Rechenoperationen wie Addition, Subtraktion, Multiplikation und Division. Die API kann über HTTP-Endpunkte aufgerufen werden.

## Projektstruktur
```
.
├── src
│   ├── main
│   │   ├── java/com/tomwey2/calculator
│   │   │   ├── CalculatorApplication.java  # Hauptklasse der Spring Boot-Anwendung
│   │   │   ├── CalculatorController.java    # REST-Controller für die API
│   │   │   └── CalculatorService.java       # Logik für die Rechenoperationen
│   │   └── resources
│   │       └── application.properties       # Konfiguration der Anwendung
│   └── test
│       └── java/com/tomwey2/calculator
│           ├── CalculatorApplicationTests.java  # Tests für die Anwendung
│           └── CalculatorServiceTest.java       # Tests für die Rechenlogik
├── Dockerfile                                # Docker-Konfiguration
├── Jenkinsfile                               # Jenkins-Pipeline
├── pom.xml                                   # Maven-Konfiguration
└── README.md                                 # Projektbeschreibung
```

### Updated Project Structure Explanation
- **Controller Layer**: `CalculatorController.java` handles HTTP requests and delegates logic to the service layer.
- **Service Layer**: `CalculatorService.java` contains the core business logic for calculations.
- **Configuration**: `application.properties` manages application settings.
- **Tests**: Unit and integration tests are located in the `test` directory.

## Voraussetzungen
- Java 11 oder höher
- Maven
- Docker
- Jenkins (optional, für CI/CD)

## Installation und Ausführung
### Lokale Ausführung
1. Klone das Repository:
   ```bash
   git clone https://github.com/tomwey2/calculator-spring-docker-jenkins.git
   ```
2. Navigiere in das Projektverzeichnis:
   ```bash
   cd calculator-spring-docker-jenkins
   ```
3. Baue die Anwendung mit Maven:
   ```bash
   mvn clean install
   ```
4. Starte die Anwendung:
   ```bash
   mvn spring-boot:run
   ```
   Die Anwendung ist nun unter `http://localhost:8080` verfügbar.

### Ausführung mit Docker
1. Baue das Docker-Image:
   ```bash
   docker build -t calculator-spring-app .
   ```
2. Starte den Container:
   ```bash
   docker run -p 8080:8080 calculator-spring-app
   ```
   Die Anwendung ist nun unter `http://localhost:8080` verfügbar.

### CI/CD mit Jenkins
The Jenkins pipeline automates the following stages:
1. **Build**: Compiles the application and runs unit tests.
2. **Test**: Executes integration tests and code quality checks (Checkstyle, JaCoCo).
3. **Deploy**: Deploys the application to a Docker container.

Das Projekt enthält eine `Jenkinsfile`, die für die automatisierte Build- und Deployment-Pipeline verwendet werden kann. Stelle sicher, dass Jenkins korrekt konfiguriert ist, um die Pipeline auszuführen.

## Tests
The application contains:
- **Unit Tests**: Cover core logic in `CalculatorService` using JUnit and Mockito.
- **Integration Tests**: Verify API endpoints and their interactions with the service layer.

Um die Tests auszuführen, verwende den folgenden Befehl:
```bash
mvn test
```

## Scalability and Performance
- The REST API is stateless, allowing for horizontal scaling.
- Future optimizations may include caching frequent calculations and load balancing.

## API-Endpunkte
Die Anwendung bietet folgende Endpunkte:
- **Addition**: `GET /api/calculate/add?a={a}&b={b}`
  Beispiel: `GET /api/calculate/add?a=5&b=3` → Ergebnis: `8`

- **Subtraktion**: `GET /api/calculate/subtract?a={a}&b={b}`
  Beispiel: `GET /api/calculate/subtract?a=5&b=3` → Ergebnis: `2`

- **Multiplikation**: `GET /api/calculate/multiply?a={a}&b={b}`
  Beispiel: `GET /api/calculate/multiply?a=5&b=3` → Ergebnis: `15`

- **Division**: `GET /api/calculate/divide?a={a}&b={b}`
  Beispiel: `GET /api/calculate/divide?a=6&b=3` → Ergebnis: `2`

## Lizenz
Dieses Projekt steht unter der MIT-Lizenz. Siehe [LICENSE](LICENSE) für weitere Informationen.