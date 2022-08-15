FROM openjdk:11-jre-slim
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=build/libs/gateway-service-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} gateway-service.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/gateway-service.jar"]