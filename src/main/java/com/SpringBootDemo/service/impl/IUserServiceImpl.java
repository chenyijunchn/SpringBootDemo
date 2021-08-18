package com.SpringBootDemo.service.impl;

import com.SpringBootDemo.dao.IUserDao;
import com.SpringBootDemo.model.User;
import com.SpringBootDemo.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class IUserServiceImpl implements IUserService {
	private static final Logger LOGGER = LoggerFactory.getLogger(IUserServiceImpl.class);

	@Autowired
	private IUserDao userDao;

	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}

	@Override
	public int insert(User user) {
		return userDao.insert(user);
	}

	@Override
	public int delete(String userId) {
		return userDao.delete(userId);
	}

	@Override
	public int update(User user) {
		User userOutVo = null;
		if (user != null && !StringUtils.isEmpty(user.getUserId())) {
			userOutVo = userDao.find(user.getUserId());
			if (userOutVo != null) {
				LOGGER.info("用户名：" + user.getUserName());
				userOutVo.setUserName(user.getUserName());
				userOutVo.setPassword(user.getPassword());
			}
		}
		return userDao.update(userOutVo);
	}

	@Override
	public User find(String userId) {
		return userDao.find(userId);
	}

}
