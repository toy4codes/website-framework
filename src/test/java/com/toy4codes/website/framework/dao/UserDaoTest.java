package com.toy4codes.website.framework.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.toy4codes.website.framework.utils.SpringContainerLayerJUnitSuite;

public class UserDaoTest extends SpringContainerLayerJUnitSuite {

	@Autowired
	private UserDao userDao;

	@Test
	public void findEmailsTest() {
		List<String> emails = userDao.findEmails();
		Assert.assertTrue("find emails fail", emails != null);
	}

}
