package com.toy4codes.website.framework.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;

import com.toy4codes.website.framework.beans.JuiFilterRulesRequest;
import com.toy4codes.website.framework.beans.JuiFilterRulesResponse;
import com.toy4codes.website.framework.utils.SpringContainerLayerJUnitSuite;

public class JuiFilterRulesServiceTest extends SpringContainerLayerJUnitSuite {

	private static final Logger log = Logger.getLogger(JuiFilterRulesServiceTest.class);

	private static final String JUI_FILTER_RULES_JSON = "jui_filter_rules.json";

	@Autowired
	private JuiFilterRulesService juiFilterRulesService;

	@Test
	public void parseTest() throws IOException {

		InputStream is = new ClassPathResource(JUI_FILTER_RULES_JSON).getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));

		StringBuffer filterRules = new StringBuffer();

		char[] buffer = new char[1024];
		
		int numRead = 0;
		
		while ((numRead = reader.read(buffer)) != -1) {
			filterRules.append(String.copyValueOf(buffer, 0, numRead));
			buffer = new char[1024];
		}
		
		reader.close();

		JuiFilterRulesRequest juiFilterRulesRequest = new JuiFilterRulesRequest();
		juiFilterRulesRequest.setFilterRules(filterRules.toString());

		JuiFilterRulesResponse juiFilterRulesResponse = juiFilterRulesService.parse(juiFilterRulesRequest);

		log.debug(juiFilterRulesResponse.getSql());

		log.debug(juiFilterRulesResponse.getBindParams());
	}

}
