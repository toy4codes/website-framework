package com.toy4codes.website.framework.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.toy4codes.website.framework.beans.WiresharkPacket;
import com.toy4codes.website.framework.service.WiresharkPacketService;

public class WiresharkPacketAction extends BootstrapDatagridActionSupport {

	private static final long serialVersionUID = -8771418053538247164L;

	@Autowired
	private WiresharkPacketService wiresharkPacketService;

	public String protocols() {
		List<String> protocols = wiresharkPacketService.findAllProtocols();
		super.initLookupValues(protocols);
		return protocols != null ? SUCCESS : ERROR;
	}

	@Override
	public String getEntityName() {
		return WiresharkPacket.class.getSimpleName();
	}

}
