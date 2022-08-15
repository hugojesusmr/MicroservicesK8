FROM openjdk:11-jre-slim
ARG JAR_FILE=build/libs/ConfigServer-1.0.jar
ADD ${JAR_FILE} config-server.jar
ENTRYPOINT ["java","/config-server.jar"]
EXPOSE 8001