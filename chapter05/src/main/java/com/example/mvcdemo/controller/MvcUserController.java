package com.example.mvcdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.example.mvcdemo.model.User;

/**
 * FileName:MvcUserController
 * Author:Jane
 * Date:2021/8/2411:17
 * Description:User Controller
 */
@Controller
public class MvcUserController {
@GetMapping("/hellouser")
public ModelAndView showUser(){
    User user=new User();
    user.setName("Jane");
    user.setAge(18);
    ModelAndView mav=new ModelAndView("demoPlates/mvcuser");
    mav.addObject("Vuser",user);
    return mav;
}
}
