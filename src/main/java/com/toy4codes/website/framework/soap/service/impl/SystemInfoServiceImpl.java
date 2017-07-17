package com.toy4codes.website.framework.soap.service.impl;

import javax.jws.WebService;

import com.toy4codes.website.framework.soap.service.SystemInfoService;

@WebService(targetNamespace="http://service.soap.framework.website.toy4codes.com/")
public class SystemInfoServiceImpl implements SystemInfoService {

	@Override
	public String getInfo() {
		return "website.framework";
	}

}
