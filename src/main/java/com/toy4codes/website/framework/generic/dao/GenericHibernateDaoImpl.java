package com.toy4codes.website.framework.generic.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class GenericHibernateDaoImpl<T> extends HibernateDaoSupport implements GenericHibernateDao<T> {

	private static final Logger log = Logger.getLogger(GenericHibernateDaoImpl.class);

	// save -----------------------------------------------------------------
	@Override
	public Serializable save(T entity) {
		try {
			return super.getHibernateTemplate().save(entity);
		} catch (DataAccessException e) {
			log.error(e);
			return null;
		}
	}

	// delete ---------------------------------------------------------------
	@Override
	public boolean delete(T entity) {
		try {
			super.getHibernateTemplate().delete(entity);
			return true;
		} catch (DataAccessException e) {
			log.error(e);
			return false;
		}
	}

	@Override
	public boolean deleteAll(Collection<T> entities) {
		try {
			super.getHibernateTemplate().deleteAll(entities);
			return true;
		} catch (DataAccessException e) {
			log.error(e);
			return false;
		}
	}

	// update ---------------------------------------------------------------
	@Override
	public boolean update(T entity) {
		try {
			super.getHibernateTemplate().update(entity);
			return true;
		} catch (DataAccessException e) {
			log.error(e);
			return false;
		}
	}

	// query ----------------------------------------------------------------
	@Override
	public T load(Class<T> entityClass, Serializable id) {
		try {
			return super.getHibernateTemplate().load(entityClass, id);
		} catch (DataAccessException e) {
			log.error(e);
			return null;
		}
	}

	@Override
	public List<T> loadAll(Class<T> entityClass) {
		try {
			return super.getHibernateTemplate().loadAll(entityClass);
		} catch (DataAccessException e) {
			log.error(e);
			return null;
		}
	}

	// others ---------------------------------------------------------------
	@Override
	public void flush() {
		try {
			super.getHibernateTemplate().flush();
		} catch (DataAccessException e) {
			logger.error(e);
		}
	}

	@Override
	public void clear() {
		try {
			super.getHibernateTemplate().clear();
		} catch (DataAccessException e) {
			logger.error(e);
		}
	}
	
	// custom ---------------------------------------------------------------
	protected List<?> findByNamedQuery(String queryName, Object... values) {
		try {
			return super.getHibernateTemplate().findByNamedQuery(queryName, values);
		} catch (DataAccessException e) {
			log.error(e);
			return null;
		}
	}

}
