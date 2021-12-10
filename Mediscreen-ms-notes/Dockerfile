FROM openjdk:17
ARG JAR_FILE=target/Mediscreen-ms-notes-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} Mediscreen-ms-notes-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "Mediscreen-ms-notes-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080
