package com.SpringBootDemo.dao;

import com.SpringBootDemo.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IUserDao {
	List<User> getAll();

	User find(String userId);

	int insert(User user);

	int delete(String userId);

	int update(User user);

}