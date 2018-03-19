package com.toy4codes.website.framework.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.toy4codes.website.framework.beans.User;
import com.toy4codes.website.framework.service.UserService;

public class UserAction extends BootstrapDatagridActionSupport {

	private static final long serialVersionUID = -5398444012034022391L;

	private User user;

	@Autowired
	private UserService userService;

	@Override
	protected String getEntityName() {
		return User.class.getSimpleName();
	}
	
	public String save() {
		return userService.save(user) ? SUCCESS : ERROR;
	}

	public String delete() {
		return userService.delete(user) ? SUCCESS : ERROR;
	}

	public String update() {
		return userService.update(user) ? SUCCESS : ERROR;
	}

	public String load() {
		user = userService.load(user.getId());
		return user != null ? SUCCESS : ERROR;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
