package com.toy4codes.website.framework.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.toy4codes.website.framework.utils.SpringContainerLayerJUnitSuite;

public class WiresharkPacketDaoTest extends SpringContainerLayerJUnitSuite {

	private static final Logger log = Logger.getLogger(WiresharkPacketDaoTest.class);

	@Autowired
	private WiresharkPacketDao wiresharkPacketDao;

	@Test
	public void findAllProtocolsTest() {
		List<String> protocols = wiresharkPacketDao.findAllProtocols();
		log.debug(protocols);
	}

	@Test
	public void findAllProtocolsAndCountsTest() {
		List<Object[]> results = wiresharkPacketDao.findAllProtocolsAndCounts();
		for (Object[] result : results) {
			log.debug(result[0] + ", " + result[1]);
		}
	}

}
