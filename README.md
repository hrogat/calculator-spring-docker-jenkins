# Calculator Spring Boot Application mit Docker und Jenkins

Ein einfacher Taschenrechner als Spring Boot-Anwendung, der über eine REST-API verfügbar ist. Das Projekt ist mit Docker containerisiert und verwendet Jenkins für die CI/CD-Pipeline.

## Technologien
- **Spring Boot**: Framework für die Java-Anwendung.
- **Docker**: Containerisierung der Anwendung.
- **Jenkins**: Automatisierte Builds und Deployments.
- **Maven**: Build-Tool und Abhängigkeitsmanagement.

## Architektürübersicht

### Geschichtete Architektur
Die Anwendung folgt einer geschichteten Architektur:
- **Controller-Schicht**: Die Klasse `CalculatorController` verarbeitet HTTP-Anfragen und delegiert die Geschäftslogik an die Service-Schicht.
- **Service-Schicht**: Die Klasse `CalculatorService` enthält die Kernlogik für die Durchführung von Berechnungen.

### Entwurfsmuster
- **Dependency Injection**: Spring Boots `@Autowired`-Annotation wird verwendet, um Abhängigkeiten, wie den `CalculatorService`, in den `CalculatorController` einzubinden.
- **RESTful-API-Design**: Die Anwendung folgt REST-Konventionen für die Benennung von Endpunkten und Abfrageparametern.

### API-Design
Die API ist nach REST-Konventionen gestaltet:
- Endpunkte werden basierend auf der durchgeführten Operation benannt (z. B. `/api/calculate/add`).
- Abfrageparameter werden für Eingabewerte verwendet (z. B. `a` und `b` für Operanden).
- Antworten werden als einfacher Text zurückgegeben.

### Fehlerbehandlung
- Ungültige Eingaben (z. B. nicht-numerische Werte) werden durch den Standard-Fehlerbehandlungsmechanismus von Spring Boot behandelt.
- Division durch Null wird in der aktuellen Implementierung nicht explizit behandelt, kann aber in Zukunft hinzugefügt werden.

### Skalierbarkeit und Erweiterbarkeit
- Die geschichtete Architektur ermöglicht das einfache Hinzufügen neuer Operationen durch Erweiterung des `CalculatorService` und das Hinzufügen entsprechender Endpunkte im `CalculatorController`.
- Die Anwendung kann mit Docker containerisiert und in skalierbaren Umgebungen bereitgestellt werden.

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

## Tests
Die Anwendung enthält Unit-Tests für die Rechenlogik und Integrationstests für die API. Um die Tests auszuführen, verwende den folgenden Befehl:
```bash
mvn test
```

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