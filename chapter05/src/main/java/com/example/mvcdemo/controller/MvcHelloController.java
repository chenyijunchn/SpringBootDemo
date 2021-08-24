package com.example.mvcdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * FileName:MvcController
 * Author:Jane
 * Date:2021/8/2316:58
 * Description:controller
 */
@Controller
public class MvcHelloController {
    @RequestMapping("/helloworld")
    public String hellloWorld(Model model)throws Exception{
        model.addAttribute("mav","Hello, Spring Boot! I am mvc");
        return "demoPlates/hello";
    }
}
