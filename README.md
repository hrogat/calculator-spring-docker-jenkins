# Calculator Spring Boot Application mit Docker und Jenkins

Ein einfacher Taschenrechner als Spring Boot-Anwendung, der über eine REST-API verfügbar ist. Das Projekt folgt einer **Layered Architecture** (Controller, Service) und ist mit Docker containerisiert. Jenkins wird für die CI/CD-Pipeline verwendet, um automatisierte Builds, Tests und Deployments zu ermöglichen.

---

## Architekturübersicht
Dieses Projekt folgt einer **Layered Architecture** mit den folgenden Schichten:
- **Controller Layer**: Behandelt HTTP-Anfragen und -Antworten.
- **Service Layer**: Enthält die Geschäftslogik für die Rechenoperationen.

Ein einfaches Diagramm der Architektur:
```
┌───────────────────────┐
│      Client          │
└───────────┬─────────┘
              │
              ▼
┌───────────────────────┐
│   CalculatorController│
└───────────┬─────────┘
              │
              ▼
┌───────────────────────┐
│   CalculatorService   │
└───────────────────────┘
```

---

## Komponenteninteraktion
Der `CalculatorController` empfängt HTTP-Anfragen und delegiert die Geschäftslogik an den `CalculatorService`. Der `CalculatorService` führt die Berechnungen durch und gibt das Ergebnis an den Controller zurück. Die Anwendung verwendet derzeit keine Datenbank.

---

## Design Patterns und Prinzipien
- **MVC (Model-View-Controller)**: Der `CalculatorController` fungiert als Controller, und der `CalculatorService` als Model. Die "View" ist die HTTP-Antwort an den Client.
- **Dependency Injection (DI)**: Spring's `@Autowired` wird verwendet, um den `CalculatorService` in den `CalculatorController` zu injizieren.
- **Service Layer Pattern**: Die Geschäftslogik ist im `CalculatorService` gekapselt.

---

## Technologie-Stack im Detail
- **Spring Boot**: Vereinfacht die Entwicklung von REST-APIs, Dependency Injection und Anwendungskonfiguration.
- **Maven**: Build-Tool und Abhängigkeitsmanagement. Gewährleistet konsistente Builds und Dependency-Resolution.
- **Docker**: Containerisierungstechnologie, um die Anwendung und ihre Abhängigkeiten in einem portablen Container zu verpacken. Gewährleistet Konsistenz über verschiedene Umgebungen hinweg.
- **Jenkins**: CI/CD-Tool für automatisierte Builds, Tests und Deployments. Die `Jenkinsfile` definiert die Pipeline für dieses Projekt.

---

## API-Design
Die Anwendung bietet folgende RESTful-Endpunkte:
- **Addition**: `GET /sum?a={a}&b={b}`
  Beispiel: `GET /sum?a=5&b=3` → Ergebnis: `"8"`

Die API folgt RESTful-Prinzipien, gibt jedoch derzeit eine einfache Zeichenkette als Antwort zurück. Dies könnte in Zukunft auf JSON umgestellt werden.

---

## Fehlerbehandlung
Aktuell gibt es **keine explizite Fehlerbehandlung** in der Anwendung. Mögliche Probleme:
- Division durch Null führt zu einer `ArithmeticException`.
- Ungültige Eingaben (z. B. Nicht-Ganzzahlen) führen zu einer `MethodArgumentTypeMismatchException`.

**Zukünftige Verbesserungen**:
- Verwendung von `@ExceptionHandler` in Spring, um benutzerdefinierte Fehlerantworten (z. B. HTTP 400 für ungültige Eingaben) zu implementieren.

---

## Teststrategie
- **Unit Tests**: Die Klasse `CalculatorServiceTest` enthält Unit-Tests für die Geschäftslogik im `CalculatorService`.
- **Integration Tests**: Die Klasse `CalculatorApplicationTests` enthält Integrationstests für die Anwendung.

Tests können mit folgendem Befehl ausgeführt werden:
```bash
mvn test
```

**Zukünftige Verbesserungen**:
- Erweiterung der Tests um Edge-Cases (z. B. Division durch Null, große Zahlen).
- Hinzufügen von API-Tests mit Tools wie Postman oder RestAssured.

---

## Bereitstellungsarchitektur
Die Anwendung ist mit Docker containerisiert und kann lokal oder in einer Cloud-Umgebung bereitgestellt werden. Die `Dockerfile` definiert das Container-Image.

Die Jenkins-Pipeline (definiert in der `Jenkinsfile`) automatisiert:
- Builds bei Code-Änderungen.
- Ausführung von Tests.
- Erstellung und Bereitstellung des Docker-Images.

---

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
│           ├── CalculatorApplicationTests.java  # Integrationstests
│           └── CalculatorServiceTest.java       # Unit-Tests für die Rechenlogik
├── Dockerfile                                # Docker-Konfiguration
├── Jenkinsfile                               # Jenkins-Pipeline
├── pom.xml                                   # Maven-Konfiguration
└── README.md                                 # Projektbeschreibung
```

---

## Voraussetzungen
- Java 21 oder höher
- Maven
- Docker
- Jenkins (optional, für CI/CD)

---

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

---

## Zukünftige Verbesserungen
- **Fehlerbehandlung**: Implementierung von benutzerdefinierten Fehlerantworten und HTTP-Statuscodes.
- **API-Design**: Verwendung von JSON für Anfragen und Antworten.
- **Eingabevalidierung**: Validierung der Query-Parameter (z. B. Prüfung auf `null`-Werte).
- **Logging**: Hinzufügen von Logging für Debugging und Monitoring.
- **API-Dokumentation**: Integration von Swagger/OpenAPI für interaktive API-Dokumentation.
- **Standardisierung der API-Endpunkte**: Verwendung einer konsistenten Namenskonvention (z. B. `/api/calculate/sum`).
- **Skalierbarkeit**: Hinzufügen von Caching für häufige Berechnungen.