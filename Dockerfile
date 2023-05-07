FROM amazoncorretto:11.0.19
MAINTAINER CGC
COPY target/cgc-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
