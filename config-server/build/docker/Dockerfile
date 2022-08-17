FROM openjdk:11-jre-slim
ARG JAR_FILE=build/libs/ConfigServerApplication-1.0.jar
ADD ${JAR_FILE} config-server.jar
ENTRYPOINT ["java","-jar","/config-server.jar"]
EXPOSE 8001