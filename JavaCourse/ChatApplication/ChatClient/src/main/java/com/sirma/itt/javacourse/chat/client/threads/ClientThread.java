/**
 * 
 */
package com.sirma.itt.javacourse.chat.client.threads;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.chat.client.managers.ClientInfo;
import com.sirma.itt.javacourse.chat.client.managers.ClientMessageInterpretor;
import com.sirma.itt.javacourse.chat.common.Message;
import com.sirma.itt.javacourse.chat.common.Message.TYPE;

/**
 * 
 * 
 * @author siliev
 * 
 */
public class ClientThread extends Thread {

	private static final Logger LOGGER = Logger.getLogger(ClientThread.class);
	private Socket client;
	private ObjectInputStream input;
	private ObjectOutputStream output;
	private ClientMessageInterpretor manager;

	@Override
	public void run() {
		LOGGER.info("Starting client");
		connectToServer();
		readServerMassesges();
	}

	/**
	 * Connect to the server.
	 */
	protected void connectToServer() {
		// client = SocketGenerator.createSocket();10.131.2.96
		try {
			client = new Socket("localhost", 7000);
			input = new ObjectInputStream(client.getInputStream());
			manager = new ClientMessageInterpretor(this);
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
			JOptionPane.showMessageDialog(null, "Server is not reachable.",
					"Error", JOptionPane.ERROR_MESSAGE);
		}
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
		try {
			if (output == null) {
				output = new ObjectOutputStream(client.getOutputStream());
			}
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
		}
	}

	@Override
	public void interrupt() {
		if (client.isConnected()) {
			LOGGER.info("Sending dissconnect message to the server.");
			sendMessage(new Message("", 0, TYPE.DISCONNECT, ClientInfo
					.getInstance().getUserName()));
		}
		super.interrupt();
	}
}
