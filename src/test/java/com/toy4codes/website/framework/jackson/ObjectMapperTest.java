package com.toy4codes.website.framework.jackson;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.toy4codes.website.framework.beans.SystemInfo;
import com.toy4codes.website.framework.utils.SpringContainerLayerJUnitSuite;

public class ObjectMapperTest extends SpringContainerLayerJUnitSuite {

	private static final Logger log = Logger.getLogger(ObjectMapperTest.class);

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void writeStringTest() throws JsonProcessingException {
		SystemInfo systemInfo = SystemInfo.getInstance();
		log.debug(objectMapper.writeValueAsString(systemInfo));
	}

}
