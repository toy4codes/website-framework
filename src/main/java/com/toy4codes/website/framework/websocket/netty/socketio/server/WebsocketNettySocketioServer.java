package com.toy4codes.website.framework.websocket.netty.socketio.server;

import org.apache.log4j.Logger;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIONamespace;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import com.corundumstudio.socketio.listener.DisconnectListener;
import com.toy4codes.website.framework.utils.StringUtil;

public class WebsocketNettySocketioServer extends SocketIOServer {

	private static final Logger log = Logger.getLogger(WebsocketNettySocketioServer.class);

	private static final String CHAT_EVENT = "chatEvent";

	private static final String MESSAGE_EVENT = "messageEvent";

	private static final String FOOTBALL_NAMESPACE = "/football";

	private static final String BASKETBALL_NAMESPACE = "/basketball";

	public WebsocketNettySocketioServer(Configuration configuration) {

		super(configuration);

		super.addConnectListener(new ConnectListener() {
			@Override
			public void onConnect(SocketIOClient client) {
				log.info(client.getRemoteAddress() + StringUtil.COLON + client.getSessionId().toString()
						+ " websocket client connected.");
			}
		});

		super.addDisconnectListener(new DisconnectListener() {
			@Override
			public void onDisconnect(SocketIOClient client) {
				log.info(client.getRemoteAddress() + StringUtil.COLON + client.getSessionId().toString()
						+ " websocket client disconnected.");
				client.disconnect();
			}
		});

		super.addEventListener(CHAT_EVENT, ChatObject.class, new DataListener<ChatObject>() {
			@Override
			public void onData(SocketIOClient client, ChatObject data, AckRequest ackRequest) {
				// broadcast messages to all clients
				getBroadcastOperations().sendEvent(CHAT_EVENT, data);
			}
		});

		final SocketIONamespace footballNamespace = super.addNamespace(FOOTBALL_NAMESPACE);

		footballNamespace.addEventListener(MESSAGE_EVENT, ChatObject.class, new DataListener<ChatObject>() {
			@Override
			public void onData(SocketIOClient client, ChatObject data, AckRequest ackRequest) {
				// broadcast messages to all clients
				footballNamespace.getBroadcastOperations().sendEvent(MESSAGE_EVENT, data);
			}
		});

		final SocketIONamespace basketballNamespace = super.addNamespace(BASKETBALL_NAMESPACE);

		basketballNamespace.addEventListener(MESSAGE_EVENT, ChatObject.class, new DataListener<ChatObject>() {
			@Override
			public void onData(SocketIOClient client, ChatObject data, AckRequest ackRequest) {
				// broadcast messages to all clients
				basketballNamespace.getBroadcastOperations().sendEvent(MESSAGE_EVENT, data);
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
