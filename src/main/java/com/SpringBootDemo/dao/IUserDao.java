package com.SpringBootDemo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.SpringBootDemo.model.User;

@Repository
public interface IUserDao {
	List<User> getAll();

	User find(String userId);

	int insert(User user);

	int delete(String userId);

	int update(User user);

}