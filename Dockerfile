FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/veiculos-0.0.1-SNAPSHOT.jar /app/veiculos.jar

EXPOSE 9090

ENTRYPOINT ["java", "-jar", "/app/veiculos.jar"]