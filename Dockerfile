FROM amazoncorretto:17-alpine-jdk
MAINTAINER Augusto
COPY target/portfolio-0.0.1-SNAPSHOT.jar portfolio.jar
ENTRYPOINT ["java","-jar","/portfolio-0.0.1-SNAPSHOT.jar"]
