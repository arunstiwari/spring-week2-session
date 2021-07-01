package com.sapient.springsession.service;

import com.sapient.springsession.model.Cart;
import com.sapient.springsession.model.CheckoutResponse;
import org.springframework.stereotype.Service;

@Service
public class BasketService {

    public CheckoutResponse checkout(Cart cart) {
        /**
         * 1. Validate Order
         * 2. Once order is validated and is successfull, then PaymentProcessing has to be started
         * 3. Once PaymentIsSuccessful, then Confirm the Order
         * 4. Once Order is confirmed, then I will notify ShippingService
         * 5. Once Order is confirmed, then I will notify Customer
         *
         */
        boolean isValidated = orderValidator.validate(cart.getOrder());
        if (isValidated){
            boolean isPaymentSuccessfull = paymentService.initiatePayment(cart.getCreditCardInfo());
            if (isPaymentSuccessfull){
                String orderId = orderService.confirmOrder(cart.getOrder());
            }
        }

        return null;
    }
}
