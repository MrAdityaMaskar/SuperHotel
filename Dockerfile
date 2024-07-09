FROM eclipse-temurin:17-jdk-alpine
COPY target/india-hotel-0.0.1-SNAPSHOT.jar /target/india-hotel-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/target/india-hotel-0.0.1-SNAPSHOT.jar"]