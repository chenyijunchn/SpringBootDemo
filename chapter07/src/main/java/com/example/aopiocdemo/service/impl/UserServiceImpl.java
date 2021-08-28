package com.example.aopiocdemo.service.impl;

import com.example.aopiocdemo.entity.User;
import com.example.aopiocdemo.repository.UserRepository;
import com.example.aopiocdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author longzhonghua
 * @data 2019/01/27 22:00
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(int id) {
        return userRepository.findById(id);
    }
}
