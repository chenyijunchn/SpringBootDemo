package com.example.ormdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class OrmDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrmDemoApplication.class, args);
    }

}
