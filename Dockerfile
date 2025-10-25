FROM maven:3.8.3-openjdk-17 AS build
COPY . .
RUN mvn clean install



FROM eclipse-temurin:21-jdk
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
