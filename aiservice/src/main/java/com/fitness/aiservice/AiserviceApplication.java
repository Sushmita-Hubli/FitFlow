package com.fitness.aiservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AiserviceApplication {

	public static void main(String[] args) {

        System.out.println("GEMINI_URL = " + System.getenv("GEMINI_URL"));
        System.out.println("GEMINI_KEY = " + System.getenv("GEMINI_KEY"));
        SpringApplication.run(AiserviceApplication.class, args);
	}


}
