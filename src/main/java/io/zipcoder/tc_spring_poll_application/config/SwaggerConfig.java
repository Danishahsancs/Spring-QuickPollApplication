package io.zipcoder.tc_spring_poll_application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .host("localhost:8080")
                .select()
                .apis(RequestHandlerSelectors.basePackage("io.zipcoder.tc_spring_poll_application.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Quick Poll API",
                "API for managing polls and votes",
                "1.0",
                "Terms of service",
                new Contact("ZipCode Wilmington", "www.zipcodewilmington.com", "info@zipcodewilmington.com"),
                "License of API", "API license URL", Collections.emptyList());
    }
}