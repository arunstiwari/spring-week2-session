package com.sapient.springsession.service;

import com.sapient.springsession.model.PaymentInfo;
import org.springframework.stereotype.Service;

@Service
public class PaymentService implements IPaymentService{

    @Override
    public boolean initiatePayment(PaymentInfo paymentInfo) {
        return false;
    }
}
