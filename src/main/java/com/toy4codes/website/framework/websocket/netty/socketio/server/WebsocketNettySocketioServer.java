package com.toy4codes.website.framework.websocket.netty.socketio.server;

import org.apache.log4j.Logger;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DisconnectListener;
import com.toy4codes.website.framework.utils.StringUtils;

public class WebsocketNettySocketioServer extends SocketIOServer {

	private static final Logger log = Logger.getLogger(WebsocketNettySocketioServer.class);

	public WebsocketNettySocketioServer(Configuration configuration) {

		super(configuration);

		super.addConnectListener(new ConnectListener() {
			@Override
			public void onConnect(SocketIOClient client) {
				log.info(client.getRemoteAddress() + StringUtils.COLON + client.getSessionId().toString()
						+ " websocket client connected.");
			}
		});

		super.addDisconnectListener(new DisconnectListener() {
			@Override
			public void onDisconnect(SocketIOClient client) {
				log.info(client.getRemoteAddress() + StringUtils.COLON + client.getSessionId().toString()
						+ " websocket client disconnected.");
				client.disconnect();
			}
		});
		
		

	}

	public void startUp() {
		super.start();
	}

	public void shutDown() {
		super.stop();
	}

}
