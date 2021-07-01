package com.sapient.springsession.service;

import com.sapient.springsession.model.Cart;
import com.sapient.springsession.model.CheckoutResponse;
import com.sapient.springsession.model.Order;
import com.sapient.springsession.model.OrderStatus;
import com.sapient.springsession.validator.OrderValidator;
import com.sapient.springsession.validator.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasketService {

    @Autowired
    private OrderValidator orderValidator;
    @Autowired
    private PaymentService paymentService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ShippingService shippingService;

    @Autowired
    private MailService mailService;


    public CheckoutResponse checkout(Cart cart) {
        CheckoutResponse response = new CheckoutResponse();
        /**
         * 1. Validate Order
         * 1.1 Persist Order
         * 2. Once order is validated and is successfull, then PaymentProcessing has to be started
         * 3. Once PaymentIsSuccessful, then Confirm the Order
         * 4. Once Order is confirmed, then I will notify ShippingService
         * 5. Once Order is confirmed, then I will notify Customer
         *
         */
        Order order = orderService.persisteOrder(cart.getOrder(), OrderStatus.INITIATED);
        response.setOrderNo(order.getOrderId());
        boolean isValidated = orderValidator.validate(order);
        if (isValidated){
            order.setStatus(OrderStatus.VALIDATED);
            orderService.updateOrderStatus(order);
            boolean isPaymentSuccessfull = paymentService.initiatePayment(cart.getCreditCardInfo());
            if (isPaymentSuccessfull){
                order.setStatus(OrderStatus.CONFIRMED);
                orderService.updateOrderStatus(order);

                shippingService.notifyNewOrder(order);
                mailService.sendMail(cart.getCustomerId());
                response.setStatus(OrderStatus.CONFIRMED.name());
                response.setMessage("Order has been processed successfully");
            }else{
                order.setStatus(OrderStatus.NOT_CONFIRMED);
                orderService.updateOrderStatus(order);
                response.setMessage("Payment Failed");
                response.setStatus(OrderStatus.NOT_CONFIRMED.name());
            }
        }else{
            response.setStatus(OrderStatus.NOT_CONFIRMED.name());
            response.setMessage("Few Items are not available");
        }
        return response;
    }
}
