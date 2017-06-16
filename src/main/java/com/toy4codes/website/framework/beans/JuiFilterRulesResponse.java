package com.toy4codes.website.framework.beans;

import java.util.List;

public class JuiFilterRulesResponse {

	private String sql;

	private List<String> bindParams;

	public JuiFilterRulesResponse() {
		super();
	}

	public JuiFilterRulesResponse(String sql, List<String> bindParams) {
		super();
		this.sql = sql;
		this.bindParams = bindParams;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public List<String> getBindParams() {
		return bindParams;
	}

	public void setBindParams(List<String> bindParams) {
		this.bindParams = bindParams;
	}

}
