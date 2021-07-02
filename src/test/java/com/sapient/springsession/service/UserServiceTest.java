package com.sapient.springsession.service;

import com.sapient.springsession.model.Address;
import com.sapient.springsession.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@DataJpaTest
//@AutoConfigureTestDatabase(replace = Replace.NONE)
@Transactional
@SpringBootTest
class UserServiceTest {

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Autowired
    private EntityManager entityManager;

    private TransactionTemplate transactionTemplate;

    @Autowired
    private UserService userService;

    @BeforeEach
    public void setup(){
        transactionTemplate = new TransactionTemplate(transactionManager);
    }

    @Test
    public void addUser(){
        User user1 = transactionTemplate.execute(status ->{
            User user = new User();
            user.setId(123);
            user.setEmail("user23@xyz.com");
            List<Address> addresses = new ArrayList<>();
            addresses.add(new Address(234, "city1","12334444",user));
            user.setAddress(addresses);
            entityManager.persist(user);
            return user;
        });

        System.out.println("user1 = " + user1);

        User founduser = entityManager.find(User.class, user1.getId());
        System.out.println("founduser = " + founduser);
    }


    @Test
    public void testCreationOfNewUser(){
        User user = new User();
//        user.setId(123);
        user.setEmail("user23@xyz.com");
        List<Address> addresses = new ArrayList<>();
        addresses.add(new Address( "city1","12334444",user));
        user.setAddress(addresses);
        User user1 = userService.addUser(user);
        System.out.println("user1 = " + user1);

        List<User> users = userService.fetchAllUsers();
        System.out.println("users.size() = " + users.size());


    }


}