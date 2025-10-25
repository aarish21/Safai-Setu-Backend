# Stage 1: Build with Maven
FROM maven:3.9.2-jdk-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run app
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=build /app/target/safai-setu-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
