package com.toy4codes.website.framework.generic.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public interface GenericHibernateDao<T> {

	// save -----------------------------------------------------------------
	public Serializable save(T entity);

	// delete ---------------------------------------------------------------
	public boolean delete(T entity);

	public boolean deleteAll(Collection<T> entities);

	// update ---------------------------------------------------------------
	public boolean update(T entity);

	// query ----------------------------------------------------------------
	public T load(Class<T> entityClass, Serializable id);

	public List<T> loadAll(Class<T> entityClass);

	// others ---------------------------------------------------------------
	public void flush();

	public void clear();

}
