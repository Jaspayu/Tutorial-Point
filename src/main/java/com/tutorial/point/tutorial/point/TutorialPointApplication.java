package com.tutorial.point.tutorial.point;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class TutorialPointApplication {

	public static void main(String[] args) {
		SpringApplication.run(TutorialPointApplication.class, args);
	}

}
