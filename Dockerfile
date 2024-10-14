# Use the official OpenJDK image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the Maven build output to the container
COPY target/*.jar app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]