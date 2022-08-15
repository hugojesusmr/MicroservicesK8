FROM openjdk:11-jre-slim
VOLUME /tmp
EXPOSE 8093
ARG JAR_FILE=build/libs/MicroServicioShoppingService-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} shopping-service.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/shopping-service.jar"]