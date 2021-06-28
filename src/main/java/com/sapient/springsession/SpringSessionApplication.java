package com.sapient.springsession;

import com.sapient.springsession.config.RepositoryConfig;
import com.sapient.springsession.config.ServiceConfig;
import com.sapient.springsession.model.Order;
import com.sapient.springsession.model.PaymentInfo;
import com.sapient.springsession.repository.repository.OrderRepository;
import com.sapient.springsession.service.IOrderService;
import com.sapient.springsession.service.OrderService;
import com.sapient.springsession.service.PaymentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//@SpringBootApplication
public class SpringSessionApplication {

    public static void main(String[] args) {

//        SpringApplication.run(SpringSessionApplication.class, args);

        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ServiceConfig.class, RepositoryConfig.class);
  context.registerShutdownHook();
        //        IOrderService orderService = (IOrderService) context.getBean("orderService");
        IOrderService orderService = context.getBean(IOrderService.class);
        PaymentService paymentService = context.getBean(PaymentService.class);
//        IOrderService orderService = new OrderService(new OrderRepository());
        System.out.println("orderService = " + orderService);
        Order order = orderService.getOrder("order-123");
        System.out.println("order = " + order);
        paymentService.initiatePayment(new PaymentInfo());

        orderService.placeOrder(new Order());
    }

}
