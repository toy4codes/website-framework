package com.toy4codes.website.framework.dao;

import java.util.List;

import com.toy4codes.website.framework.beans.WiresharkPacket;
import com.toy4codes.website.framework.generic.dao.GenericHibernateDao;

public interface WiresharkPacketDao extends GenericHibernateDao<WiresharkPacket> {

	public List<String> findAllProtocols();
	
	public List<Object[]> findAllProtocolsAndCounts();
	
}
