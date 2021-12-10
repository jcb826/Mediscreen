FROM openjdk:17
ARG JAR_FILE=target/Mediscreen-ms-diabetes-scoring-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} Mediscreen-ms-diabetes-scoring-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "Mediscreen-ms-diabetes-scoring-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080
