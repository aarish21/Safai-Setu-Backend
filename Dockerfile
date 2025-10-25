# Stage 1: Build the jar
FROM maven:3.9.2-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run the jar
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=build /app/target/safai-setu-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
