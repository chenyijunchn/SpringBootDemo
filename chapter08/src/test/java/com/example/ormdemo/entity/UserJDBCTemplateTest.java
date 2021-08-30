package com.example.ormdemo.entity;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * FileName:UserJDBCTemplateTest
 * Author:Jane
 * Date:2021/8/3016:09
 * Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class UserJDBCTemplateTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void saveUserTest() throws Exception{
        String sql="insert into tb_user (user_id,user_name,password) values ('5','JDBCUser','123433')";
        int rows=jdbcTemplate.update(sql);
        System.out.println(rows);
    }

    @Test
    public void getUserByName()throws Exception{
        String name="Jane";
        String sql="select * from tb_user where user_name =?";
        List<UserJDBCTemplate> list=jdbcTemplate.query(sql,new UserJDBCTemplate(),new Object[]{name});
        for (UserJDBCTemplate eachuser:list){
            System.out.println(eachuser);
        }
    }

    @Test
    public void deleteUserById() throws Exception{
        String sql="delete from tb_user where user_id =?";
        int rows=jdbcTemplate.update(sql,5);
        System.out.println(rows);
    }
}