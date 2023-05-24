# Java Spring Boot Rest Api Countries Project

An example of a RESTful API developed using Spring & SpringBoot.


### Goal: <br/>
In this task, the desired Spring Boot application and database are to be made into a Docker container.
We will learn how to dockerize a Spring Boot Project and Mysql.
<br/>

### Used technologies and dependencies: <br/>
- Java 17<br/>
- Spring Boot 3.0.4<br/>
- Spring Boot Starter Web: A starter for MVC and RESTful applications<br/>
- Spring Boot DevTools: provides tools for rapid development<br/>
- Spring Boot Maven Plugin<br/>
- MySQL 8.0.32<br/>
- Spring Boot JPA (Java Persistence API)<br/>
- Hibernate Criteria API<br/>
- Docker<br/>
<br/>

### Data that the API must provide: <br/>
- oneTimeInsert -- Insert all countries to database.<br/>
- deleteCountryById -- Deletes the country based on the id parameter it takes<br/>
- insertCountry -- Adds the country to database<br/>
- oneTimeInsert -- Insert all countries to database.<br/>
- getCountryByCode -- Returns the country based on the id parameter it takes.<br/>
- getCountryByName -- Returns the country based on the name parameter it takes.<br/>
- getCountriesByProperties -- Returns matching countries, filtering by Currency, phoneCode, and continent properties.<br/>
- orderCountriesByPhoneCode -- Returns all countries in descending or ascending order by phone code.<br/>
<br/>

### Running the application locally<br/>
There are several ways to run a Spring Boot application on your local machine. One way is to execute the main method in the com.hum.countries-rest-api.Application class from your IDE.<br/>

Alternatively you can use the Spring Boot Maven plugin like so:<br/>
./mvnw spring-boot:run<br/>
We can send the request to the back-end via the url http://localhost:8080.


### Building the project<br/>
Clone the project and use Maven to build the server. Thus, we can create the jar extension file. <br/>

	$ mvn clean install -DskipTests<br/>

### Docker Integration - Running the application in Docker : <br/>
 The Docker containerization platform is a technology used to accelerate the development and deployment of applications. Thanks to Docker, it becomes possible to run and manage applications seamlessly in different environments.
<br/>

In this project, Docker Compose was used to manage the Spring Boot application running in different environments.<br/>
Dev: The local environment in which we develop.<br/>
Prod: The live environment where the product is presented to customers.<br/>
That's why we created 2 different configuration files for our project.
For the development environment, we configure the active profile as dev or prod in the application.yml file.<br/>
<br/>At the same time, after build we copy our .jar file created under the target folder to the dockerfile with the name app.jar.
<br/>Also in the Dockerfile the environment variable SPRING_PROFILES_ACTIVE is used to specify the Spring profiles that will run in your production environment. For example: "prod"
In the init.sh file, we added a wait time between mysql and the project containers when creating our docker containers so that the project waits for mysql to stand up. Therefore, when we want to run the project in docker, we can directly write "./init.sh" instead of "docker-compose run".<br/>
In this project<br/>
The ports for mysql are '5555:3306'. 5555 is port. 3306 is the inner port of the container.<br/>
The ports for the Spring Boot project are '4141:8080 ' . 4141 is external port. In other words, it is the port we will use when we try to reach the application through the Docker container. 8080 is the inner port of the container.<br/>

Now we can send the request to the back-end via the url http://localhost:4141/.

