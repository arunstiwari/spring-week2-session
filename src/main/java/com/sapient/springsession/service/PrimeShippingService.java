package com.sapient.springsession.service;

import com.sapient.springsession.model.Order;
import com.sapient.springsession.model.ShippingInfo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("primeShipping")
public class PrimeShippingService implements IShippingService {
    @Override
    public ShippingInfo shipOrder(Order order) {
        System.out.println("I am in PrimeShippingService");
        return null;
    }
}
