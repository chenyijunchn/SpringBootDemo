package com.example.setbanner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * FileName:SetbannerApplicationTest
 * Author:Jane
 * Date:2021/8/2216:13
 * Description:get application.yml value
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class propertTest {
    @Value("${age}")
    private int age;

    @Value("${name}")
    private String name;

    @Test
    public void getAge() {
        System.out.println(age);
    }
    @Test
   public void getName() {
        System.out.println(name);
    }
}