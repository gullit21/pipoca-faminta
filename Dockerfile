FROM openjdk:17-jdk-alpine

EXPOSE 8080 8000

ADD target/pipoca-faminta-0.0.1-SNAPSHOT.jar app-1.0.0.jar
ADD entrypoint.sh entrypoint.sh

ENTRYPOINT ["sh", "/entrypoint.sh"]