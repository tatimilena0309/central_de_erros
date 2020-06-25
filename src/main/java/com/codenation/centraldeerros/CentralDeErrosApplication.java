package com.codenation.centraldeerros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@EnableJpaAuditing
@SpringBootApplication
public class CentralDeErrosApplication {

    public static void main(String[] args) {
        SpringApplication.run(CentralDeErrosApplication.class, args);
        // CRIPTOGRAFANDO A SENHA PARA TESTE
       // System.out.println(new BCryptPasswordEncoder().encode("123"));
    }

}


