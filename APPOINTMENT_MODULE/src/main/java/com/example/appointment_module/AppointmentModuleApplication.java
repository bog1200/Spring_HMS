package com.example.appointment_module;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AppointmentModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppointmentModuleApplication.class, args);
	}

}
