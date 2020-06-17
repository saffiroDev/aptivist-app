package com.example.aptivist.aptivistapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.example" })
public class AptivistAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AptivistAppApplication.class, args);
	}

}
