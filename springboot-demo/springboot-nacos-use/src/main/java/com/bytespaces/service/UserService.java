package com.bytespaces.service;

import com.bytespaces.dao.UserRepository;
import com.bytespaces.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {this.userRepository = userRepository;}

    public User findById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }
}