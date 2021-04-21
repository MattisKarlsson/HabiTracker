package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
feature/add-layered-architecture
@ComponentScan({"com.controller", "com.services", "com.repositories"})
public class HabiTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HabiTrackerApplication.class, args);
	}

}
