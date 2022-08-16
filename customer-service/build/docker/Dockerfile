FROM openjdk:11-jre-slim
EXPOSE 8003
ARG JAR_FILE=build/libs/customer-service-1.0.jar
ADD ${JAR_FILE} customerservice.jar
ENTRYPOINT ["java","-jar","/customer-service.jar"]