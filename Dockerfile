FROM openjdk:17-jdk-slim
MAINTAINER gowri sankar aligi
COPY target/accounts-app-0.0.1-SNAPSHOT.jar accounts-app-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","accounts-app-0.0.1-SNAPSHOT.jar"]