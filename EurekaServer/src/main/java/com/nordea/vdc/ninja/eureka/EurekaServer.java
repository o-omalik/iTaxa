package com.nordea.vdc.ninja.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;





@SpringBootApplication
@EnableEurekaServer
public class EurekaServer 
{
	public static void main(String[] args) {
		System.setProperty("spring.config.name", "eureka-server");
		SpringApplication.run(EurekaServer.class, args);
	}
	
}
