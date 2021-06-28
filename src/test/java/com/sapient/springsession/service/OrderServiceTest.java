package com.sapient.springsession.service;

import com.sapient.springsession.model.Order;
import com.sapient.springsession.model.ShippingInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class OrderServiceTest {
    @Mock
    private IShippingService shippingService;

    @InjectMocks
    private OrderService orderService;

    @Test
    void placeOrder() {
        Order order = new Order();
        when(shippingService.shipOrder(order)).thenReturn(new ShippingInfo());
        Order placedOrder = orderService.placeOrder(order);
        assertNull(placedOrder);
    }

    @Test
    void placeOrderShouldThrowAnExceptionDueToMissingShipmentInfo() {
        Order order = new Order();
        when(shippingService.shipOrder(order)).thenThrow(RuntimeException.class);
        Assertions.assertThrows(RuntimeException.class, ()-> orderService.placeOrder(order));
//        Order placedOrder = orderService.placeOrder(order);
//        assertNull(placedOrder);
    }
}