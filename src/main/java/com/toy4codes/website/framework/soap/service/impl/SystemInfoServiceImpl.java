package com.toy4codes.website.framework.soap.service.impl;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.toy4codes.website.framework.beans.SystemInfo;
import com.toy4codes.website.framework.soap.service.SystemInfoService;

@WebService(targetNamespace = "http://service.soap.framework.website.toy4codes.com/")
public class SystemInfoServiceImpl implements SystemInfoService {

	private static final Logger log = Logger.getLogger(SystemInfoServiceImpl.class);

	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public String getInfo() {
		try {
			return objectMapper.writeValueAsString(SystemInfo.getInstance());
		} catch (JsonProcessingException e) {
			log.error(e);
			return "service not available, please contact system administrator";
		}
	}

}
