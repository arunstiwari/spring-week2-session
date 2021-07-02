package com.sapient.springsession.service;

import com.sapient.springsession.model.*;
import com.sapient.springsession.validator.OrderValidator;
import com.sapient.springsession.validator.ProductValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
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

    @Autowired
    private CartService cartService;

    public CheckoutResponse checkout(long cartId, CreditCardInfo creditCardInfo) throws InterruptedException {
        CheckoutResponse response = new CheckoutResponse();
        /**
         * 0 First get the cartInfo from the database
         * 0.5 First create an Order
         * 1. Validate Order
         * 1.1 Update the OrderStatus with ORDER_VALIDATED
         * 2. Once order is validated and is successfull, then PaymentProcessing has to be started
         * 3. Once PaymentIsSuccessful, then update the OrderStatus with ORDER_CONFIRMED
         * 3.5 Delete the Cart as well, as the Cart is converted into a Proper transaction
         * 4. Once Order is confirmed, then I will notify ShippingService
         * 5. Once Order is confirmed, then I will notify Customer
         *
         */
        Cart cart = cartService.fetchCartById(cartId);

        Order order = new Order();
        cart.getCartItems().stream().forEach(cartItem -> {
            OrderItem item = new OrderItem();
            item.setProductId(cartItem.getProductId());
            item.setPrice(cartItem.getPrice());
            item.setQuantity(cartItem.getQuantity());
            item.setOrder(order);
            order.addOrderItem(item);
            log.info(" order: {}", order);
        });
        order.setStatus(OrderStatus.INITIATED);
        Order persistedOrder = orderService.placeOrder(order);
        Thread.sleep(20000);
        response.setOrderNo(String.valueOf(persistedOrder.getId()));
        boolean isValidated = orderValidator.validate(persistedOrder);

        if (isValidated){
            persistedOrder.setStatus(OrderStatus.VALIDATED);
            orderService.updateOrderStatus(persistedOrder);
            Thread.sleep(10000);
            boolean isPaymentSuccessfull = paymentService.initiatePayment(creditCardInfo);
            if (isPaymentSuccessfull){
                order.setStatus(OrderStatus.CONFIRMED);
               Order updatedOrder = orderService.updateOrderStatus(order);
                Thread.sleep(10000);
              boolean isCartDeleted =  cartService.deleteCart(cartId);
                log.info(" isCartDeleted: {}",isCartDeleted);
                Thread.sleep(10000);
                shippingService.notifyNewOrder(updatedOrder);
                mailService.sendMail(String.valueOf(cart.getId()));
                response.setStatus(OrderStatus.CONFIRMED.name());
                response.setMessage("Order has been processed successfully");
            }else{
                order.setStatus(OrderStatus.NOT_CONFIRMED);
                orderService.updateOrderStatus(persistedOrder);
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
