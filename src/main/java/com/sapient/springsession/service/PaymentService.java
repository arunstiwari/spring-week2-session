package com.sapient.springsession.service;

import com.sapient.springsession.model.PaymentInfo;

public class PaymentService implements IPaymentService{

    @Override
    public boolean initiatePayment(PaymentInfo paymentInfo) {
        return false;
    }
}
