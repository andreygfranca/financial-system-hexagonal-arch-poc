package com.github.andreygfranca.accountspayable.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Andrey Franca 
 */
@Configuration
@EnableSwagger2
@PropertySource("classpath:accounts-payable.properties")
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .tags(
                        new Tag("AccountsPayable", "Accounts Payable RESTful API")
                )
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.github.andreygfranca.accountspayable.api"))
                .paths(PathSelectors.any())
                .build();
    }
}
