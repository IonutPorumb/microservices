FROM openjdk:8u212-jdk-slim
LABEL maintainer="ionut.porumb0203@gmail.com"
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/codestatebkend-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} codestatebkend.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/codestatebkend.jar"]

