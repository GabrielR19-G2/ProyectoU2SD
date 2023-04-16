package com.itson.edu.mx.Proyectoud2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
@Configuration
@AutoConfiguration
@ComponentScan(basePackages = ("com.itson.edu.mx.Proyectoud2.controladores"))

public class Proyectoud2Application {

	public static void main(String[] args) {
		SpringApplication.run(Proyectoud2Application.class, args);
	}

}
