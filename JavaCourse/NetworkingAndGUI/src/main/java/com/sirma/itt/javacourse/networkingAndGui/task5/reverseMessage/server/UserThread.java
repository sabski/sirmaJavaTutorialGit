package com.sirma.itt.javacourse.networkingAndGui.task5.reverseMessage.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import org.apache.log4j.Logger;

public class UserThread extends Thread {

	private static final Logger LOGGER = Logger.getLogger(UserThread.class);
	private Socket client;
	private ObjectOutputStream outputStream;
	private ObjectInputStream inputStream;

	/**
	 * @param client
	 * @param outputStream
	 * @param inputStream
	 */
	public UserThread(Socket client, ObjectOutputStream outputStream,
			ObjectInputStream inputStream) {
		super();
		this.client = client;
		this.outputStream = outputStream;
		this.inputStream = inputStream;
	}

	@Override
	public void run() {
		readClientMessage();
	}

	/**
	 * Sends the connected client a message.
	 * 
	 * @param message
	 *            the message that is to be sent to the client.
	 */
	public void sendUserMessage(String message) {
		if (client != null) {
			try {
				outputStream.writeObject(message);
				LOGGER.info("Message was sent : " + message);
				outputStream.flush();
				outputStream.reset();
			} catch (IOException e) {
				LOGGER.error(e.getMessage(), e);
			}
		}
	}

	/**
	 * Read the client messages and invokes a response to them.
	 */
	public void readClientMessage() {
		String line = null;
		try {
			while ((line = (String) inputStream.readObject()) != null) {
				sendUserMessage(writeReversedMessage(line));
			}
		} catch (ClassNotFoundException | IOException e) {
			LOGGER.error(e.getMessage(), e);
		}
	}

	/**
	 * Writes a reverse message that is returned
	 * 
	 * @param message
	 *            the message to be reverted
	 * @return the reverted String.
	 */
	public String writeReversedMessage(String message) {
		StringBuilder reversedMessage = new StringBuilder(message);
		return "The reverse of " + message + " is " + reversedMessage.reverse();
	}

}
