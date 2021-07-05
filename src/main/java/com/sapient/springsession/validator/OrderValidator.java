package com.sapient.springsession.validator;

import com.sapient.springsession.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderValidator {

    public boolean validate(Order order) {
        return true;
    }

    public boolean validateMongodbOrder(com.sapient.springsession.mongodb.model.Order order) {
        return true;
    }
}
