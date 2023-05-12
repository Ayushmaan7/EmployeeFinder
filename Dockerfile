FROM openjdk:11-jdk-slim

WORKDIR /app

COPY build.gradle settings.gradle gradlew /app/
COPY src /app/src

RUN ./gradlew build

EXPOSE 8080

CMD ["java", "-jar", "build/libs/my-microservice.jar"]
