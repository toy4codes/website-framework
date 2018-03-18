package com.toy4codes.website.framework.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.toy4codes.website.framework.beans.User;
import com.toy4codes.website.framework.utils.SpringContainerLayerJUnitSuite;

public class UserServiceTest extends SpringContainerLayerJUnitSuite {

	@Autowired
	private UserService userService;

	@Test
	public void curdTest() {

		User user = new User();
		user.setEmail("example@email.com");
		user.setPassword("password");

		// save
		Assert.assertTrue("save user fail", userService.save(user) == true);

		// update
		user.setPassword("newPassword");
		Assert.assertTrue("update user fail", userService.update(user) == true);

		// load && loadAll
		Assert.assertTrue("load user fail", userService.load(user.getId()) != null);
		Assert.assertTrue("load all user fail", userService.loadAll() != null);

		// delete
		Assert.assertTrue("delete user fail", userService.delete(user) == true);

	}

}
