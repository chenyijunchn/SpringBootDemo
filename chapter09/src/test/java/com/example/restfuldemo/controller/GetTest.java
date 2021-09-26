package com.example.restfuldemo.controller;


import com.example.restfuldemo.entity.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


@SpringBootTest
@RunWith(SpringRunner.class)
public class GetTest {
    @Autowired
    RestTemplateBuilder restTemplateBuilder;
    //返回String,不带参数
    @Test
    public void nparameters() {
        RestTemplate client= restTemplateBuilder.build();
        ResponseEntity<String> responseEntity = client.getForEntity("http://localhost:8080/getarticle1", String.class);
        System.out.println(responseEntity.getBody());
    }
    @Test
    public void withparameters1() {
        RestTemplate client= restTemplateBuilder.build();
        ResponseEntity<String> responseEntity = client.getForEntity("http://localhost:8080/getparameter?id={1}", String.class, 12);
        System.out.println(responseEntity.getBody());
    }
    //返回String,带参数
    @Test
    public void withparameters2() {
        RestTemplate client= restTemplateBuilder.build();
        Map<String, String> map = new HashMap<>();
        map.put("name", "getparameter");
        ResponseEntity<String> responseEntity = client.getForEntity("http://localhost:8080/getparameter?title={name}&id=11", String.class, map);
        System.out.println(responseEntity.getBody());
    }
    @Test
    public void restUser1() {
        RestTemplate client= restTemplateBuilder.build();
        ResponseEntity<Article> responseEntity = client.getForEntity("http://localhost:8080/getarticle1", Article.class);
        System.out.println(responseEntity.getBody().getId());
        System.out.println(responseEntity.getBody().getTitle());
    }
    @Test
    public void  getForObject() {
        RestTemplate client= restTemplateBuilder.build();
        Article user = client.getForObject("http://localhost:8080/getarticle1", Article.class);
        System.out.println(user.getTitle());
    }

}