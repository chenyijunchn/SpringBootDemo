package com.SpringBootDemo.service;

import java.util.List;

import com.SpringBootDemo.model.User;

public interface IUserService {
	List<User> getAll();

	int insert(User user);

	int delete(String userId);

	int update(User user);

	User find(String userId);

}
