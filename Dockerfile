FROM openjdk:17

WORKDIR /app

ADD /assets /app/assets

COPY target/*.jar app.jar

ENV SPRING_PROFILES_ACTIVE = prod

CMD ["java", "-jar", "-Dspring.profiles.active=${SPRING_PROFILES_ACTIVE}", "app.jar"]







#FROM openjdk:latest
#COPY target/*.jar app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]

#FROM mysql:latest
#ARG database
#ARG password
#
#RUN echo ${database}
#RUN echo ${password}
#
#
#ENV MYSQL_DATABASE=${database} \
#    MYSQL_ROOT_PASSWORD=${password}
#EXPOSE 3306