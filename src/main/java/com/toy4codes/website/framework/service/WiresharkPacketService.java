package com.toy4codes.website.framework.service;

import java.util.List;

public interface WiresharkPacketService {
	
	public List<String> findAllProtocols();

	public List<String[]> findAllProtocolsAndCounts();
	
}
