# BrandPay Project

## Overview
BrandPay is a Java project that includes classes for handling a checkout system with dynamic pricing rules in a supermarket context. This project is configured to work with IntelliJ IDEA and uses JUnit for unit testing.

## Setup

### Prerequisites

- Java JDK 1.8 or newer
- IntelliJ IDEA (Community or Ultimate Edition)
- JUnit 5.8.1 for unit testing

### Configuration

The project is set up to inherit JDK settings and classpath definitions from the IntelliJ IDEA project defaults. The `.iml` file is configured with paths for source and test directories, as well as with the necessary libraries for JUnit testing.

### Libraries

JUnit 5.8.1 is used for unit testing, including:
- JUnit Jupiter API
- JUnit Jupiter Engine
- OpenTest4J for assertions
- JUnit Platform Commons and Engine

These are configured directly in the IntelliJ IDEA project settings, under the module libraries.

## Building and Running

### Building the Project

1. Open IntelliJ IDEA.
2. Select `File > Open` and choose the BrandPay project directory.
3. Build the project using `Build > Build Project`.

### Using Command-Line

If you prefer using the command line or need to integrate with CI/CD systems, you can use the following instructions.

#### With Maven
With Maven, you can use these commands:

```bash
# Build the project
mvn compile

# Run tests
mvn test
```

#### With Gradle

With Gradle, you can use these commands:

```bash
# Build the project
gradle build

# Run tests
gradle test
```
### Running Tests

- Right-click on the `src/test/java` directory in the project explorer.
- Select `Run 'Tests in 'java''` to execute all unit tests.
