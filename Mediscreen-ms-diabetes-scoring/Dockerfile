FROM openjdk:17
ARG JAR_FILE=build/libs/mediscreen-ms-diabetes-scoring-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} mediscreen-ms-diabetes-scoring-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/mediscreen-ms-diabetes-scoring-0.0.1-SNAPSHOT.jar"]
EXPOSE 8090
