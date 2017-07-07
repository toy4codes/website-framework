package com.toy4codes.website.framework.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.toy4codes.website.framework.dao.WiresharkPacketDao;
import com.toy4codes.website.framework.service.WiresharkPacketService;

public class WiresharkPacketServiceImpl implements WiresharkPacketService {

	@Autowired
	private WiresharkPacketDao wiresharkPacketDao;

	@Override
	public List<String> findAllProtocols() {
		return wiresharkPacketDao.findAllProtocols();
	}

}
