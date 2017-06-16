package com.toy4codes.website.framework.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.toy4codes.website.framework.dao.BootstrapDatagridDao;
import com.toy4codes.website.framework.generic.dao.GenericHibernateDaoImpl;

public class BootstrapDatagridDaoImpl extends GenericHibernateDaoImpl<Object> implements BootstrapDatagridDao {

	@Override
	public int getTotalRows(String entityName, String whereSQL, List<String> bindParams) {
		String selectSQL = "select count(*) from" + StringUtils.SPACE + entityName + StringUtils.SPACE;
		String querySQL = selectSQL + whereSQL;

		List<?> results = super.find(querySQL, bindParams.toArray());
		long totalRows = (Long) results.get(0);

		return Integer.valueOf(String.valueOf(totalRows));
	}

	@Override
	public List<?> findPageData(String entityName, String whereSQL, List<String> bindParams, String sortingSQL,
			int pageNum, int rowsPerPage) {
		String selectSQL = "from" + StringUtils.SPACE + entityName;

		if (StringUtils.isEmpty(whereSQL)) {
			whereSQL = StringUtils.SPACE;
		} else {
			whereSQL = StringUtils.SPACE + whereSQL + StringUtils.SPACE;
		}

		String querySQL = selectSQL + whereSQL + sortingSQL;

		int firstResult = (pageNum - 1) * rowsPerPage;
		int maxResults = rowsPerPage;

		List<?> pageData = super.findPagination(querySQL, firstResult, maxResults, bindParams.toArray());

		return pageData;
	}

}
