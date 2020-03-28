package com.akulinski.quickquestionnaire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class QuickquestionnaireApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuickquestionnaireApplication.class, args);
	}

}
