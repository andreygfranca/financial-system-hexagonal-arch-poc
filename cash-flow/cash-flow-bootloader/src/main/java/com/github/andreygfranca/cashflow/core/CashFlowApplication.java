package com.github.andreygfranca.cashflow.core;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Andrey Franca 
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.github.andreygfranca.cashflow")
@EntityScan(basePackages = "com.github.andreygfranca.cashflow")
@EnableJpaRepositories(basePackages = "com.github.andreygfranca.cashflow")
@EnableRabbit
public class CashFlowApplication {

    public static void main(String[] args) {
        SpringApplication.run(CashFlowApplication.class, args);
    }

}
