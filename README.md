# karate-spring
Sample repo for integrating Spring DI/config into Karate

## Technologies Used

* [Java 21](https://www.java.com)
* [Gradle](https://gradle.org/)
* [Karate](https://www.karatelabs.io/)
* [Spring Boot](https://spring.io/projects/spring-boot)
* [Lombok](https://projectlombok.org/)

## Pre-requisites

* `Java 17+` - This project uses the Gradle Java Toolchain to install Java 21 if necessary, but you will
at least need Java 17 or higher setup as your `JAVA_HOME` to run Gradle itself.

## How to run application

`gradlew bootRun`

Swagger documentation is available at `http://localhost:${server.port}/swagger-ui/index.html`

## How to run tests

`gradlew test` - Ensure the application is running before running the tests

## Useful properties

`server.port` - Port on which the application will run. Default is 8080

`app.server.port` - Tells the Karate tests on which port the application is running. Default is 8080

`karate.threads` - Number of threads to run the tests. Default is 5.

`testLogging.showStandardStreams` - Show the test logs in the console. Default is true.

`jwt.expiration.ms` - Expiration time for the JWT token in milliseconds. Default 15000.

`jwt.secret` - Secret key to sign the JWT token.
