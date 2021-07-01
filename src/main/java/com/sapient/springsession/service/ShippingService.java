package com.sapient.springsession.service;

import com.sapient.springsession.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ShippingService {

    public void notifyNewOrder(Order order) {
      log.info("Received new order {}",order);
    }
}
