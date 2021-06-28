package com.sapient.springsession.service;

import com.sapient.springsession.model.Order;
import com.sapient.springsession.model.ShippingInfo;
import com.sapient.springsession.repository.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
@Slf4j
public class OrderService implements IOrderService {
//   private static Logger log = LoggerFactory.getLogger(OrderService.class);
    private OrderRepository orderRepository;
    private IShippingService shippingService;

//    public OrderService(OrderRepository orderRepository) {
//        this.orderRepository = orderRepository;
//    }

    @PostConstruct
    public void init(){
        Order order = new Order();
        order.getId();
        order.setCutomerId("fdhhdf");
        System.out.println("This method will be invoked once the object of this class is initialized");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("This method will be invoked before the object is destroyed");
    }

    @Override
    public Order getOrder(String orderId) {
        log.info(" orderRepository: {}, and name: {}",orderRepository, "abc");
//        System.out.println("orderRepository = " + orderRepository);
        return orderRepository.getOrderId(orderId);
    }

    @Override
    public Order placeOrder(Order order) {
        ShippingInfo shippingInfo = shippingService.shipOrder(order);
        if (shippingInfo==null){
            throw new RuntimeException("Shipping Info is missing");
        }
        return null;
    }


    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Autowired
    @Qualifier("primeShipping")
    public void setShippingService(IShippingService shippingService) {
        this.shippingService = shippingService;
    }
}
