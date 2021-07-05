package com.sapient.springsession.mongodb.repository;

import com.sapient.springsession.mongodb.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IUserMongodbRepositoryTest {

    @Autowired
    private IUserMongodbRepository repository;
    @Test
    void findUserByName() {

        List<User> userByName = repository.findUserByName("User-2");
        userByName.forEach(user -> System.out.println("user = " + user));
    }

    @Test
    void findUserByAgeBetween() {

        List<User> userByName = repository.findUsersWhereAgeIsBetween(23,32);
        userByName.forEach(user -> System.out.println("user = " + user));
    }

    @Test
    void findUserExcludingId() {

        List<User> userByName = repository.findUserAndExcludeId();
        userByName.forEach(user -> System.out.println("user = " + user));
    }
}