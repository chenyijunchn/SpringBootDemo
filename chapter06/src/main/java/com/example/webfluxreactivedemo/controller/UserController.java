package com.example.webfluxreactivedemo.controller;

import com.example.webfluxreactivedemo.Entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
    *FileName:UserController
    *Author:Jane
    *Date:2021/8/2610:08
    *Description:
*/
@RestController
@RequestMapping(path="/user")
public class UserController {
    Map<Long, User> users =new HashMap<>();

    @PostConstruct
    public void init() throws Exception{
        users.put(Long.valueOf(1),new User(1,"Jane",26));
        users.put(Long.valueOf(2),new User(2,"Jerry",30));
    }

    /*
    获取所有用户
     */
    @GetMapping("/list")
    public Flux<User> getAll(){return Flux.fromIterable(users.entrySet().stream().map(entry->entry.getValue()).collect(Collectors.toList()));}

    /*
    获取单个用户
     */
    @GetMapping("/{id}")
    public Mono<User> getUser(@PathVariable Long id){
        return Mono.justOrEmpty(users.get(id));
    }

    /*
    创建用户
     */
    @PostMapping("")
    public Mono<ResponseEntity<String>> addUser(User  user){
        users.put(user.getId(),user);
        return Mono.just(new ResponseEntity<>("add success", HttpStatus.CREATED));
    }

    /*
    修改用户
     */
    @PostMapping("/{id}")
    public Mono<ResponseEntity<User>> putUser(@PathVariable Long id, User  user){
        user.setId(id);
        users.put(id,user);
        return Mono.just(new ResponseEntity<>(user, HttpStatus.CREATED));
    }

    /*
    删除用户
     */
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<String>> deleteUser(@PathVariable Long id){
        users.remove(id);
        return Mono.just(new ResponseEntity<>("delete success", HttpStatus.ACCEPTED));
    }
}
