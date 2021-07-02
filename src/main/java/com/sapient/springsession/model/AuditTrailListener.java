package com.sapient.springsession.model;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

@Slf4j
public class AuditTrailListener {

    @PrePersist
    private void beforeAnyUpdate(User user){
        log.info("About to add a user");
    }

    @PostPersist
    private void afterAnyUpdate(User user){
        log.info("Added a user {}",user.getId());
    }

    @PostLoad
    private void afterLoad(User user){
        log.info("User loaded from database {}",user);
    }
}
