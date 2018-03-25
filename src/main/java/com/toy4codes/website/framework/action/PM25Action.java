package com.toy4codes.website.framework.action;

import com.toy4codes.website.framework.beans.PM25;

public class PM25Action extends BootstrapDatagridActionSupport {

	private static final long serialVersionUID = 2064491276077954640L;

	@Override
	protected String getEntityName() {
		return PM25.class.getSimpleName();
	}

}
