FROM openjdk:19-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} internship-api.jar
ENTRYPOINT ["java","-jar","/internship-api.jar"]