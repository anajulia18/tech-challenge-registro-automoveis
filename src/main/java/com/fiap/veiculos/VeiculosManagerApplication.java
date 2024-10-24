package com.fiap.veiculos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class VeiculosManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(VeiculosManagerApplication.class, args);
	}

}