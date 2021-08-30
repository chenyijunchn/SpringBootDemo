package com.example.ormdemo.entity;

import lombok.Data;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * FileName:UserJDBCTemplate
 * Author:Jane
 * Date:2021/8/3015:49
 * Description:实例25 用JDBCTemplate实现数据增删改查，实体类
 */
@Data
public class UserJDBCTemplate implements RowMapper<UserJDBCTemplate> {
    private int id;
    private String username;
    private String password;

    @Override
    public UserJDBCTemplate mapRow(ResultSet resultSet,int i)throws SQLException{
        UserJDBCTemplate userJDBCTemplate=new UserJDBCTemplate();
        userJDBCTemplate.setId(resultSet.getInt("user_id"));
        userJDBCTemplate.setUsername(resultSet.getString("user_name"));
        userJDBCTemplate.setPassword(resultSet.getString("password"));
        return userJDBCTemplate;
    }
}
