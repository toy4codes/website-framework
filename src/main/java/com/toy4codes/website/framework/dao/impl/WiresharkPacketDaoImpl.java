package com.toy4codes.website.framework.dao.impl;

import java.util.List;

import com.toy4codes.website.framework.beans.WiresharkPacket;
import com.toy4codes.website.framework.dao.WiresharkPacketDao;
import com.toy4codes.website.framework.generic.dao.GenericHibernateDaoImpl;

public class WiresharkPacketDaoImpl extends GenericHibernateDaoImpl<WiresharkPacket> implements WiresharkPacketDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<String> findAllProtocols() {
		return (List<String>) super.findByNamedQuery("findAllProtocols", (Object[]) null);
	}

}
