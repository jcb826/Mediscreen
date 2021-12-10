FROM openjdk:17
ARG JAR_FILE=target/Mediscreen-webApp-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} Mediscreen-webApp-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/Mediscreen-webApp-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080
