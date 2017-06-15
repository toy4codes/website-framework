package com.toy4codes.website.framework.dao.impl;

import java.util.List;

import com.toy4codes.website.framework.beans.User;
import com.toy4codes.website.framework.dao.UserDao;
import com.toy4codes.website.framework.generic.dao.GenericHibernateDaoImpl;

public class UserDaoImpl extends GenericHibernateDaoImpl<User> implements UserDao {

	@Override
	@SuppressWarnings("unchecked")
	public List<String> findEmails() {
		List<String> emails = (List<String>) super.findByNamedQuery("findEmails", (Object[]) null);
		return emails;
	}

}
