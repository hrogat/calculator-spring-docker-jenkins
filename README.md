# Calculator Spring Boot Application mit Docker und Jenkins

Ein einfacher Taschenrechner als Spring Boot-Anwendung, der über eine REST-API verfügbar ist. Das Projekt ist mit Docker containerisiert und verwendet Jenkins für die CI/CD-Pipeline.

## Technologien

Die Anwendung verwendet folgende Technologien und Frameworks:

- **Spring Boot**:
  - Ein Framework für die Entwicklung von Java-Anwendungen, das Dependency Injection, REST-API-Unterstützung und Auto-Konfiguration bietet.
  - Ermöglicht die schnelle Entwicklung von Microservices und Webanwendungen.

- **Docker**:
  - Containerisiert die Anwendung, um eine konsistente Laufzeitumgebung über verschiedene Systeme hinweg zu gewährleisten.
  - Vereinfacht die Bereitstellung und Skalierung der Anwendung.

- **Jenkins**:
  - Automatisiert Build-, Test- und Deployment-Prozesse (CI/CD).
  - Ermöglicht die kontinuierliche Integration und Bereitstellung der Anwendung.

- **Maven**:
  - Build-Tool und Abhängigkeitsmanagement für Java-Projekte.
  - Verwaltet Abhängigkeiten und erleichtert die Kompilierung, das Testen und das Packaging der Anwendung.

## Funktionalität
Die Anwendung bietet eine REST-API für grundlegende Rechenoperationen wie Addition, Subtraktion, Multiplikation und Division. Die API kann über HTTP-Endpunkte aufgerufen werden.

## Architektur

### High-Level-Architektur
Die Anwendung folgt einer **dreischichtigen Architektur** (Three-Tier Architecture), die folgende Schichten umfasst:

1. **Presentation Layer (Controller)**:
   - Verantwortlich für die Verarbeitung von HTTP-Anfragen und -Antworten.
   - Implementiert als REST-Controller (`CalculatorController.java`).
   - Nimmt Eingaben entgegen und gibt Ergebnisse im JSON-Format zurück.

2. **Business Logic Layer (Service)**:
   - Enthält die Geschäftslogik der Anwendung.
   - Implementiert in `CalculatorService.java`.
   - Führt die eigentlichen Rechenoperationen durch.

3. **Data Layer (Repository)**:
   - In dieser Anwendung nicht explizit vorhanden, da keine Datenbank verwendet wird.
   - Würde in einer erweiterten Version z. B. für Benutzerdaten oder Historien verwendet werden.

### Komponenteninteraktion
Die Interaktion zwischen den Komponenten erfolgt wie folgt:
1. Ein Client sendet eine HTTP-Anfrage an einen REST-Endpunkt (z. B. `/api/calculate/add?a=5&b=3`).
2. Der `CalculatorController` empfängt die Anfrage und leitet die Parameter an den `CalculatorService` weiter.
3. Der `CalculatorService` führt die Rechenoperation durch und gibt das Ergebnis an den Controller zurück.
4. Der `CalculatorController` formatiert das Ergebnis als JSON und sendet es an den Client zurück.

## Design Patterns und Prinzipien

Die Anwendung folgt bewährten Design Patterns und Prinzipien, um Wartbarkeit, Erweiterbarkeit und Lesbarkeit zu gewährleisten:

- **Model-View-Controller (MVC)**:
  - Trennt die Darstellung (Controller), die Geschäftslogik (Service) und die Daten (Model).
  - Ermöglicht eine klare Trennung der Verantwortlichkeiten.

- **Dependency Injection (DI)**:
  - Spring Boot verwaltet die Abhängigkeiten zwischen Komponenten automatisch.
  - Erleichtert das Testen und die Wartung der Anwendung.

- **Single Responsibility Principle (SRP)**:
  - Jede Klasse hat eine einzige Verantwortung (z. B. `CalculatorController` für HTTP-Anfragen, `CalculatorService` für Rechenoperationen).

- **Keep It Simple, Stupid (KISS)**:
  - Die Anwendung ist bewusst einfach gehalten, um die Komplexität zu reduzieren.

- **Don’t Repeat Yourself (DRY)**:
  - Gemeinsame Logik wird in Methoden oder Klassen zentralisiert (z. B. Fehlerbehandlung in `CalculatorService`).

## Fehlerbehandlung

Die Anwendung implementiert grundlegende Fehlerbehandlung, um robuste und benutzerfreundliche Antworten zu gewährleisten:

- **HTTP-Statuscodes**:
  - Erfolgreiche Anfragen geben den Statuscode `200 OK` zurück.
  - Bei fehlerhaften Anfragen (z. B. Division durch Null) wird der Statuscode `400 Bad Request` zurückgegeben.

- **Ausnahmen**:
  - Der `CalculatorService` wirft eine `IllegalArgumentException`, wenn ungültige Parameter (z. B. Division durch Null) übergeben werden.
  - Der `CalculatorController` fängt diese Ausnahmen ab und gibt eine entsprechende Fehlermeldung zurück.

- **Beispiel**:
  - Anfrage: `GET /api/calculate/divide?a=5&b=0`
  - Antwort: `400 Bad Request` mit der Meldung `Division by zero is not allowed`.

## Sicherheit

Die Anwendung implementiert grundlegende Sicherheitsmaßnahmen:

- **Input-Validierung**:
  - Alle Eingabeparameter werden auf Gültigkeit überprüft (z. B. keine Division durch Null).
  - Ungültige Eingaben führen zu einer `400 Bad Request`-Antwort.

- **Keine Authentifizierung**:
  - Die Anwendung erfordert derzeit keine Authentifizierung oder Autorisierung, da sie keine sensiblen Daten verarbeitet.
  - Für zukünftige Erweiterungen (z. B. Benutzerverwaltung) sollte OAuth2 oder JWT implementiert werden.

- **Docker-Sicherheit**:
  - Der Docker-Container läuft mit minimalen Berechtigungen, um Sicherheitsrisiken zu minimieren.

## Skalierbarkeit und Performance

Die Anwendung ist so konzipiert, dass sie einfach skaliert werden kann:

- **Stateless Design**:
  - Die Anwendung ist zustandslos, was die Skalierung durch Hinzufügen weiterer Instanzen erleichtert.

- **Docker-Container**:
  - Die Anwendung kann in einem Docker-Container ausgeführt werden, was die Bereitstellung in verschiedenen Umgebungen vereinfacht.
  - Mehrere Container können hinter einem Load Balancer betrieben werden, um die Last zu verteilen.

- **Performance-Optimierungen**:
  - Die Rechenoperationen sind einfach und erfordern keine aufwändigen Berechnungen.
  - Für komplexere Anwendungsfälle könnten Caching-Mechanismen (z. B. Redis) implementiert werden.

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

## Tests

Die Anwendung verwendet eine Kombination aus Unit-Tests und Integrationstests, um die Funktionalität und Robustheit sicherzustellen:

- **Unit-Tests**:
  - Testen einzelne Komponenten isoliert (z. B. `CalculatorServiceTest.java`).
  - Verwenden Mocking (z. B. Mockito), um Abhängigkeiten zu simulieren.

- **Integrationstests**:
  - Testen die Interaktion zwischen Komponenten (z. B. `CalculatorApplicationTests.java`).
  - Stellen sicher, dass die API-Endpunkte korrekt funktionieren.

- **Testabdeckung**:
  - Die Tests decken alle Rechenoperationen und Fehlerfälle ab (z. B. Division durch Null).
  - Die Testabdeckung kann mit `mvn test` überprüft werden.

- **CI/CD-Integration**:
  - Die Tests werden automatisch in der Jenkins-Pipeline ausgeführt, um sicherzustellen, dass Änderungen keine Regressionen verursachen.

## Deployment-Architektur

Die Anwendung kann in verschiedenen Umgebungen bereitgestellt werden:

- **Lokale Entwicklung**:
  - Die Anwendung kann direkt mit `mvn spring-boot:run` gestartet werden.
  - Docker kann verwendet werden, um eine konsistente Laufzeitumgebung zu gewährleisten.

- **Docker-Container**:
  - Die Anwendung wird in einem Docker-Container verpackt, der auf jedem System mit Docker-Unterstützung ausgeführt werden kann.
  - Der Container kann auf Cloud-Plattformen wie AWS ECS, Google Cloud Run oder Azure Container Instances bereitgestellt werden.

- **Jenkins-Pipeline**:
  - Die `Jenkinsfile` definiert eine CI/CD-Pipeline, die folgende Schritte umfasst:
    1. **Build**: Kompiliert die Anwendung und führt Tests aus.
    2. **Docker Image**: Erstellt ein Docker-Image der Anwendung.
    3. **Deployment**: Stellt das Docker-Image in einer Zielumgebung bereit (z. B. Kubernetes-Cluster oder Cloud-Provider).

- **Umgebungen**:
  - Die Anwendung kann in verschiedenen Umgebungen (z. B. Entwicklung, Staging, Produktion) bereitgestellt werden.
  - Umgebungsabhängige Konfigurationen (z. B. Datenbankverbindungen) können über `application.properties` oder Umgebungsvariablen gesteuert werden.

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

## Mögliche Erweiterungen

Die Anwendung kann in Zukunft um folgende Funktionen und Verbesserungen erweitert werden:

- **Datenbankintegration**:
  - Speichern von Rechenhistorien oder Benutzerdaten in einer Datenbank (z. B. PostgreSQL).
  - Verwendung von JPA/Hibernate für die Datenbankinteraktion.

- **Erweiterte Rechenoperationen**:
  - Hinzufügen von komplexeren Operationen (z. B. Potenzierung, Wurzeln, trigonometrische Funktionen).

- **Benutzerverwaltung**:
  - Implementierung von Authentifizierung und Autorisierung (z. B. OAuth2 oder JWT).
  - Speichern von Benutzerpräferenzen oder Historien.

- **API-Dokumentation**:
  - Integration von Swagger/OpenAPI, um die API-Dokumentation automatisch zu generieren.

- **Frontend**:
  - Entwicklung eines React- oder Angular-Frontends, um die API benutzerfreundlicher zu gestalten.

- **Monitoring und Logging**:
  - Integration von Tools wie Prometheus und Grafana für das Monitoring.
  - Zentrale Protokollierung mit ELK-Stack (Elasticsearch, Logstash, Kibana).

## Lizenz
Dieses Projekt steht unter der MIT-Lizenz. Siehe [LICENSE](LICENSE) für weitere Informationen.