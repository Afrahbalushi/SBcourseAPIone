package com.example.firstDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class FirstDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstDemoApplication.class, args);
	}

}
