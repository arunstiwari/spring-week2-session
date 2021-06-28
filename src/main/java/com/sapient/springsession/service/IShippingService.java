package com.sapient.springsession.service;

import com.sapient.springsession.model.Order;
import com.sapient.springsession.model.ShippingInfo;

public interface IShippingService {
    ShippingInfo shipOrder(Order order);
}
