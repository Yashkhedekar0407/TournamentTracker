# Use official OpenJDK 17 image
FROM openjdk:17-jdk-slim

# Set working directory inside container
WORKDIR /app

# Copy the built JAR into container
COPY target/tournamentTracker-0.0.1-SNAPSHOT.jar app.jar

# Expose port (optional, for documentation)
EXPOSE 8080

# Command to run the app
ENTRYPOINT ["java","-jar","app.jar"]
