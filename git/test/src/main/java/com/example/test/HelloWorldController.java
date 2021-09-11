package com.example.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @RequestMapping ("/hello")
    public String hello(){
        return "Hello, Spring Boot";
    }


    public void dev(){
        System.out.println("liwenhao");
    }
    
    public void test(){
        System.out.println("chenyijun is silly--3");
    }

    public void tes1t(){
        System.out.println("chenyijun is baby-1");
    }
}
