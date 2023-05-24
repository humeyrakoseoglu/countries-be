FROM openjdk:17

WORKDIR /app

ADD /assets /app/assets

COPY target/*.jar app.jar

CMD ["java", "-jar",  "app.jar"]