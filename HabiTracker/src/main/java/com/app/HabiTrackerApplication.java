package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

import java.util.Collections;

@SpringBootApplication

@EnableSwagger2

// removed ComponentScan for repositories since it will be scanned by using "EnableJpaRepositories"
@ComponentScan({"com.controller", "com.services", "com.aop"})
@EntityScan("com.entities")
@EnableJpaRepositories("com.repositories")

public class HabiTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HabiTrackerApplication.class, args);
	
	}
	@Bean
	public Docket swaggerConfiguration() {
		// This returns a prepared Docket for Swagger. 
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(regex("/api.*"))
				.apis(RequestHandlerSelectors.basePackage("com."))
				.build()
				.apiInfo(apiDetails());
	}
private ApiInfo apiDetails() {
		return new ApiInfo(
				"Habit API",
				"Track your good and bad habits for a better life",
				"1.0",
				"Free for all", 
		new springfox.documentation.service.Contact(
							"Christian Torlegard",
							"https://google.com",
							"christian.torlegard@outlook.com"),							
				"API License",
				"https://google.com",
		Collections.emptyList()
		);
}
}
	

	

