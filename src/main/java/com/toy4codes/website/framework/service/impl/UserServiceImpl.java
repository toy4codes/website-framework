package com.toy4codes.website.framework.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.toy4codes.website.framework.beans.User;
import com.toy4codes.website.framework.dao.UserDao;
import com.toy4codes.website.framework.service.UserService;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public boolean save(User user) {
		return userDao.save(user) != null ? true : false;
	}

	@Override
	public boolean delete(User user) {
		return userDao.delete(user);
	}

	@Override
	public boolean update(User user) {
		return userDao.update(user);
	}

	@Override
	public User load(int id) {
		return userDao.load(User.class, id);
	}

	@Override
	public List<User> loadAll() {
		return userDao.loadAll(User.class);
	}

}
