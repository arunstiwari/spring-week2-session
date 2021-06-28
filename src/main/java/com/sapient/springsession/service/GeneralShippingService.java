package com.sapient.springsession.service;

import com.sapient.springsession.model.Order;
import com.sapient.springsession.model.ShippingInfo;

public class GeneralShippingService implements IShippingService {

    @Override
    public ShippingInfo shipOrder(Order order) {
        System.out.println("I am in GeneralShippingService");
        return null;
    }
}
