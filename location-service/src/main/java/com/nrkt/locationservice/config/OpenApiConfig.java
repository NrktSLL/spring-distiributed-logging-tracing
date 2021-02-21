package com.nrkt.locationservice.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(title = "Spring Distributed Logging and Tracing",
                version = "1.0",
                description = "Spring Distributed Logging and Distributed Tracing Example"))
public class OpenApiConfig {
}
