package com.toy4codes.website.framework.dao;

import java.util.List;

import com.toy4codes.website.framework.beans.User;
import com.toy4codes.website.framework.generic.dao.GenericHibernateDao;

public interface UserDao extends GenericHibernateDao<User>{

	public List<String> findEmails();
}
