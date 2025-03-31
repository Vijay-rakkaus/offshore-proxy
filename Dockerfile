# Use official OpenJDK image
FROM openjdk:17
WORKDIR /app
COPY build/libs/offshore-proxy-1.0-SNAPSHOT.jar app.jar
EXPOSE 9091
ENTRYPOINT ["java", "-jar", "app.jar"]