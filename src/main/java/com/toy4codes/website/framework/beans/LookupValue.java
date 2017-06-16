package com.toy4codes.website.framework.beans;

public class LookupValue {

	private String lk_option;

	private String lk_value;

	private String lk_selected;

	public LookupValue() {
		super();
	}

	public LookupValue(String lk_option, String lk_value, String lk_selected) {
		super();
		this.lk_option = lk_option;
		this.lk_value = lk_value;
		this.lk_selected = lk_selected;
	}

	public String getLk_option() {
		return lk_option;
	}

	public void setLk_option(String lk_option) {
		this.lk_option = lk_option;
	}

	public String getLk_value() {
		return lk_value;
	}

	public void setLk_value(String lk_value) {
		this.lk_value = lk_value;
	}

	public String getLk_selected() {
		return lk_selected;
	}

	public void setLk_selected(String lk_selected) {
		this.lk_selected = lk_selected;
	}

}
