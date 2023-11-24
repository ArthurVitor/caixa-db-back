FROM openjdk:17-jdk-alpine3.13

WORKDIR /app

CMD ["./gradlew", "clean", "bootJar"]

COPY build/libs/patocheckoutbackend-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar","app.jar"]