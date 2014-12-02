package com.sirma.itt.javacourse.networkingAndGui.task6.transmiter.messagedispacher;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

/**
 * @author siliev
 * 
 */
public class MessageDispacher implements MessageModerator {

	private static Logger log = Logger.getLogger(MessageDispacher.class);
	private Map<InetAddress, MulticastSocket> addressList;

	/**
	 * 
	 */
	public MessageDispacher() {
		addressList = new HashMap<InetAddress, MulticastSocket>();
	}

	@Override
	public void addChanell(InetAddress address) {
		if (!addressList.containsKey(address)) {
			try {
				MulticastSocket server = new MulticastSocket();
				server.joinGroup(address);
				addressList.put(address, server);
			} catch (IOException e) {
				log.error(e.getMessage(), e);
			}
		}
	}

	@Override
	public void sendMessages(String message) {
		for (Entry<InetAddress, MulticastSocket> socketList : addressList
				.entrySet()) {
			MulticastSocket socket = socketList.getValue();
			InetAddress address = socketList.getKey();
			byte[] buffer = message.getBytes();
			try {
				DatagramPacket packet = new DatagramPacket(buffer,
						buffer.length, address, 7005);
				socket.setTimeToLive(5);
				socket.send(packet);
				log.info("Message send " + message.toString());
			} catch (IOException e) {
				log.error(e.getMessage(), e);
			}
		}

	}

}
