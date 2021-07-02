package com.sapient.springsession.service;

import com.sapient.springsession.model.User;
import com.sapient.springsession.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;

    @Transactional
    public User addUser(User user){
        user.getAddress().stream().forEach(address -> address.setUser(user));
        User save = userRepository.save(user);
        return save;
    }

    public List<User> fetchAllUsers(){
        return (List<User>) userRepository.findAll();
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
}
