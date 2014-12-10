/**
 * 
 */
package com.sirma.itt.javacourse.chat.client.threads;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
	private ObjectInputStream input;
	private ObjectOutputStream output;

	@Override
	public void run() {
		log.info("Starting client");
		connectToServer();
	}

	protected void connectToServer() {
		// client = SocketGenerator.createSocket();
		try {
			client = new Socket("localhost", 7000);
			input = new ObjectInputStream(client.getInputStream());

		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
	}

	protected void disconnect() {
		try {
			client.close();
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
	}

	public void sendMessage(String messageToSend) {
		try {
			output = new ObjectOutputStream(client.getOutputStream());
			output.writeObject(messageToSend);
			output.flush();
			output.reset();
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
	}
}
