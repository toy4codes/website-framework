package com.toy4codes.website.framework.beans;

import java.util.List;

public class BootstrapDatagridResponse {

	private int totalRows;

	private List<?> pageData;

	private String error;

	private List<String> filterError;

	private List<String> debugMessage;

	public BootstrapDatagridResponse() {
		super();
	}

	public BootstrapDatagridResponse(int totalRows, List<?> pageData, String error, List<String> filterError,
			List<String> debugMessage) {
		super();
		this.totalRows = totalRows;
		this.pageData = pageData;
		this.error = error;
		this.filterError = filterError;
		this.debugMessage = debugMessage;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public List<?> getPageData() {
		return pageData;
	}

	public void setPageData(List<?> pageData) {
		this.pageData = pageData;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public List<String> getFilterError() {
		return filterError;
	}

	public void setFilterError(List<String> filterError) {
		this.filterError = filterError;
	}

	public List<String> getDebugMessage() {
		return debugMessage;
	}

	public void setDebugMessage(List<String> debugMessage) {
		this.debugMessage = debugMessage;
	}

}
