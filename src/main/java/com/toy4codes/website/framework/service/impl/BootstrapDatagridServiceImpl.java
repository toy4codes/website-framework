package com.toy4codes.website.framework.service.impl;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.toy4codes.website.framework.beans.BootstrapDatagridRequest;
import com.toy4codes.website.framework.beans.BootstrapDatagridResponse;
import com.toy4codes.website.framework.beans.JuiFilterRulesRequest;
import com.toy4codes.website.framework.beans.JuiFilterRulesResponse;
import com.toy4codes.website.framework.dao.BootstrapDatagridDao;
import com.toy4codes.website.framework.service.BootstrapDatagridService;
import com.toy4codes.website.framework.service.JuiFilterRulesService;

public class BootstrapDatagridServiceImpl implements BootstrapDatagridService {

	private static final Logger log = Logger.getLogger(BootstrapDatagridServiceImpl.class);

	@Autowired
	private JuiFilterRulesService juiFilterRulesService;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private BootstrapDatagridDao bootstrapDatagridDao;

	@Override
	public BootstrapDatagridResponse pageData(BootstrapDatagridRequest bootstrapDatagridRequest, String entityName) {

		// parse whereSQL and bindParams
		JuiFilterRulesRequest juiFilterRulesRequest = new JuiFilterRulesRequest(
				bootstrapDatagridRequest.getFilterRules());
		JuiFilterRulesResponse juiFilterRulesResponse = juiFilterRulesService.parse(juiFilterRulesRequest);
		String whereSQL = juiFilterRulesResponse.getSql();
		List<String> bindParams = juiFilterRulesResponse.getBindParams();

		int totalRows = bootstrapDatagridDao.getTotalRows(entityName, whereSQL, bindParams);

		if (totalRows > 0) {
			// parse sortingSQL
			String sortingSQL = parseSortingSQL(bootstrapDatagridRequest.getSorting());
			int pageNum = bootstrapDatagridRequest.getPageNum();
			int rowsPerPage = bootstrapDatagridRequest.getRowsPerPage();
			List<?> pageData = bootstrapDatagridDao.findPageData(entityName, whereSQL, bindParams, sortingSQL, pageNum,
					rowsPerPage);
			return new BootstrapDatagridResponse(totalRows, pageData, null, Collections.emptyList(),
					Collections.emptyList());
		} else {
			return new BootstrapDatagridResponse(0, Collections.emptyList(), null, Collections.emptyList(),
					Collections.emptyList());
		}
	}

	/**
	 * Get sorting SQL (ORDER BY clause)
	 */
	@Override
	public String parseSortingSQL(String sortingJson) {

		String sortingSQL = StringUtils.EMPTY;

		JsonNode sortings = null;

		try {
			sortings = objectMapper.readTree(sortingJson);
		} catch (JsonProcessingException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		}

		for (int i = 0; i < sortings.size(); i++) {
			JsonNode sorting = sortings.get(i);
			if (sorting.get("order").asText().equals("ascending")) {
				sortingSQL += sorting.get("field").asText() + StringUtils.SPACE + "ASC," + StringUtils.SPACE;
			} else if (sorting.get("order").asText().equals("descending")) {
				sortingSQL += StringUtils.SPACE + sorting.get("field").asText() + StringUtils.SPACE + "DESC,"
						+ StringUtils.SPACE;
			}
		}

		int length = sortingSQL.length();

		if (length > 0) {
			sortingSQL = ("ORDER BY" + StringUtils.SPACE + StringUtils.substring(sortingSQL, 0, length - 2));
		}

		return sortingSQL;
	}
}
