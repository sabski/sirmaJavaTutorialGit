package com.sirma.itt.javacourse.networkingAndGui.task6.transmiter.messagedispacher;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

/**
 * @author siliev
 * 
 */
public class MessageDispacher extends Thread implements MessageModerator {

	private static Logger log = Logger.getLogger(MessageDispacher.class);
	private volatile Map<InetAddress, MulticastSocket> addressList;
	private MulticastAddressSupplier supplier;

	/**
	 * 
	 */
	public MessageDispacher() {
		addressList = new HashMap<InetAddress, MulticastSocket>();
		supplier = new MulticastAddressSupplier();
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

	public void generatePackege(InetAddress address, MulticastSocket socket) {
		Date date = new Date();
		byte[] buffer = date.toString().getBytes();
		try {
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length,
					address, 7005);
			socket.send(packet);
			log.info("Date send " + date.toString() + " send to "
					+ address.getHostAddress());
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}

	}

	public void sendMulticastMessage() {
		while (isAlive()) {
			if (!addressList.isEmpty()) {
				MulticastSocket socket = null;
				InetAddress address = null;
				while (socket == null) {
					address = supplier.getRandomAddress();
					socket = addressList.get(address);
				}
				generatePackege(address, socket);
			}
			try {
				Thread.sleep(2500);
			} catch (InterruptedException e) {
				log.error(e.getMessage(), e);
			}
		}
	}

	@Override
	public void run() {
		sendMulticastMessage();
	}

}