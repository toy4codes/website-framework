package com.toy4codes.website.framework.service.impl;

import java.util.ArrayList;
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

	@Override
	public List<String[]> findAllProtocolsAndCounts() {
		List<String[]> results = new ArrayList<String[]>();
		List<Object[]> protocolsAndCounts = wiresharkPacketDao.findAllProtocolsAndCounts();
		for (int i = 0; i < protocolsAndCounts.size(); i++) {
			Object[] protocolAndCount = protocolsAndCounts.get(i);
			String protocol = (String) protocolAndCount[0];
			long count = (long) protocolAndCount[1];
			results.add(new String[] { protocol, String.valueOf(count) });
		}
		return results;
	}

}
