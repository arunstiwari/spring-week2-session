package com.sapient.springsession.service;

import com.sapient.springsession.model.CreditCardInfo;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public boolean initiatePayment(CreditCardInfo creditCardInfo) {
        return true;
    }
}
