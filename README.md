# Java Spring Boot Rest Api Countries Project

## Branch 1
### Scope: <br/>
A rest api serving the json file in the link below from the localhost:8080 port.
<br/>

### Goal: <br/>
 The json file containing the country information will be read by File Read operations and properly kept for the life of the SpringBoot application. This data will be used for rest api.
<br/>

### Used technologies and dependencies: <br/>
- Java 17<br/>
- Spring Boot 3.0.4<br/>
- Spring Boot Starter Web: A starter for MVC and RESTful applications<br/>
- Spring Boot DevTools: provides tools for rapid development<br/>
- Spring Boot Maven Plugin<br/>
<br/>

### Data that the API must provide: <br/>
Our service will return json in response to requests. Data will be requested by the client in the following scope and methods will be written to respond to this data:<br/>
- All countries<br/>
- Only a country with a certain country code (Example: TR)<br/>
- All countries in descending or ascending order by country phone codes.<br/>
- Filtered countries according to country's currency, phoneCode and continent.<br/>
<br/>

### Package Structure: <br/>
com.humeyra.countriesjavaspringboot<br/>
├── controller<br/>
│   └── CountryController.java<br/>
├── resources<br/>
│   └── countries.json<br/>
├── model<br/>
│   └── Country.java<br/>
├── service<br/>
│   └── CountryService.java<br/>
└── CountriesJavaSpringBootApplication.java<br/>
<br/>

## Branch 2

### Goal: <br/>
 We will add an additional database on top of the work in Brach 1. Country information will be kept in the Country table that we will create for the database.
<br/>

### Used technologies and dependencies: <br/>
- Java 17<br/>
- Spring Boot 3.0.4<br/>
- Spring Boot Starter Web: A starter for MVC and RESTful applications<br/>
- Spring Boot DevTools: provides tools for rapid development<br/>
- Spring Boot Maven Plugin<br/>
- MySQL 8.0.32<br/>
- JDBC(Java DataBase Connectivity)<br/>
<br/>

### Data that the API must provide: <br/>
- getAllCountries -- Returns all countries<br/>
- getCountry -- Returns the country based on the id parameter it takes.<br/>
- getCountryByFilters -- Returns matching countries, filtering by Currency, phoneCode, and continent properties.<br/>
- getCountryByOrder -- Returns all countries in descending or ascending order by phone code.<br/>
<br/>

### Package Structure: <br/>
com.humeyra.countriesjavaspringboot<br/>
├── controller<br/>
│   └── CountryController.java<br/>
├── resources<br/>
│   └── countries.json<br/>
├── model<br/>
│   └── Country.java<br/>
├── service<br/>
│   └── CountryService.java<br/>
├── util<br/>
│   └── DBUtil.java<br/>
└── CountriesJavaSpringBootApplication.java<br/>
<br/>


### Running the application locally<br/>
There are several ways to run a Spring Boot application on your local machine. One way is to execute the main method in the com.hum.countries-rest-api.Application class from your IDE.<br/>

Alternatively you can use the Spring Boot Maven plugin like so:<br/>
./mvnw spring-boot:run<br/>

## Branch 3

### Goal: <br/>
We will learn how to create a REST API with Spring Boot, MySQL, JPA and Hibernate.
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
<br/>

### Data that the API must provide: <br/>
- oneTimeInsert -- Insert all countries to database.<br/>
- getAllCountries -- Returns all countries<br/>
- getCountryByCode -- Returns the country based on the id parameter it takes.<br/>
- getCountryByName -- Returns the country based on the name parameter it takes.<br/>
- getCountriesByProperties -- Returns matching countries, filtering by Currency, phoneCode, and continent properties.<br/>
- orderCountriesByPhoneCode -- Returns all countries in descending or ascending order by phone code.<br/>
<br/>

### Package Structure: <br/>
com.humeyra.countriesjavaspringboot<br/>
├── controller<br/>
│   └── CountryController.java<br/>
├── resources<br/>
│   └── countries.json<br/>
├── model<br/>
│   └── Country.java<br/>
├── repository<br/>
│   └── CountryRepository.java<br/>
├── service<br/>
│   └── CountryService.java<br/>
└── CountriesJavaSpringBootApplication.java<br/>
<br/>

### To use applicaiton.properties instead of application.yml<br/>
spring.datasource.url=jdbc:mysql://localhost:3306/countries<br/>
spring.datasource.username=root<br/>
spring.datasource.password=414141<br/>
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver<br/>
spring.jpa.hibernate.ddl-auto=update<br/>
spring.jpa.show-sql=true<br/>
 
spring.jpa.properties.hibernate.format_sql=true<br/>
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect<br/>
spring.jpa.open-in-view=false<br/>
<br/>

### Running the application locally<br/>
There are several ways to run a Spring Boot application on your local machine. One way is to execute the main method in the com.hum.countries-rest-api.Application class from your IDE.<br/>

Alternatively you can use the Spring Boot Maven plugin like so:<br/>
./mvnw spring-boot:run<br/>


