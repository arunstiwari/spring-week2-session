package com.sapient.springsession.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MailService {

    public void sendMail(String customerId) {
      log.info(" Email has been sent to customer with id {}",customerId);
    }
}
