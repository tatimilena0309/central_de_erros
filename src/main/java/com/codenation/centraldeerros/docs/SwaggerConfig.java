package com.codenation.centraldeerros.docs;

import com.codenation.centraldeerros.dto.ResponseEventoDTO;
import io.swagger.annotations.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket apiDoc(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                    .apis(RequestHandlerSelectors.basePackage("com.codenation.centraldeerros.endpoint"))
                    .paths(regex("/api/evento.*"))
                    .build()
                .globalOperationParameters(Collections.singletonList(new ParameterBuilder().name("Authorization")
                .description("Bearer token")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(true)
                .build()))
                .apiInfo(metaData());
    }

    private ApiInfo metaData(){
        return new ApiInfoBuilder()
                .title("Central de Erros ")
                .description("Em projetos modernos é cada vez mais comum o uso de arquiteturas baseadas" +
                        " em serviços ou microsserviços. Nestes ambientes complexos, erros podem surgir em " +
                        "diferentes camadas da aplicação (backend, frontend, mobile, desktop) e mesmo em serviços" +
                        " distintos. Desta forma, é muito importante que os desenvolvedores possam centralizar " +
                        "todos os registros de erros em um local, de onde podem monitorar e tomar decisões mais " +
                        "acertadas. " +
                        "Neste projeto você encontra a implementação uma API Rest para centralizar registros de erros de aplicações.")
                .version("1.0")
                .contact(new Contact("Tatiane Martins","https://github.com/tatimilena0309/central_de_erros","tatiiane.martiins@gmail.com"))
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/license/LICENSE_2.0")
                .build();
    }
}
