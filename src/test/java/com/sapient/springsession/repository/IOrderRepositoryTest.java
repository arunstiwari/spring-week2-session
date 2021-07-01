package com.sapient.springsession.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sapient.springsession.model.Order;
import com.sapient.springsession.model.OrderItem;
import com.sapient.springsession.model.OrderStatus;
import com.sapient.springsession.model.ShipmentInfo;
import com.sapient.springsession.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@Transactional
class IOrderRepositoryTest {

    @Autowired
    IOrderRepository orderRepository;

    @Autowired
    OrderService orderService;

//    @Transactional
    @Test
    public  void orderDataShouldPersist() throws JsonProcessingException {
        Order order = new Order();
        OrderItem orderItem = new OrderItem();
        String productId = "product-1";
        orderItem.setItemName(productId);
        double itemPrice = 5.0;
        orderItem.setItemPrice(itemPrice);
        int itemQuantity = 2;
        orderItem.setItemQuantity(itemQuantity);
        order.addOrderItem(orderItem);

        ShipmentInfo shipmentInfo = new ShipmentInfo();
        shipmentInfo.setShipmentAddress("Gurugram");
        order.setShipmentInfo(shipmentInfo);

        ObjectMapper objectMapper = new ObjectMapper();
        String orderAsJson = objectMapper.writeValueAsString(order);
        System.out.println("orderAsJson = " + orderAsJson);
//        Order savedOrder = orderRepository.save(order);
        Order savedOrder = orderService.persisteOrder(order,OrderStatus.INITIATED);
        System.out.println("savedOrder = " + savedOrder);
//        entityManager.getTransaction().begin();
//         entityManager.persist(order);

//         entityManager.getTransaction().commit();
//        Optional<Order> orderById = orderRepository.findById(savedOrder.getId());
//        if (orderById.isPresent()){
//            System.out.println("orderById = " + orderById);
//        }else {
//            System.out.println("Order by id is not successfull");
//        }
    }
}