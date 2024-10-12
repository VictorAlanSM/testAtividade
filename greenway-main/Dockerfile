FROM openjdk:21-jdk-slim

WORKDIR /app

COPY mvnw .
COPY .mvn .mvn

COPY pom.xml .

RUN ./mvnw dependency:go-offline

COPY src ./src

RUN ./mvnw package

CMD ["java", "-jar", "-Dspring.profiles.active=docker", "/app/target/greenway-main-0.0.1-SNAPSHOT.jar"]