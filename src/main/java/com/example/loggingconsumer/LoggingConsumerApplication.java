package com.example.loggingconsumer;

import java.util.Date;
import java.util.function.Supplier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LoggingConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoggingConsumerApplication.class, args);
	}

	@Bean
	Supplier<Date> date() {
		System.out.println("Running Supplier");
		return () -> new Date(12345L);
	}
}