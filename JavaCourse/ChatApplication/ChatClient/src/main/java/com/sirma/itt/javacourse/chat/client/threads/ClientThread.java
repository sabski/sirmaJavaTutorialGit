/**
 * 
 */
package com.sirma.itt.javacourse.chat.client.threads;

import java.io.IOException;
import java.net.Socket;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.SocketGenerator;

/**
 * @author siliev
 * 
 */
public class ClientThread extends Thread {

	private static Logger log = Logger.getLogger(ClientThread.class);
	private Socket client;

	@Override
	public void run() {
		log.info("Starting client");
	}

	protected void connectToServer() {
		client = SocketGenerator.createSocket();
	}

	protected void disconnect() {
		try {
			client.close();
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
	}
}
