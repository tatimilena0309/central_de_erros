package com.codenation.centraldeerros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@EnableAutoConfiguration
@EnableJpaAuditing
@SpringBootApplication
/*@Configuration
@ComponentScan(basePackages = {"com.codenation.centraldeerros.mappers",
		"com.codenation.centraldeerros.controller",
		"com.codenation.centraldeerros.service",
		"com.codenation.centraldeerros.repository",
		"com.codenation.centraldeerros.entity"
},
basePackageClasses = EventoMapper.class)*/
public class CentralDeErrosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CentralDeErrosApplication.class, args);
	}

}
