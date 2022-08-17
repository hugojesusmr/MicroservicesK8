FROM openjdk:11-jre-slim
EXPOSE 8002
ARG JAR_FILE=build/libs/productServicesApplication-1.0.jar
ADD ${JAR_FILE} product-service.jar
ENTRYPOINT ["java","-jar","/product-service.jar"]   