/**
 * 
 */
package com.SpringBootDemo.controller;

/**
 * @author yijun
 *
 */
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootDemo.model.User;
import com.SpringBootDemo.service.IUserService;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	IUserService userService;
	@Value("${myenvironment.name}")
	private String environmentname;

	@RequestMapping("/")
	String home() {
		String str=", Hello User";
		str=environmentname+str;
		return str;
	}

	@RequestMapping(value = { "/getUserList" })
	@ResponseBody
	public List<User> getUserList() {
		System.out.println("查询用户信息。。。。。。。。。");
		return userService.getAll();
	}

	@RequestMapping(value = "/getById",method = RequestMethod.GET)
	public ModelAndView getUser(@RequestParam(name = "user_id") String id) {
		// 调用service服务获取对应id的用户对象并返回给前端
		User userModel = userService.find(id);
		ModelAndView mav=new ModelAndView("userview");
		mav.addObject("vuser",userModel);
		return mav;
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
