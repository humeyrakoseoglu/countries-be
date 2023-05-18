package com.hum.countriesrestapi;
/*
 *@author Humeyra Koseoglu
 @since 22.03.2023
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

//@EnableJpaRepositories //(basePackages = "com.hum.countriesrestapi.repository")

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@SpringBootApplication
@Configuration
public class CountriesRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountriesRestApiApplication.class, args);
	}

}