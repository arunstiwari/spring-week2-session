package com.sapient.springsession.mongodb.repository;

import com.sapient.springsession.mongodb.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserMongodbRepository extends MongoRepository<User, String> {

    @Query("{'name': ?0}")
    List<User> findUserByName(String name);


    @Query("{'age': {$gt: ?0, $lt: ?1}}")
    List<User> findUsersWhereAgeIsBetween(int ageGt, int ageLt);

    @Query(value = "{}")
    List<User> findUserAndExcludeId();
}
