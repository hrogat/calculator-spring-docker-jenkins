# Calculator Spring Boot Application mit Docker und Jenkins

Ein einfacher Taschenrechner als Spring Boot-Anwendung, der über eine REST-API verfügbar ist. Das Projekt ist mit Docker containerisiert und verwendet Jenkins für die CI/CD-Pipeline.

## Technologien
- **Spring Boot**: Framework für die Java-Anwendung.
- **Docker**: Containerisierung der Anwendung.
- **Jenkins**: Automatisierte Builds und Deployments.
- **Maven**: Build-Tool und Abhängigkeitsmanagement.

## Architekturübersicht
Die Anwendung folgt einer **geschichteten Architektur** mit klaren Verantwortlichkeiten für jede Schicht:
- **Controller-Schicht**: Enthält REST-Endpunkte und verwaltet HTTP-Anfragen und -Antworten.
- **Service-Schicht**: Implementiert die Geschäftslogik für Berechnungen.
- **Konfiguration**: Verwaltet Anwendungseinstellungen über `application.properties`.

**Designmuster**:
- **MVC (Model-View-Controller)**: Die Anwendung folgt dem MVC-Muster, bei dem Controller Anfragen verarbeiten und Services die Logik implementieren.
- **Dependency Injection**: Spring Boot verwendet Dependency Injection, um Abhängigkeiten zwischen Komponenten zu verwalten.

**Prinzipien**:
- **Single Responsibility Principle (SRP)**: Jede Klasse hat eine klare Verantwortung.
- **KISS (Keep It Simple, Stupid)**: Einfache und verständliche Implementierung.
- **DRY (Don't Repeat Yourself)**: Code-Wiederverwendung zur Vermeidung von Redundanz.

## API-Design
Die REST-API ist einfach und intuitiv gestaltet:
- **Endpunkte**: Jede Berechnungsoperation hat ihren eigenen Endpunkt (z. B. `/api/calculate/add`).
- **Parameter**: Eingabewerte werden als Query-Parameter übergeben (z. B. `?a=5&b=3`).
- **Rückgabewerte**: Ergebnisse werden als JSON-Objekte zurückgegeben.

**Beispiel**:
```json
{
  "result": 8
}
```

## Fehlerbehandlung
Die Anwendung behandelt Fehler wie folgt:
- **Ungültige Eingaben**: Wenn ungültige Parameter übergeben werden (z. B. Division durch Null), wird ein HTTP 400-Fehler mit einer Fehlermeldung zurückgegeben.
- **Ausnahmen**: Spring Boot verwaltet Ausnahmen automatisch und konvertiert sie in HTTP-Fehlercodes.
- **HTTP-Statuscodes**:
  - `200 OK`: Erfolgreiche Anfrage.
  - `400 Bad Request`: Ungültige Eingabeparameter.
  - `500 Internal Server Error`: Serverseitige Fehler.

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
Das Projekt enthält eine `Jenkinsfile`, die für die automatisierte Build- und Deployment-Pipeline verwendet werden kann. Stelle sicher, dass Jenkins korrekt konfiguriert ist, um die Pipeline auszuführen.

## Teststrategie
Die Anwendung verwendet:
- **JUnit 5**: Für Unit-Tests der Geschäftslogik.
- **Mockito**: Zum Mocken von Abhängigkeiten in Tests.
- **Spring Boot Test**: Für Integrationstests der REST-Endpunkte.

**Testabdeckung**:
- Unit-Tests für alle Service-Methoden.
- Integrationstests für alle API-Endpunkte.

## Tests
Die Anwendung enthält Unit-Tests für die Rechenlogik und Integrationstests für die API. Um die Tests auszuführen, verwende den folgenden Befehl:
```bash
mvn test
```

## CI/CD-Pipeline
Die Jenkins-Pipeline umfasst die folgenden Stufen:
1. **Build**: Kompiliert den Code und führt Unit-Tests aus.
2. **Test**: Führt Integrationstests aus.
3. **Docker-Build**: Erstellt ein Docker-Image der Anwendung.
4. **Bereitstellung**: Stellt das Docker-Image in einer Testumgebung bereit.

Die Pipeline wird automatisch bei jedem Commit im Repository ausgelöst.

## Abhängigkeiten
Die Anwendung verwendet die folgenden wichtigsten Abhängigkeiten:
- **Spring Boot Starter Web**: Für die REST-API.
- **Spring Boot Starter Test**: Für Tests.
- **Lombok**: Zur Reduzierung von Boilerplate-Code.
- **JUnit 5**: Für Unit-Tests.
- **Mockito**: Zum Mocken von Abhängigkeiten.

## Skalierbarkeit und Performance
- Die Anwendung ist mit Docker containerisiert und kann einfach skaliert werden.
- Spring Boot unterstützt asynchrone Anfragen zur Leistungssteigerung.
- Die Anwendung ist zustandslos, was horizontale Skalierung ermöglicht.
- **Docker-Skalierung**: Die Anwendung kann in einem Kubernetes-Cluster oder mit Docker Swarm skaliert werden.

## Sicherheitsaspekte
- **Eingabevalidierung**: Alle Eingabeparameter werden validiert, um ungültige oder böswillige Daten zu verhindern.
- **Docker-Sicherheit**: Das Docker-Image wird mit minimalen Berechtigungen ausgeführt.
- **Authentifizierung**: Eine Authentifizierungsschicht kann für zukünftige Erweiterungen hinzugefügt werden.

## Zukünftige Verbesserungen
- **Datenbankintegration**: Speicherung des Berechnungsverlaufs in einer Datenbank.
- **Erweiterte Operationen**: Unterstützung für komplexere mathematische Operationen.
- **Monitoring**: Integration von Tools wie Prometheus und Grafana für das Monitoring.

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