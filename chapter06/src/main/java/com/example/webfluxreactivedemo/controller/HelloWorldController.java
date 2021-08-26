package com.example.webfluxreactivedemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * FileName:HelloWorldController
 * Author:Jane
 * Date:2021/8/269:58
 * Description:
 */
@RestController
public class HelloWorldController {
    @GetMapping("/helloworld")
    public Mono<String> helloworld(){
        return Mono.just("This is WebFlux demo");
    }
}
