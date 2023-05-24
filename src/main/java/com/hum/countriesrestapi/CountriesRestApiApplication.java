package com.hum.countriesrestapi;
/*
 *@author Humeyra Koseoglu
 @since 22.03.2023
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@Configuration
public class CountriesRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountriesRestApiApplication.class, args);
	}

	//Bu metot Cross-Origin Resource Sharing (CORS) yapılandırmasını gerçekleştirmeyi saglar.
	@Bean
	public WebMvcConfigurer configure(){ //WebMvcConfigurer, Spring MVC'nin yapılandırılmasına yönelik çeşitli yapılandırma seçeneklerini sağlar
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry){	//CorsRegistry, CORS yapılandırmasını tanımlamak için kullanılan yöntemleri sağlar.
				registry.addMapping("/**")	//tüm URL yolları için CORS kısıtlamaları tanımlanır
                .allowedOrigins("http://localhost:3000")	// sadece http://localhost:3000 kaynağına yapılan istekler kabul edilecektir.
                .allowedMethods("*");	//kabul edilecek HTTP yöntemlerini belirlemek için kullanılır
			}
		};
	}

}