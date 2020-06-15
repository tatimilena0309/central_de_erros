package com.codenation.centraldeerros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@EnableAutoConfiguration
@SpringBootApplication
public class CentralDeErrosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CentralDeErrosApplication.class, args);
	}

}
