package com.example.aopiocdemo.repository;

import com.example.aopiocdemo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
// SpringJUnit支持，由此引入Spring-Test框架支持！
//启动整个spring的工程
@SpringBootTest
//@DataJpaTest
@Transactional
//@Rollback(false)
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Test
  public void testQuery() {
   // 查询操作
  List<User> list = userRepository.findAll();
        for (User user : list) {
            System.out.println(user);
        }
   }
    @Test
    public void testRollBank() {
        User user=new User();
        user.setUser_name("Jerry");
        user.setUser_id(3);
        userRepository.save(user);
    }
}