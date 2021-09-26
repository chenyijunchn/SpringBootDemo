package com.example.restfuldemo.controller;


import com.example.restfuldemo.entity.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PostTest {
    @Autowired
    RestTemplateBuilder restTemplateBuilder;
    RestTemplate restTemplate = new RestTemplate();
    @Test
    public void postForEntity() {
        //RestTemplate client= restTemplateBuilder.build();
// 封装参数，千万不要替换为Map与HashMap，否则参数无法传递
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
        paramMap.add("title", "longzhiran");
        paramMap.add("body", "body");
        //方法的第一参数表示要调用的服务的地址
        //方法的第二个参数表示上传的参数
        //方法的第三个参数表示返回的消息体的数据类型
        ResponseEntity<Article> responseEntity = restTemplate.postForEntity("http://localhost:8080/postarticle", paramMap, Article.class);
        System.out.println( responseEntity.getBody().getTitle());
    }
    @Test
    public void postForObject() {
        // 封装参数，千万不要替换为Map与HashMap，否则参数无法传递
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
        paramMap.add("title", "longzhiran");
        paramMap.add("body", "body");
        RestTemplate client = restTemplateBuilder.build();
        String response = client.postForObject("http://localhost:8080/postarticle", paramMap, String.class);
        System.out.println(response);
    }

    @Test
    public void postForLocation() {
        // 封装参数，千万不要替换为Map与HashMap，否则参数无法传递
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
        paramMap.add("title", "longzhiran");
        paramMap.add("body", "body");

        RestTemplate client = restTemplateBuilder.build();

        URI response = client.postForLocation("http://localhost:8080/post",paramMap);

         System.out.println(response);
    }



    @Test
    public void postForexchange() {
        // 封装参数，千万不要替换为Map与HashMap，否则参数无法传递
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
        paramMap.add("title", "longzhiran");
        paramMap.add("body", "body");
        RestTemplate client = restTemplateBuilder.build();
        HttpHeaders headers = new HttpHeaders();
        //headers.set("id", "long");
        HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<MultiValueMap<String, Object>>(paramMap,headers);
        ResponseEntity<String> response = client.exchange("http://localhost:8080/postarticle", HttpMethod.POST,httpEntity,String.class,paramMap);
        System.out.println(response.getBody());
    }
    @Test
    public void put() {
        RestTemplate client= restTemplateBuilder.build();
        Article user = new Article();
        user.setTitle("longzhiran");
        client.put("http://localhost:8080/{1}", user, 4);
    }
    @Test
    public void delete() {
        RestTemplate client= restTemplateBuilder.build();
        client.delete("http://localhost:8080/{1}", 4);
    }


}