package com.toy4codes.website.framework.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.toy4codes.website.framework.beans.BootstrapDatagridRequest;
import com.toy4codes.website.framework.beans.BootstrapDatagridResponse;
import com.toy4codes.website.framework.beans.LookupValue;
import com.toy4codes.website.framework.service.BootstrapDatagridService;

public abstract class BootstrapDatagridActionSupport extends ActionSupport {

	private static final long serialVersionUID = 3056512519689624304L;

	@Autowired
	private BootstrapDatagridService bootstrapDatagridService;

	private BootstrapDatagridRequest bootstrapDatagridRequest;

	private BootstrapDatagridResponse bootstrapDatagridResponse;

	private List<LookupValue> lookupValues;

	public String datagrid() {
		bootstrapDatagridResponse = bootstrapDatagridService.pageData(bootstrapDatagridRequest,
				getEntityName());
		return bootstrapDatagridResponse != null ? SUCCESS : ERROR;
	}

	protected void initLookupValues(List<String> values) {

		String value;
		String lk_option, lk_value, lk_selected;
		lookupValues = new ArrayList<LookupValue>();

		for (int i = 0; i < values.size(); i++) {
			value = values.get(i);
			lk_option = value;
			lk_value = value;
			lk_selected = (i == 0 ? "yes" : "no");
			lookupValues.add(new LookupValue(lk_option, lk_value, lk_selected));
		}
	}

	public abstract String getEntityName();

	public BootstrapDatagridRequest getBootstrapDatagridRequest() {
		return bootstrapDatagridRequest;
	}

	public void setBootstrapDatagridRequest(BootstrapDatagridRequest bootstrapDatagridRequest) {
		this.bootstrapDatagridRequest = bootstrapDatagridRequest;
	}

	public BootstrapDatagridResponse getBootstrapDatagridResponse() {
		return bootstrapDatagridResponse;
	}

	public void setBootstrapDatagridResponse(BootstrapDatagridResponse bootstrapDatagridResponse) {
		this.bootstrapDatagridResponse = bootstrapDatagridResponse;
	}

	public List<LookupValue> getLookupValues() {
		return lookupValues;
	}

	public void setLookupValues(List<LookupValue> lookupValues) {
		this.lookupValues = lookupValues;
	}

}
