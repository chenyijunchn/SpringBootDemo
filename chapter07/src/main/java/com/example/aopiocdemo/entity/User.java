package com.example.aopiocdemo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * FileName:User
 * Author:Jane
 * Date:2021/8/2711:27
 * Description:
 */
@Data
public class User implements Serializable {
    private int id;
    private String name;
}
