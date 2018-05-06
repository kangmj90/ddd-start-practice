package com.practice;

import com.practice.order.model.Order;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class DddstartApplication {

	public static void main(String[] args) {
		SpringApplication.run(DddstartApplication.class, args);
	}

	public static void uuid() {
		UUID uuid = UUID.randomUUID();

		String strUuid = uuid.toString();
	}
}
