package com.example.loggingconsumer;
import java.util.function.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LoggingConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoggingConsumerApplication.class, args);
	}

	@Bean
	Consumer<Person> log1() {
		return person -> {
			System.out.println("Received: " + person);
		};
	}

	@Bean
	Consumer<Person> log2() {
		return person -> {
			System.out.println("Received: " + person);
		};
	}

	
	public static class Person {
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String toString() {
			return this.name;
		}
	}
}