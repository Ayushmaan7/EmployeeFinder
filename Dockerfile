# Use the OpenJDK base image
FROM openjdk:11-jdk-slim

# Set the working directory for the microservice
WORKDIR /app

# Copy the necessary files to the Docker image
COPY . /app

# Set the environment variable for the microservice port
ENV PORT 8080

# Build the microservice using Gradle
RUN ./gradlew build

# Define the command to run the microservice
CMD ["java", "-jar", "build/libs/my-microservice.jar"]

