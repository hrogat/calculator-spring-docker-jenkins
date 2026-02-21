# Calculator Spring Boot Application mit Docker und Jenkins

Ein einfacher Taschenrechner als Spring Boot-Anwendung, der über eine REST-API verfügbar ist. Das Projekt ist mit Docker containerisiert und verwendet Jenkins für die CI/CD-Pipeline.

## Übersicht
Dies ist eine einfache Taschenrechner-Anwendung, die mit Spring Boot entwickelt wurde. Sie bietet eine REST-API für grundlegende arithmetische Operationen. Die Anwendung folgt einer klaren Schichtenarchitektur mit Trennung zwischen Controller-, Service- und Geschäftslogik-Schichten.


## Funktionalität
Die Anwendung bietet eine REST-API für grundlegende Rechenoperationen. Derzeit ist die Addition implementiert, weitere Operationen wie Subtraktion, Multiplikation und Division sind für zukünftige Iterationen geplant.


## Architektur

### High-Level Architektur
Die Anwendung folgt einer Schichtenarchitektur, bestehend aus den folgenden Komponenten:

- **Controller-Schicht**: Behandelt HTTP-Anfragen und -Antworten.
- **Service-Schicht**: Enthält die Geschäftslogik für arithmetische Operationen.
- **Konfiguration**: Minimale Konfiguration über `application.properties`.


### Komponenteninteraktion
Das folgende Diagramm veranschaulicht die Interaktion zwischen den Komponenten:

```
+----------------+       +----------------+       +----------------+
|   Client      | ----> | Calculator     | ----> | Calculator     |
| (HTTP Request)|       | Controller     |       | Service        |
+----------------+       +----------------+       +----------------+
        |                         |                         |
        |                         |                         |
        +-------------------------+-------------------------+
                                  |
                                  v
                          +----------------+
                          |   Response     |
                          +----------------+
```

1. Ein Client sendet eine HTTP-Anfrage an den `CalculatorController`.
2. Der `CalculatorController` leitet die Anfrage an den `CalculatorService` weiter.
3. Der `CalculatorService` führt die arithmetische Operation durch und gibt das Ergebnis an den `CalculatorController` zurück.
4. Der `CalculatorController` gibt das Ergebnis als HTTP-Antwort zurück.


### Design Patterns
Die Anwendung verwendet die folgenden Design Patterns:

- **MVC (Model-View-Controller)**: Der `CalculatorController` fungiert als Controller, und der `CalculatorService` als Model. Da es sich um eine REST-API handelt, gibt es keine View.
- **Dependency Injection**: Der `CalculatorService` wird in den `CalculatorController` mittels Spring's `@Autowired` Annotation injiziert.


### Datenfluss
Die folgenden Schritte beschreiben, wie eine Anfrage in der Anwendung verarbeitet wird:

1. Ein Client sendet eine HTTP-Anfrage an einen Endpunkt (z. B. `/sum?a=5&b=3`).
2. Der `CalculatorController` empfängt die Anfrage und extrahiert die Eingabeparameter.
3. Der `CalculatorController` leitet die Anfrage an den `CalculatorService` weiter.
4. Der `CalculatorService` führt die arithmetische Operation durch und gibt das Ergebnis an den `CalculatorController` zurück.
5. Der `CalculatorController` gibt das Ergebnis als HTTP-Antwort zurück.


### Technologiebegründung
Die folgenden Technologien wurden für diese Anwendung ausgewählt:

- **Spring Boot**: Bietet ein schnelles Entwicklungsframework für Java-Anwendungen. Es vereinfacht die Einrichtung und Konfiguration einer Spring-basierten Anwendung.
- **Docker**: Ermöglicht die Containerisierung der Anwendung, um Konsistenz über verschiedene Umgebungen hinweg zu gewährleisten und die Bereitstellung zu vereinfachen.
- **Jenkins**: Automatisiert den Build-, Test- und Bereitstellungsprozess, um kontinuierliche Integration und Delivery zu gewährleisten.


### Deployment-Architektur
Die Anwendung wird mit der folgenden Architektur bereitgestellt:

- **Containerisierung**: Die Anwendung wird als Docker-Container verpackt, der über das `Dockerfile` definiert ist.
- **CI/CD**: Jenkins wird verwendet, um den Build-, Test- und Bereitstellungsprozess zu automatisieren. Die `Jenkinsfile` definiert die Pipeline.
- **Ausführung**: Der Docker-Container kann lokal oder in einer Cloud-Umgebung (z. B. AWS, Azure, GCP) ausgeführt werden.


### Fehlerbehandlung
Die Anwendung implementiert derzeit keine explizite Fehlerbehandlung (z. B. Eingabevalidierung oder benutzerdefinierte Ausnahmen). Dies ist eine Lücke, die in zukünftigen Iterationen behoben werden sollte. Ungültige Eingaben können derzeit zu unerwartetem Verhalten oder Fehlern führen.


### Sicherheit
Die Anwendung implementiert derzeit keine Sicherheitsmaßnahmen wie Eingabevalidierung oder Authentifizierung. Dies ist eine Lücke, die in zukünftigen Iterationen behoben werden sollte, um robuste und sichere Operationen zu gewährleisten.


### Skalierbarkeit
Die Anwendung ist zustandslos konzipiert, was eine horizontale Skalierung ermöglicht. Die Docker-Containerisierung ermöglicht eine einfache Bereitstellung und Skalierung über mehrere Instanzen hinweg.


### Teststrategie
Die Anwendung umfasst die folgenden Teststrategien:

- **Unit-Tests**: Die Klasse `CalculatorServiceTest` enthält Unit-Tests für die Geschäftslogik im `CalculatorService`.
- **Integrationstests**: Die Klasse `CalculatorApplicationTests` enthält Integrationstests für die Anwendung.


### Monitoring und Logging
Die Anwendung implementiert derzeit kein Monitoring oder Logging. Dies ist eine Lücke, die in zukünftigen Iterationen behoben werden sollte, um Observability und Debugging-Fähigkeiten zu gewährleisten.


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
- Java 21 oder höher
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
Die Anwendung enthält Unit-Tests für die Geschäftslogik und Integrationstests für die API. Um die Tests auszuführen, verwende den folgenden Befehl:
```bash
mvn test
```


## API-Endpunkte
Die Anwendung bietet derzeit den folgenden Endpunkt:

- **Summe**: `GET /sum?a={a}&b={b}`
  Beispiel: `GET /sum?a=5&b=3` → Ergebnis: `8`

Die `README.md` erwähnt zusätzlich die Endpunkte `/add`, `/subtract`, `/multiply` und `/divide`, diese sind jedoch derzeit nicht implementiert. Diese Endpunkte sind für zukünftige Iterationen geplant.


## Lizenz
Dieses Projekt steht unter der MIT-Lizenz. Siehe [LICENSE](LICENSE) für weitere Informationen.