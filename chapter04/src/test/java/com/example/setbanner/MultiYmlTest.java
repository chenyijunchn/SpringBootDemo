package com.example.setbanner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * FileName:SetbannerApplicationTest
 * Author:Jane
 * Date:2021/8/2216:13
 * Description:get different yml value
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MultiYmlTest {

    @Value("${myenvironment.name}")
    private String name;

    @Test
    public void getMyEnvironment() {
        System.out.println(name);
    }

}