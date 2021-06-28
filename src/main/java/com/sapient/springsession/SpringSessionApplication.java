package com.sapient.springsession;

import com.sapient.springsession.model.Order;
import com.sapient.springsession.model.PaymentInfo;
import com.sapient.springsession.service.IOrderService;
import com.sapient.springsession.service.PaymentService;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Map;
import java.util.Properties;

@SpringBootApplication
public class SpringSessionApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringSessionApplication.class);
        app.setBannerMode(Banner.Mode.OFF);

        Properties props = new Properties() ;
        props.setProperty("logging.level.org.springframework","DEBUG");
        app.setDefaultProperties(props);
        app.run(args);
//        ConfigurableApplicationContext context = SpringApplication.run(SpringSessionApplication.class);
//        context.setD
////        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ServiceConfig.class, RepositoryConfig.class);
//  context.registerShutdownHook();
//        IOrderService orderService = context.getBean(IOrderService.class);
//        PaymentService paymentService = context.getBean(PaymentService.class);
//        System.out.println("orderService = " + orderService);
//        Order order = orderService.getOrder("order-123");
//        System.out.println("order = " + order);
//        paymentService.initiatePayment(new PaymentInfo());
//
//        orderService.placeOrder(new Order());
    }

}
