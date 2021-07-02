package com.sapient.springsession.repository;

import com.sapient.springsession.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends CrudRepository<User, Long> {
}
