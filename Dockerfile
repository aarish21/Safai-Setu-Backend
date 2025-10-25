# Stage 1: Build the jar using Maven
FROM maven:3.8.3-openjdk-17 AS build

WORKDIR /app

# Copy pom.xml first to cache dependencies
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Build the jar
RUN mvn package -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copy the built jar from the previous stage
COPY --from=build /app/target/*.jar app.jar

# Expose port (if your Spring Boot runs on 8080)
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app.jar"]
