FROM openjdk:17
ARG JAR_FILE=target/mediscreen-webApp-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} mediscreen-webApp-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/mediscreen-webApp-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080
