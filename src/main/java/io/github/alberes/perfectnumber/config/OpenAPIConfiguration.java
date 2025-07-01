package io.github.alberes.perfectnumber.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Perfect Number API - https://springdoc.org/",
                version = "1.0.0",
                contact = @Contact(
                        name = "Alberes",
                        email = "perfect-number@gmail.com",
                        url = "http://en.wikipedia.org/wiki/Perfect_number"
                )
        )
)
public class OpenAPIConfiguration {
}