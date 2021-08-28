package com.example.aopiocdemo.service;

import com.example.aopiocdemo.entity.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * FileName:UserServiceTest
 * Author:Jane
 * Date:2021/8/2816:36
 * Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    void getUserList() {
        List<User> userList=  userService.getUserList();
        for (User user:userList
             ) {
            System.out.println(user.getUser_name()+","+user.getUser_id());

        }
    }

    @Test
    void findUserById() {
        User user=userService.findUserById(2);
        Assert.assertEquals(user.getUser_name(),"Tom");
       // Assert.assertEquals(user.getUser_name(),"Jane");
    }
}