FROM amazoncorretto:17

LABEL version="1.0"

EXPOSE 8080:8080

WORKDIR /app

COPY target/polkadanawa-0.0.1-SNAPSHOT.jar /app/polkadanawa.jar

ENTRYPOINT ["java", "-jar", "polkadanawa.jar"]