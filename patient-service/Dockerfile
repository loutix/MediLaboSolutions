#GENERATE BUILD
FROM maven:3.9.7-amazoncorretto-21-debian-bookworm as build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

#DOCKERIZE
FROM eclipse-temurin:21-jre-alpine
LABEL authors="Loïc_Dubrulle"
WORKDIR /app
COPY  --from=build /app/target/patient-service-0.0.1-SNAPSHOT.jar ./patient-service.jar
RUN echo ".jar patient-service copied"
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "patient-service.jar", "--spring.profiles.active=docker"]
