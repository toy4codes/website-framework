package com.toy4codes.website.framework.action;

import org.apache.struts2.dispatcher.mapper.ActionMapping;
import org.junit.Assert;
import org.junit.Test;

import com.opensymphony.xwork2.ActionProxy;
import com.toy4codes.website.framework.utils.StrutsActionLayerJUnitSuite;

public class UserActionTest extends StrutsActionLayerJUnitSuite<UserAction> {

	@Test
	public void actionMappingTest() {
		ActionMapping actionMapping = super.getActionMapping("/systemManagement/userManagement/load");
		Assert.assertNotNull(actionMapping);
		Assert.assertEquals("/systemManagement/userManagement", actionMapping.getNamespace());
		Assert.assertEquals("load", actionMapping.getName());
	}

	@Test
	public void saveTest() throws Exception {
		request.setParameter("user.email", "example@email.com");
		request.setParameter("user.password", "password");

		ActionProxy actionProxy = getActionProxy("/systemManagement/userManagement/save");
		UserAction userAction = (UserAction) actionProxy.getAction();
		actionProxy.execute();
		Assert.assertTrue("action execute success", userAction.getActionErrors().size() == 0);
	}
}
