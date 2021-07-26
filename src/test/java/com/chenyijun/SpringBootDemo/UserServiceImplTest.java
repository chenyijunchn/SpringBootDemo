/**
 * 
 */
package com.chenyijun.SpringBootDemo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.SpringBootDemo.model.User;
import com.SpringBootDemo.service.impl.UserServiceImpl;

/**
 * @author yijun
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)

public class UserServiceImplTest {

	@Autowired
	UserServiceImpl userService;

	@Test
	@Transactional
	public void getUserListTest() {
		List<User> x = userService.getAll();
		for (User temp : x) {// foreach 遍历
			System.out.print(temp.getUserId() + temp.getUserName() + temp.getPassword() + "; ");
		}

	}

	@Test
	@Transactional
	public void addUserTest() {

		User user = new User();
		user.setUserId("000003");
		user.setUserName("Cindy");
		user.setPassword("123456");
		int x = userService.insert(user);

	}

}
