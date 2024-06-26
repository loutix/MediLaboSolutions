#GENERATE BUILD
FROM maven:3.9.7-amazoncorretto-21-debian-bookworm as build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package

#DOCKERIZE
FROM eclipse-temurin:21-jre-alpine
LABEL authors="Loïc_Dubrulle"
WORKDIR /app
COPY  --from=build /app/target/note-service-0.0.1-SNAPSHOT.jar ./note-service.jar
RUN echo ".jar copied"
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "note-service.jar", "--spring.profiles.active=docker" ]

