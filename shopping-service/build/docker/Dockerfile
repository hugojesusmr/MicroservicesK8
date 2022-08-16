FROM openjdk:11-jre-slim
EXPOSE 8004
ARG JAR_FILE=build/libs/MicroServicioShoppingService-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} shopping-service.jar
ENTRYPOINT ["java","-jar","/shopping-service.jar"]