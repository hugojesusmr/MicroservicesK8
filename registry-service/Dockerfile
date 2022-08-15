FROM openjdk:11-jre-slim
VOLUME /tmp
ARG JAR_FILE=build/libs/registry-service-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} registry-service.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/registry-service.jar"]