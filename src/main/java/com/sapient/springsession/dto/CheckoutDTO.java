package com.sapient.springsession.dto;

import com.sapient.springsession.model.CreditCardInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckoutDTO {
    private long cartId;
    private CreditCardInfo creditCardInfo;
}
