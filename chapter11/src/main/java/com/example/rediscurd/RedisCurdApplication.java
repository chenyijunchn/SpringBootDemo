package com.example.rediscurd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class RedisCurdApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisCurdApplication.class, args);
    }

}
