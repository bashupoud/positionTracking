package com.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//Automatically register to the Eureka server
@EnableDiscoveryClient 
public class PositionreceiverApplication {

	public static void main(String[] args) {
		SpringApplication.run(PositionreceiverApplication.class, args);
	}
}
