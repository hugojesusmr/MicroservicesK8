package com.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class productServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(productServicesApplication.class, args);
	}	
}
