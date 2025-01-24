# Use a base image with Java 17
FROM openjdk:17

# Copy the JAR package into the image
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Expose the application port
EXPOSE 8090

# Run the App
ENTRYPOINT ["java", "-jar", "/app.jar"]


## Use Maven to build the application
#FROM maven:3.9.8-eclipse-temurin-21 AS builder
#
## Set the working directory for the build
#WORKDIR /app
#
## Copy the Maven project files
#COPY pom.xml .
#COPY src ./src
#
## Build the application
#RUN mvn clean package
#
## Use a minimal Java runtime for the final image
#FROM openjdk:17-jdk-slim
#
## Add a volume to hold the application data
#VOLUME /tmp
#
## The application's jar file
#ARG JAR_FILE=target/countryRestvsGraphGL-1.0-SNAPSHOT.jar
#
## Copy the jar file from the build stage to the final image
#COPY --from=builder /app/${JAR_FILE} app.jar
#
## Run the jar file
#ENTRYPOINT ["java","-jar","/app.jar"]




## first stage
#FROM openjdk:17-oracle AS builder
#WORKDIR /project
#ADD . /project
##RUN /bin/sh -c 'mvnw clean install'
#
#RUN ./mvnw package -DskipTests
#
##second stage
##smaller OS footprint using JRE
#FROM openjdk:17-jdk-slim
#WORKDIR /app
##copy only jar from the builder stage
#COPY --from=builder /countryRestvsGraphGL/target/countryRestvsGraphGL-1.0-SNAPSHOT.jar /app
#CMD ["java", "-jar","countryRestvsGraphGL-1.0-SNAPSHOT.jar"]

