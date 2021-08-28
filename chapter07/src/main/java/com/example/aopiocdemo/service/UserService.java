package com.example.aopiocdemo.service;
import com.example.aopiocdemo.entity.User;
import java.util.List;

public interface UserService {
     List<User> getUserList();
     User findUserById(int id);
}
