/**
 * 
 */
package com.chenyijun.SpringBootDemo;

import com.SpringBootDemo.model.User;
import com.SpringBootDemo.service.impl.IUserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author yijun
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(value={"mybatis-config.xml"})
public class IUserServiceImplTest {

	@Autowired
	IUserServiceImpl userService;

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
