FROM ubuntu:22.04
RUN apt update -y\
    && apt upgrade -y\
    && apt install -y openjdk-18-jdk\
    && export JAVA_HOME=/usr/lib/jvm/java-18-openjdk-amd64\
    && apt install maven -y
WORKDIR /app
COPY mvnw pom.xml ./
RUN mvn dependency:go-offline
COPY src ./src
CMD ["mvn", "spring-boot:run"]
