package com.vengeang.minipos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {
    @Bean
    OpenAPI casOpenAPI() {
        Info info = new Info().title("Mini POS")
                .description("Manage All Mini POS").version("1.0.0");
        return new OpenAPI().info(info);
    }
}
