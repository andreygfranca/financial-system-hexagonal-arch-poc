package com.github.andreygfranca.accountspayable;

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
@ComponentScan(basePackages = "com.github.andreygfranca.accountspayable")
@EntityScan(basePackages = "com.github.andreygfranca.accountspayable")
@EnableJpaRepositories(basePackages = "com.github.andreygfranca.accountspayable")
@EnableRabbit
public class AccountsPayableApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountsPayableApplication.class, args);
    }

}
