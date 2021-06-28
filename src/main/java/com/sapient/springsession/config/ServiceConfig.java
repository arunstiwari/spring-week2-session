package com.sapient.springsession.config;

import com.sapient.springsession.repository.repository.OrderRepository;
import com.sapient.springsession.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

//    @Autowired
//    private OrderRepository orderRepository;

//    @Bean(initMethod = "init", destroyMethod = "destroy")
    @Bean
    public IOrderService orderService(){
        return new OrderService();
    }

    @Bean
    public PaymentService paymentService(){
        return new PaymentService();
    }

    @Bean
    public IShippingService generalShippingService(){
        return new GeneralShippingService();
    }

    @Bean
    public IShippingService primeShippingService(){
        return new PrimeShippingService();
    }
}
