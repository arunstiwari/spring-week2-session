package com.sapient.springsession.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CheckoutResponse {
    private String status;
    private String message;
    private String orderNo;
}
