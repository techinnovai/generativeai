package com.generativeai.generativeai.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class OpenAPIConfig {
    @Value("${bezkoder.contact.name}")
    private String contactName;

    @Value("${bezkoder.contact.url}")
    private String contactUrl;

    @Value("${bezkoder.contact.email}")
    private String contactEmail;

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Spring Boot REST API")
                        .version("1.0.0")
                        .description("A simple REST API using Spring Boot and Swagger 3")
                        .contact(new Contact().name(contactName).url(contactUrl).email(contactEmail))
                        .license(new License().name("Apache 2.0").url("https://www.apache.org/licenses/LICENSE-2.0.html")))
                .servers(Collections.singletonList(new Server().url("http://localhost:8080/")));
    }
}