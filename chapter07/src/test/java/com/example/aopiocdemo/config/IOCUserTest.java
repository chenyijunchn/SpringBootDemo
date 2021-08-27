package com.example.aopiocdemo.config;

import com.example.aopiocdemo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * FileName:IOCUserTest
 * Author:Jane
 * Date:2021/8/2711:31
 * Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class IOCUserTest {
@Autowired
    private ApplicationContext applicationContext;
@Test
    public void testUserIoc(){
    User user=(User) applicationContext.getBean("user1");
    System.out.println(user);
}
}
