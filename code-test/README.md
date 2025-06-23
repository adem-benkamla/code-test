# Health Index Processor

This Java project, part of a larger hospital information system, reads a patient "health index" (integer) provided by a sensor and returns the appropriate medical units.

## Architecture
- **MedicalUnitResolver**: interface defining how to resolve medical units from an index.
- **DefaultMedicalUnitResolver**: default implementation that checks multiples of 3 (Cardiology) and 5 (Traumatology).
- **HealthIndexProcessor**: business class that delegates to a `MedicalUnitResolver` via constructor injection.

## Requirements
- Java 11+
- Maven

## Build & Test
```bash
mvn clean test
```

## Run
```bash
mvn exec:java -Dexec.mainClass="com.example.health.Main"
```
