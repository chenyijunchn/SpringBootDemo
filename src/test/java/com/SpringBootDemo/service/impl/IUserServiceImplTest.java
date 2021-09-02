package com.SpringBootDemo.service.impl;

import com.SpringBootDemo.model.User;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * FileName:IUserServiceImplTest
 * Author:Jane
 * Date:2021/9/215:39
 * Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class IUserServiceImplTest extends TestCase {

    @Autowired
    IUserServiceImpl iUserService;

    @Test
    @Transactional
    public void getUserListTest() {
        List<User> x = iUserService.getAll();
        for (User temp : x) {// foreach 遍历
            System.out.print(temp.getUserId() + temp.getUserName() + temp.getPassword() + "; ");
        }
    }

    @Test
    @Transactional
    public void testInsert() {
        User user = new User();
        user.setUserId("000003");
        user.setUserName("Cindy");
        user.setPassword("123456");
        int x = iUserService.insert(user);
        Assert.assertEquals(x,1);
    }

    @Test
    @Transactional
    public void testDelete() {
        int x=iUserService.delete("000002");
        Assert.assertEquals(x,1);
    }

    @Test
    @Transactional
    public void testUpdate() {
        User user = new User();
        user.setUserId("000003");
        user.setUserName("Cindy");
        user.setPassword("123456");
        int x=iUserService.update(user);
        Assert.assertEquals(x,1);
    }

    @Test
    @Transactional
    public void testFind() {
        User user=iUserService.find("000001");
        Assert.assertEquals(user.getUserName(),"Jane");
    }
}