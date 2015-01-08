package com.sirma.itt.javacourse.networkingAndGui.task6.transmiter.messagedispacher;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.log4j.Logger;

/**
 * This class sends multicast messages to active mulsticast addresses.
 * 
 * @author siliev
 * 
 */
public class MessageDispatcher extends AbstractMessageModerator {

	private static final Logger LOGGER = Logger
			.getLogger(MessageDispatcher.class);
	private volatile Map<InetAddress, MulticastSocket> addressList;
	private MulticastAddressSupplier supplier;
	private MulticastSocket server;

	/**
	 * Constructor for the message dispatcher.
	 */
	public MessageDispatcher() {
		addressList = new HashMap<InetAddress, MulticastSocket>();
		supplier = new MulticastAddressSupplier();
		try {
			server = new MulticastSocket();
		} catch (IOException e) {
			LOGGER.info(e.getMessage(), e);
		}
	}

	@Override
	public void addChanell(InetAddress address) {
		if (!addressList.containsKey(address)) {
			try {

				server.joinGroup(address);
				addressList.put(address, server);
			} catch (IOException e) {
				LOGGER.error(e.getMessage(), e);
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
				LOGGER.info("Message send " + message.toString());
			} catch (IOException e) {
				LOGGER.error(e.getMessage(), e);
			}
		}

	}

	/**
	 * Generates a message that is going to be sent to a specific multicast
	 * address.
	 * 
	 * @param address
	 *            the address for the packet to be sent to.
	 * @param socket
	 *            the socket that we are going to send the message thru.
	 */
	public void generatePackege(InetAddress address, MulticastSocket socket) {
		Date date = new Date();

		try {
			ByteArrayOutputStream byteStream = new ByteArrayOutputStream(1024);
			ObjectOutputStream os = new ObjectOutputStream(
					new BufferedOutputStream(byteStream));
			os.flush();
			os.writeObject(date);
			os.flush();
			os.close();
			byte[] buffer = byteStream.toByteArray();
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length,
					address, 7005);
			socket.send(packet);
			LOGGER.info("Date send " + date.toString() + " send to "
					+ address.getHostAddress());
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		}

	}

	/**
	 * Starts broadcasting multicat messages to the InetAddress in the list.
	 */
	public void broadcastMulticastMessages() {
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
				LOGGER.error(e.getMessage(), e);
			}
		}
	}

	@Override
	public void run() {
		broadcastMulticastMessages();
	}

}
