package com.toy4codes.website.framework.soap.service;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

public class SystemInfoServiceTest {

	private static final Logger log = Logger.getLogger(SystemInfoServiceTest.class);

	private static String WSDL = "http://localhost:8080/website-framework/webservice/soap/systemInfoService?wsdl";

	private static Client client;

	@BeforeClass
	public static void startUp() {
		JaxWsDynamicClientFactory jaxWsDynamicFactory = JaxWsDynamicClientFactory.newInstance();
		client = jaxWsDynamicFactory.createClient(WSDL);
	}

	@Test
	public void getInfoTest() throws Exception {
		Object[] results = client.invoke("getInfo");
		log.debug(results[0]);
	}

}
