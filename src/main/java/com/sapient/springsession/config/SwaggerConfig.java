package com.sapient.springsession.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return  new Docket(DocumentationType.SWAGGER_2)
                    .select()
                    .apis(RequestHandlerSelectors.basePackage("com.sapient.springsession.controller.rest"))
                    .paths(PathSelectors.any())
                    .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Products API",
                "API provides Information around Product Service",
                "API TOS",
                "Terms of Service",
                new Contact("Arun Tiwari", "www.tekmentor.com", "arun.tiwar@tekmentors.com"),
                "MIT License",
                "License URL",
                Collections.emptyList()
        );
    }
}
