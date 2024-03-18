package com.lucatic.grupo2.app.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LucaDanceUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(LucaDanceUsersApplication.class, args);
	}

}
