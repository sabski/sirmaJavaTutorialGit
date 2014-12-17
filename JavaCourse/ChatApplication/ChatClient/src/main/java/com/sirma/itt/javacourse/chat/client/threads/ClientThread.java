/**
 * 
 */
package com.sirma.itt.javacourse.chat.client.threads;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.chat.client.managers.ClientMessageInterpretor;
import com.sirma.itt.javacourse.chat.common.Message;

/**
 * @author siliev
 * 
 */
public class ClientThread extends Thread {

	private static Logger log = Logger.getLogger(ClientThread.class);
	private Socket client;
	private ObjectInputStream input;
	private ObjectOutputStream output;
	private ClientMessageInterpretor manager;

	@Override
	public void run() {
		log.info("Starting client");
		connectToServer();
		readServerMassesges();
	}

	protected void connectToServer() {
		// client = SocketGenerator.createSocket();
		try {
			client = new Socket("localhost", 7000);
			input = new ObjectInputStream(client.getInputStream());
			manager = new ClientMessageInterpretor(this);
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

	public void sendMessage(Message messageToSend) {
		try {
			if (output == null) {
				output = new ObjectOutputStream(client.getOutputStream());
			}
			output.writeObject(messageToSend);
			output.flush();
			output.reset();
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
	}

	public void readServerMassesges() {
		try {
			Message message;
			while (!client.isClosed()) {
				message = (Message) input.readObject();
				if (message != null) {
					manager.interpretMessage(message, null);
				}
			}
		} catch (IOException | ClassNotFoundException e) {
			log.error(e.getMessage(), e);
		}
	}

}
