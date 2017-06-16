package com.toy4codes.website.framework.dao;

import java.util.List;

import com.toy4codes.website.framework.generic.dao.GenericHibernateDao;

public interface BootstrapDatagridDao extends GenericHibernateDao<Object> {

	public int getTotalRows(String entityName, String whereSQL, List<String> bindParams);

	public List<?> findPageData(String entityName, String whereSQL, List<String> bindParams, String sortingSQL,
			int pageNum, int rowsPerPage);

}
