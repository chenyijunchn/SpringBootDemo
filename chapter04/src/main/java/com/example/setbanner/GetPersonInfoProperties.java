package com.example.setbanner;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * FileName:GetPersonInfoProperties
 * Author:Jane
 * Date:2021/8/2217:19
 * Description:get preson Info properties
 */
@Component
@ConfigurationProperties(prefix = "personinfo")
public class GetPersonInfoProperties {
    private String name;
    private int age;
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public int getAge(){
        return  age;
    }
    public void setAge(int age){
        this.age=age;
    }

}
