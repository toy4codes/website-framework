package com.toy4codes.website.framework.service;

import com.toy4codes.website.framework.beans.BootstrapDatagridRequest;
import com.toy4codes.website.framework.beans.BootstrapDatagridResponse;

public interface BootstrapDatagridService {

	public BootstrapDatagridResponse pageData(BootstrapDatagridRequest bootstrapDatagridRequest, String entityName);

	public String parseSortingSQL(String sortingJson);
}
