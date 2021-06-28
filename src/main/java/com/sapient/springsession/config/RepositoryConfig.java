package com.sapient.springsession.config;

import com.sapient.springsession.repository.repository.OrderRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class RepositoryConfig {

    @Bean
//    @Scope(value = "prototype")
    public OrderRepository orderRepository(){
        return new OrderRepository();
    }
}
