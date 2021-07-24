/**
 * 
 */
package com.SpringBootDemo.controller;

/**
 * @author yijun
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootDemo.model.User;
import com.SpringBootDemo.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	IUserService userService;

	@RequestMapping("/")
	String home() {
		return "Hello World!";
	}

	@RequestMapping(value = { "/getUserList" }, method = RequestMethod.POST)
	public List<User> getUserList() {
		System.out.println("查询用户信息。。。。。。。。。");
		// ModelAndView mav=new ModelAndView();
		return userService.getAll();
	}

	@RequestMapping(value = { "/addUser" }, method = RequestMethod.POST)
	@ResponseBody
	public void addUser(@RequestBody User user) {
		System.out.println("开始新增。。。。。。。。。。。。。。");
		userService.insert(user);
	}

	@RequestMapping(value = { "/updateUser" }, method = RequestMethod.POST)
	@ResponseBody
	public void updateUser(@RequestBody User user) {
		System.out.println("开始修改信息。。。。。。。。");
		userService.update(user);
	}

	@RequestMapping(value = { "/deleteUser" }, method = RequestMethod.POST)
	@ResponseBody
	public void deleteUser(@RequestParam String id) {
		System.out.println("开始删除信息。。。。。。。。");
		userService.delete(id);
	}
}
