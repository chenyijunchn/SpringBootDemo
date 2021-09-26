package com.example.restfuldemo.controller;


import com.example.restfuldemo.entity.Article;
import com.example.restfuldemo.exception.BusinessException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ValidationException;

/**
 * @author longzhonghua
 * @createdata 3/18/2019 10:25 PM
 * @description
 */
@RestController
public class TestController {
    @RequestMapping("/BusinessException")
    public String testResponseStatusExceptionResolver(@RequestParam("i") int i){
        if (i==0){
            throw new BusinessException(600,"自定义业务错误");
        }
        throw new ValidationException();
    }

//创建用于测试的API
    @RequestMapping(value = "/getparameter", method = RequestMethod.GET)
    public Article getparameter(Article article) {
        return article;
    }

    @RequestMapping(value = "/getarticle1", method = RequestMethod.GET)
    public Article article1() {
        Article test= new Article();
        test.setBody("body 11111");
        test.setTitle("title 11111");
        return test;
    }

    @RequestMapping(value = "/postarticle", method = RequestMethod.POST)
    public Article postUser(Article article) {
        System.out.println("id:" + article.getId());
        System.out.println("title:" + article.getTitle());
        System.out.println("body:" + article.getBody());
        return article;
    }
    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String post(HttpServletRequest request, @RequestParam(value = "name", required = false) String name,
                       @RequestParam(value = "password", required = false) String password, @RequestParam(value = "id", required = false) Integer id, HttpServletResponse response) {
     response.addHeader("Location", "success?name=" + name + "&id=" + id + "&status=success");
        return "redirect:/success?name=" + name + "&id=" + id + "&status=success";


    }
}
