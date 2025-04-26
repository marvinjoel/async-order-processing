FROM eclipse-temurin:21.0.6_7-jdk

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 9000

ENTRYPOINT ["java", "-jar", "app.jar"]