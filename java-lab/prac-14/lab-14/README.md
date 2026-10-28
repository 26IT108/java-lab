# Lab 14 — Layered Java Application, JUnit, Packages and Runnable JAR

## Requirements
- JDK 17 or newer
- Apache Maven installed and available on PATH

## Project structure
- `model/Item.java`: item model
- `service/ItemService.java`: ArrayList-based service and save/load logic
- `app/Main.java`: console menu
- `src/test/java/service/ItemServiceTest.java`: JUnit tests
- `pom.xml`: Maven and JUnit configuration

## Run the tests
Open a terminal in this folder and run:

```bash
mvn test
```

## Build the JAR
```bash
mvn package
```

## Run the application
```bash
java -jar target/layered-app-1.0.jar
```

The program saves its data in `items.dat` in the current working directory when you choose **Save data**.

## Notes
- The JAR is configured with `app.Main` as its entry point.
- This is a standard runnable JAR, not a fat/uber JAR. The application itself uses only Java standard-library classes at runtime; JUnit is only used for tests.
