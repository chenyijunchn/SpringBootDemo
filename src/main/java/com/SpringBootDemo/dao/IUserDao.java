package com.SpringBootDemo.dao;

import java.util.List;

import com.SpringBootDemo.model.User;

public interface IUserDao {
	List<User> getAll();

	User find(String userId);

	int insert(User user);

	int delete(String userId);

	int update(User user);
}