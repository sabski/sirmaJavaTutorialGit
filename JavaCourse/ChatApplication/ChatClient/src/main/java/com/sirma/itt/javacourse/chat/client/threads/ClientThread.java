package com.sirma.itt.javacourse.chat.client.threads;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.chat.client.interfaces.UserController;
import com.sirma.itt.javacourse.chat.client.managers.ClientInfo;
import com.sirma.itt.javacourse.chat.client.managers.ClientMessageInterpretor;
import com.sirma.itt.javacourse.chat.common.Message;
import com.sirma.itt.javacourse.chat.common.MessageInterpreter;
import com.sirma.itt.javacourse.chat.common.MessageType;

/**
 * The main client thread that connects to the server and reads messages.
 * 
 * @author siliev
 * 
 */
public class ClientThread extends Thread {

	private static final Logger LOGGER = Logger.getLogger(ClientThread.class);
	private Socket client;
	private ObjectInputStream input;
	private ObjectOutputStream output;
	private MessageInterpreter manager;
	private String username;
	private String address = "localhost";
	private int port = 7000;
	private UserController controller;

	public ClientThread(String username, String address, int port,
			UserController controler) {
		this.username = username;
		this.address = address;
		this.port = port;
		this.controller = controler;
	}

	public MessageInterpreter getManager() {
		return manager;
	}

	public void setManager(MessageInterpreter manager) {
		this.manager = manager;
	}

	@Override
	public void run() {
		connectToServer();
		LOGGER.info("Starting client");
		sendMessage(new Message(username, 0, MessageType.CONNECT, username));
		LOGGER.info("Starting read messages");
		readServerMassesges();
	}

	/**
	 * Connect to the server.
	 */
	public boolean connectToServer() {
		try {
			LOGGER.info("Connecting to address " + address + " on port " + port);
			client = new Socket(address, port);
			output = new ObjectOutputStream(client.getOutputStream());
			input = new ObjectInputStream(client.getInputStream());
			manager = new ClientMessageInterpretor(controller);
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
			controller.serverDisconnect();
		} finally {
			LOGGER.info("Connection attemt finished.");
		}
		return client != null && client.isConnected();
	}

	/**
	 * Closes the connection to the server.
	 */
	protected void disconnect() {
		try {
			client.close();
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		}
	}

	/**
	 * Sends a message to the server.
	 * 
	 * @param messageToSend
	 *            the message that the client wants to send to the server.
	 */
	public void sendMessage(Message messageToSend) {
		LOGGER.info("Sending message " + messageToSend);
		try {
			output.writeObject(messageToSend);
			output.flush();
			output.reset();
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		}
	}

	/**
	 * Reads a message from the server and then sends it for processing.
	 */
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
			LOGGER.error(e.getMessage(), e);
			controller.serverDisconnect();
		} finally {
			LOGGER.info("No more server messages");
		}
	}

	@Override
	public void interrupt() {
		if (client.isConnected()) {
			LOGGER.info("Sending dissconnect message to the server.");
			sendMessage(new Message("", 0, MessageType.DISCONNECT, ClientInfo
					.getInstance().getUserName()));
		}
		super.interrupt();
	}
}
