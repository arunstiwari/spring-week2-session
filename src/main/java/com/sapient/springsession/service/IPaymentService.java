package com.sapient.springsession.service;

import com.sapient.springsession.model.PaymentInfo;

public interface IPaymentService  {

    boolean initiatePayment(PaymentInfo paymentInfo);
}
