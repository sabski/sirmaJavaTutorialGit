package com.sirma.itt.javacourse.networkingAndGui.task6.transmiter.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

import org.apache.log4j.Logger;

/**
 * @author siliev
 * 
 */
public class MulticastClient extends Thread {

	private static Logger log = Logger.getLogger(MulticastClient.class);
	private MulticastSocket client;
	private String group = "225.4.5.6";

	public void readPackegeData() {
		while (!client.isConnected()) {
			byte[] buffer = new byte[1024];
			DatagramPacket pack = new DatagramPacket(buffer, buffer.length);
			try {
				client.receive(pack);
				log.info("reseived " + pack.toString());
			} catch (IOException e) {
				log.error(e.getMessage(), e);
			}
		}
	}

	@Override
	public void run() {
		log.info("Client started");
		readPackegeData();
	}

	/**
	 * 
	 */
	public MulticastClient() {
		try {
			client = new MulticastSocket(7005);
			client.joinGroup(InetAddress.getByName(group));
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
	}

}
