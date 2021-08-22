package com.example.setbanner;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * FileName:CoExample
 * Author:Jane
 * Date:2021/8/2217:36
 * Description:get application.properties value
 */
@Data
@Component
@ConfigurationProperties(prefix = "com.example.setbanner")
public class CoExample {
    private String name;
    private int age;
    private List<String> address;
}
