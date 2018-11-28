package com.example.springbootbackendapirest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringbootBackendApirestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApirestApplication.class, args);
	}
}
