package com.barrista.spring.quickstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.barrista.spring.quickstart"})
public class QuickStartApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuickStartApplication.class, args);
	}
}
