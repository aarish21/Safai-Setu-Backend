# Stage 1: Build the jar using Maven with Java 21
FROM maven:3.9.2-eclipse-temurin-21 AS build

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src ./src

RUN mvn package -DskipTests


# Stage 2: Run the application
FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copy the built jar from the previous stage
COPY --from=build /app/target/*.jar app.jar

# Expose port (if your Spring Boot runs on 8080)
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app.jar"]
