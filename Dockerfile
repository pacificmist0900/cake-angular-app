# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
MAINTAINER Prashant Sharma <pacificmist.0900@gmail.com>

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8085 available to the world outside this container
EXPOSE 8085

# The application's jar file
ARG JAR_FILE=cake-service/target/cake-service-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} cake-service.jar

# Run the jar file
ENTRYPOINT ["java","-Dspring.profiles.active=h2","-jar","/cake-service.jar"]
