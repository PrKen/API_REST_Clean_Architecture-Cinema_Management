package com.example.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Cinema Management API")
                        .version("1.0")
                        .description("API pour la gestion des cinémas.")
                        .contact(new Contact()
                                .name("Support API")
                                .email("support@cinema.com")
                                .url("https://cinema.com")));
    }
}
