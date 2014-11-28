/**
 * 
 */
package com.sirma.itt.javacourse.networkingAndGui.task6.transmiter.server;

import java.io.IOException;
import java.net.MulticastSocket;

/**
 * @author siliev
 * 
 */
public class MulticastServer extends Thread {

	private static org.apache.log4j.Logger log = org.apache.log4j.Logger
			.getLogger(MulticastServer.class);

	private MulticastSocket server;

	public void startServer() {
		try {
			server = new MulticastSocket(7005);
			server.joinGroup(null);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}

	}

	@Override
	public void run() {

	}

}
