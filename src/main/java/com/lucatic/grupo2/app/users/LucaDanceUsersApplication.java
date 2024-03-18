package com.lucatic.grupo2.app.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Clase principal
 *
 * @author BlueDevTeam
 * @version 1.0.0
 * @since 18-03-2024
 */
@SpringBootApplication
@EnableDiscoveryClient
public class LucaDanceUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(LucaDanceUsersApplication.class, args);
	}

}
