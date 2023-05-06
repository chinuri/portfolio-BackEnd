FROM amazoncorretto:11-alpine-jdk
MAINTEINER CGC
COPY target/SpringBoot-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
