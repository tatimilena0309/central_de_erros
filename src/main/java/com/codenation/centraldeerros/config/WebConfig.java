package com.codenation.centraldeerros.config;

import com.codenation.centraldeerros.endpoint.controller.EventoController;
import com.codenation.centraldeerros.util.StringToEnumConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToEnumConverter());
    }
}
