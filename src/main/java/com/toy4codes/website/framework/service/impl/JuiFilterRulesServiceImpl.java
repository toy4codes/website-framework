package com.toy4codes.website.framework.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.toy4codes.website.framework.beans.JuiFilterRulesRequest;
import com.toy4codes.website.framework.beans.JuiFilterRulesResponse;
import com.toy4codes.website.framework.service.JuiFilterRulesService;

public class JuiFilterRulesServiceImpl implements JuiFilterRulesService {

	private static final Logger log = Logger.getLogger(JuiFilterRulesServiceImpl.class);

	@Autowired
	private ObjectMapper objectMapper;

	private String sql;

	private List<String> bindParams;

	@Override
	public JuiFilterRulesResponse parse(JuiFilterRulesRequest juiFilterRulesRequest) {

		sql = StringUtils.EMPTY;
		bindParams = new ArrayList<String>();

		try {
			JsonNode filterRules = objectMapper.readTree(juiFilterRulesRequest.getFilterRules());
			parseInternal(filterRules, false);
			return new JuiFilterRulesResponse(sql, bindParams);
		} catch (JsonProcessingException e) {
			log.error(e);
			return new JuiFilterRulesResponse(StringUtils.EMPTY, new ArrayList<String>());
		} catch (IOException e) {
			log.error(e);
			return new JuiFilterRulesResponse(StringUtils.EMPTY, new ArrayList<String>());
		}

	}

	/**
	 * Parse rules array from given JSON object and returns WHERE SQL clause and
	 * bind params array (used on prepared statements). Recursion is used.
	 */
	private void parseInternal(JsonNode filterRules, boolean isGroup) {

		// WHERE clause
		if (filterRules.size() > 0) {
			if (StringUtils.isEmpty(sql)) {
				sql = "WHERE" + StringUtils.SPACE;
			}
		}

		JsonNode filterRule;
		int filterRuleLen = filterRules.size();

		for (int i = 0; i < filterRules.size(); i++) {

			filterRule = filterRules.get(i);

			// element_rule_id
			String elementRuleId = StringUtils.EMPTY;

			// condition
			String filterType = StringUtils.EMPTY;
			String field = StringUtils.EMPTY;
			String operator = StringUtils.EMPTY;
			List<String> filterValues = new ArrayList<String>();

			// logical_operator
			String logicalOperator = StringUtils.EMPTY;

			// element_rule_id
			if (null != filterRule.get("element_rule_id")) {
				elementRuleId = filterRule.get("element_rule_id").asText();
			}

			// condition -- filterType
			if (null != filterRule.get("condition").get("filterType")) {
				filterType = filterRule.get("condition").get("filterType").asText();
			}

			// condition -- field
			if (null != filterRule.get("condition").get("field")) {
				field = filterRule.get("condition").get("field").asText();
			}

			// condition -- operator
			if (null != filterRule.get("condition").get("operator")) {
				operator = filterRule.get("condition").get("operator").asText();
			}

			// condition - filterValue
			if (null != filterRule.get("condition").get("filterValue")) {
				Iterator<JsonNode> values = filterRule.get("condition").get("filterValue").elements();
				while (values.hasNext()) {
					filterValues.add(values.next().asText());
				}
			}

			// logical_operator
			if (null != filterRule.get("logical_operator")) {
				logicalOperator = filterRule.get("logical_operator").asText();
			}

			if (!isGroupFilterRule(filterRule)) {

				// parentheses
				sql += (isGroup && i == 0 ? "(" : StringUtils.EMPTY);

				// field
				sql += field;

				// operator
				sql += createOperatorSql(operator);

				String filterValueSql = createFilterValueSql(filterType, operator, filterValues, elementRuleId);

				if (!operator.equals("is_null") && !operator.equals("is_not_null")) {

					if (operator.equals("in") || operator.equals("not_in")) {
						sql += "(";
						int filterValueLen = filterValues.size();
						for (int j = 0; j < filterValueLen; j++) {
							sql += "?";
							if (j < filterValueLen - 1) {
								sql += ",";
							}
							bindParams.add(filterValues.get(j));
						}
						sql += ")";
					} else {
						sql += "?";
						if (operator.equals("is_empty") || operator.equals("is_not_empty")) {
							bindParams.add(StringUtils.EMPTY);
						} else {
							bindParams.add(filterValueSql);
						}
					}

				}

			} else if (filterRule.get("condition").size() > 0) {
				parseInternal(filterRule.get("condition"), true);
			}

			// logical operator (between rules)
			sql += (i < filterRuleLen - 1 ? StringUtils.SPACE + logicalOperator + StringUtils.SPACE
					: StringUtils.SPACE);

			// parentheses
			sql += (isGroup && i == filterRuleLen - 1 ? ")" : StringUtils.EMPTY);

		}

	}

	/**
	 * Return current rule filter value as a string suitable for SQL WHERE
	 * clause
	 */
	private String createFilterValueSql(String filterType, String operator, List<String> filterValues,
			String elementRuleId) {

		String filterValueSql = StringUtils.EMPTY;

		if ("is_empty".equals(operator) || "is_not_empty".equals(operator) || "is_null".equals(operator)
				|| "is_not_null".equals(operator)) {
			return StringUtils.EMPTY;
		}

		int filterValueLen = filterValues.size();

		if ("equal".equals(operator) || "not_equal".equals(operator) || "less".equals(operator)
				|| "less_or_equal".equals(operator) || "greater".equals(operator)
				|| "greater_or_equal".equals(operator)) {
			filterValueSql = filterValues.get(0);
		} else if ("begins_with".equals(operator) || "not_begins_with".equals(operator)) {
			filterValueSql = filterValues.get(0) + "%";
		} else if ("contains".equals(operator) || "not_contains".equals(operator)) {
			filterValueSql = "%" + filterValues.get(0) + "%";
		} else if ("ends_with".equals(operator) || "not_ends_with".equals(operator)) {
			filterValueSql = "%" + filterValues.get(0);
		} else if ("in".equals(operator) || "not_in".equals(operator)) {
			for (int i = 0; i < filterValueLen; i++) {
				filterValueSql += (i == 0 ? "(" : StringUtils.EMPTY);
				filterValueSql += filterValues.get(i);
				filterValueSql += (i < filterValueLen - 1 ? "," : ")");
			}
		}

		return filterValueSql;
	}

	/**
	 * Create rule operator SQL substring
	 */
	private String createOperatorSql(String operatorType) {
		String operator = StringUtils.EMPTY;
		switch (operatorType) {
		case "equal":
			operator = "=";
			break;
		case "not_equal":
			operator = "!=";
			break;
		case "in":
			operator = "IN";
			break;
		case "not_in":
			operator = "NOT IN";
			break;
		case "less":
			operator = "<";
			break;
		case "less_or_equal":
			operator = "<=";
			break;
		case "greater":
			operator = ">";
			break;
		case "greater_or_equal":
			operator = ">=";
			break;
		case "begins_with":
			operator = "LIKE";
			break;
		case "not_begins_with":
			operator = "NOT LIKE";
			break;
		case "contains":
			operator = "LIKE";
			break;
		case "not_contains":
			operator = "NOT LIKE";
			break;
		case "ends_with":
			operator = "LIKE";
			break;
		case "not_ends_with":
			operator = "NOT LIKE";
			break;
		case "is_empty":
			operator = "=";
			break;
		case "is_not_empty":
			operator = "!=";
			break;
		case "is_null":
			operator = "IS NULL";
			break;
		case "is_not_null":
			operator = "IS NOT NULL";
			break;
		}
		operator = StringUtils.SPACE + operator + StringUtils.SPACE;
		return operator;
	}

	/**
	 * whether it is a sub group filter rule
	 * 
	 */
	private boolean isGroupFilterRule(JsonNode filterRule) {
		return filterRule.get("condition").get("filterType") == null ? true : false;
	}

}
