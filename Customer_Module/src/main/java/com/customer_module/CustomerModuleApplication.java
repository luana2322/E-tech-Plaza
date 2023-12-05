package com.customer_module;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
//		(scanBasePackages={"com.example.Customer_Module","com.example.Core_Module"})
@EntityScan(value="com.example.Core_Module.model")
@EnableWebSecurity
public class CustomerModuleApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerModuleApplication.class, args);
    }

}
