package com.ejemplos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Ejercicio1SpringThApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio1SpringThApplication.class, args);
	}
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Ejercicio1SpringThApplication.class);
	}

}
