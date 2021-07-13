package com.dinesh.thinkme_clone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThinkMeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThinkMeApplication.class, args);
		System.out.println("Server Started...");
	}

}
