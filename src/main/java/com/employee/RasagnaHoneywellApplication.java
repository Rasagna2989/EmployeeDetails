package com.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = { "com.employee" })
@SpringBootApplication
public class RasagnaHoneywellApplication {

	public static void main(String[] args) {
		SpringApplication.run(RasagnaHoneywellApplication.class, args);
	}

}
