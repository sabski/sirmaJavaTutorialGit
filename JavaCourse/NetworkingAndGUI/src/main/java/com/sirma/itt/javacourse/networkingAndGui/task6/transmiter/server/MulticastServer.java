/**
 * 
 */
package com.sirma.itt.javacourse.networkingAndGui.task6.transmiter.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author siliev
 * 
 */
public class MulticastServer extends Thread {

	private static org.apache.log4j.Logger log = org.apache.log4j.Logger
			.getLogger(MulticastServer.class);

	private MulticastSocket server;
	private Socket client;
	private Map<Socket, Object> clientMap;
	private String multicastAddress = "225.4.5.6";

	public void startServer() {
		try {
			server = new MulticastSocket(7005);
			server.joinGroup(InetAddress.getByName(multicastAddress));
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}

	}

	public void stopServer() {
		interrupt();
	}

	public void acceptConnections() {
		while (!server.isClosed()) {
			generatePackege();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				log.error(e.getMessage(), e);
			}
		}
	}

	public void sendMulticastMessage() {

	}

	public void readClientMessages() {

	}

	@Override
	public void run() {
		startServer();
		acceptConnections();
	}

	/**
	 * Basic constructor.
	 */
	public MulticastServer() {
		this.clientMap = new HashMap<Socket, Object>();
	}

	public void generatePackege() {
		Date date = new Date();
		byte[] buffer = date.toString().getBytes();
		InetAddress group;
		try {
			group = InetAddress.getByName(multicastAddress);
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length,
					group, 7005);
			server.send(packet);
			log.info("Date send " + date.toString());
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}

	}

}
