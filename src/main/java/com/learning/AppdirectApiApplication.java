package com.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class AppdirectApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppdirectApiApplication.class, args);
	}
}
