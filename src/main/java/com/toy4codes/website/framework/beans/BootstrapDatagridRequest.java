package com.toy4codes.website.framework.beans;

public class BootstrapDatagridRequest {

	private int pageNum;
	
	private int rowsPerPage;
	
	private String columns;
	
	private String sorting;
	
	private String filterRules;
	
	private String debugMode;

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getRowsPerPage() {
		return rowsPerPage;
	}

	public void setRowsPerPage(int rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
	}

	public String getColumns() {
		return columns;
	}

	public void setColumns(String columns) {
		this.columns = columns;
	}

	public String getSorting() {
		return sorting;
	}

	public void setSorting(String sorting) {
		this.sorting = sorting;
	}

	public String getFilterRules() {
		return filterRules;
	}

	public void setFilterRules(String filterRules) {
		this.filterRules = filterRules;
	}

	public String getDebugMode() {
		return debugMode;
	}

	public void setDebugMode(String debugMode) {
		this.debugMode = debugMode;
	}

	@Override
	public String toString() {
		return "BootstrapDatagrid [pageNum=" + pageNum + ", rowsPerPage=" + rowsPerPage + ", columns=" + columns
				+ ", sorting=" + sorting + ", filterRules=" + filterRules + ", debugMode=" + debugMode + "]";
	}
	
}
