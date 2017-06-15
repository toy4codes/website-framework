package com.toy4codes.website.framework.service;

import java.util.List;

import com.toy4codes.website.framework.beans.User;

public interface UserService {

	public boolean save(User user);
	
	public boolean delete(User user);
	
	public boolean update(User user);
	
	public User load(int id);
	
	public List<User> loadAll();
}
