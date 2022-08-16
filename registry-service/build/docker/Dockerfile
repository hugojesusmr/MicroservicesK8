FROM openjdk:11-jre-slim
EXPOSE 8761
ARG JAR_FILE=build/libs/registry-service-1.0.jar
ADD ${JAR_FILE} registry-service.jar
ENTRYPOINT ["java","-jar","/registry-service.jar"]