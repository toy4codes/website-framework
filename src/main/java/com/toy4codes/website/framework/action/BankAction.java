package com.toy4codes.website.framework.action;

import com.toy4codes.website.framework.beans.Bank;

public class BankAction extends BootstrapDatagridActionSupport {

	private static final long serialVersionUID = -5174354697905378368L;

	@Override
	protected String getEntityName() {
		return Bank.class.getSimpleName();
	}

}
