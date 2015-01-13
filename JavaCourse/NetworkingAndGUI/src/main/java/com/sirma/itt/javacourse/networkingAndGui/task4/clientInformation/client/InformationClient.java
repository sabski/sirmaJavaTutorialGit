package com.sirma.itt.javacourse.networkingAndGui.task4.clientInformation.client;

import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import javax.swing.JTextArea;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.SocketGenerator;

/**
 * Information client this class connects to a server, and receives messages.
 * 
 * @author Simeon Iliev
 */
public class InformationClient extends Thread {

	private static final Logger LOGGER = Logger
			.getLogger(InformationClient.class);
	private final InformationClientGUI clientGUI;
	private final JTextArea messageArea;
	private Socket client;
	private ObjectInputStream reader;

	/**
	 * Basic constructor for the information client.
	 * 
	 * @param messageArea
	 *            the message area that the server will send messages.
	 */
	public InformationClient(InformationClientGUI clientGUI) {
		this.messageArea = clientGUI.getMessageWingow();
		this.clientGUI = clientGUI;
	}

	/**
	 * Connects the client to the server.
	 */
	public void connect() {
		displayMessage("Attempting to connect to server.");
		client = SocketGenerator.createSocket();
		if (client == null) {
			displayMessage("Cant connect to server.");
			return;
		}
		try {
			reader = new ObjectInputStream(client.getInputStream());
			readFromServer();
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
			displayMessage(e.getMessage());
		}

	}

	/**
	 * Reads messages from the server.
	 */
	public void readFromServer() {
		try {
			String message;
			while (!client.isClosed()) {
				message = (String) reader.readObject();
				if (message != null) {
					displayMessage(message);
				}
			}
		} catch (IOException | ClassNotFoundException e) {
			LOGGER.error(e.getMessage(), e);
			stopClient();
		}
	}

	/**
	 * Stops the thread and closes the client socket.
	 */
	public void stopClient() {
		try {
			client.close();
			displayMessage("Client will close in 5 seconds.");
			Thread.sleep(5 * 1000);
			clientGUI.dispatchEvent(new WindowEvent(clientGUI,
					WindowEvent.WINDOW_CLOSING));
			interrupt();
		} catch (IOException | InterruptedException e) {
			LOGGER.error(e.getMessage(), e);
			displayMessage(e.getMessage());
		}

	}

	/**
	 * Sends a message to UI message area.
	 * 
	 * @param message
	 *            the message to be send to the UI.
	 */
	private void displayMessage(String message) {
		LOGGER.info(message);
		messageArea.setText(messageArea.getText() + "\n" + message);
	}

	@Override
	public void run() {
		connect();
	}

}
