package com.myfitnessapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class MyfitnessappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyfitnessappApplication.class, args);
	}

}
