FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY price-api-impl/target/price-api-impl-1.0-SNAPSHOT.jar price-api-impl-1.0-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","price-api-impl-1.0-SNAPSHOT.jar"]