package com.gateway.springatway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringatwayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringatwayApplication.class, args);
	}

}
