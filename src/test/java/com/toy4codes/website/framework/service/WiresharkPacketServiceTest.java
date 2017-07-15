package com.toy4codes.website.framework.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.toy4codes.website.framework.utils.SpringContainerLayerJUnitSuite;

public class WiresharkPacketServiceTest extends SpringContainerLayerJUnitSuite {

	private static final Logger log = Logger.getLogger(WiresharkPacketServiceTest.class);

	@Autowired
	private WiresharkPacketService wiresharkPacketService;

	@Test
	public void findAllProtocolsAndCountsTest() {
		List<String[]> results = wiresharkPacketService.findAllProtocolsAndCounts();
		for (String[] result : results) {
			log.debug(result[0] + ", " + result[1]);
		}
	}

}
