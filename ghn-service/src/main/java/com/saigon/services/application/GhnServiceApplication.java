package com.saigon.services.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@EnableFeignClients
@SpringBootApplication
@OpenAPIDefinition(info =
	@Info(title = "GHN Service API - Project testing for GHN", version = "1.0.0", description = "Documentation GHN Service API v1.0")
)
public class GhnServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GhnServiceApplication.class, args);
	}

}
