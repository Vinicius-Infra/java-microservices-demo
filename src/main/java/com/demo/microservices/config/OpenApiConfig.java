package com.demo.microservices.config; // Ajuste para o seu pacote correto

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Audit API - Java Service") // Título da API
                        .version("1.0.0") // Versão
                        .description("Serviço de Auditoria centralizado para microsserviços.") // Descrição
                        .termsOfService("http://swagger.io/terms/")
                        .contact(new Contact()
                                .name("Marcos Vinicius da Silva Barreto") // SEU NOME AQUI (Como no Kotlin)
                                .url("https://www.linkedin.com/in/vinicius-barreto-devops/") // Seu LinkedIn ou GitHub
                                .email("vinicius.barreto994@gmail.com")) // Seu e-mail
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")));
    }
}