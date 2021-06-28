package com.sapient.springsession.config;

import com.sapient.springsession.repository.repository.OrderRepository;
import com.sapient.springsession.service.IOrderService;
import com.sapient.springsession.service.OrderService;
import com.sapient.springsession.service.PaymentService;
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
}
