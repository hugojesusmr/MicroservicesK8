FROM openjdk:11-jre-slim
EXPOSE 8083
ARG JAR_FILE=build/libs/customerservice-1.0.jar
ADD ${JAR_FILE} customerservice.jar
ENTRYPOINT ["java","-jar","/customerservice.jar"]