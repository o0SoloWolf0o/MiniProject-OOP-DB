package com.miniproject.miniproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MiniprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniprojectApplication.class, args);
		// System.setProperty("spring.config.location", "file:/app/config/application-kubernetes.properties");
	}

}
