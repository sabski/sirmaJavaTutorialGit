package com.sirma.itt.javacourse.networkingAndGui.task4.clientInformation.client;

import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import javax.swing.JTextArea;

import org.apache.log4j.Logger;

/**
 * Information client this class connects to a server, and receives messages.
 * 
 * @author Simeon Iliev
 */
public class InformationClient extends Thread {

	private static final Logger log = Logger.getLogger(InformationClient.class);
	private Socket client;
	private final JTextArea messageArea;
	private ObjectInputStream reader;
	private final InformationClientGUI clientGUI;

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
		try {
			client = new Socket("localhost", 7000);
			reader = new ObjectInputStream(client.getInputStream());
			displayMessage("Attempting to connect to server.");
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			displayMessage(e.getMessage());
		}

	}

	/**
	 * Reads messages from the server.
	 */
	public void readFromServer() {
		try {
			String message;
			while ((message = (String) reader.readObject()) != null) {
				displayMessage(message);
			}
		} catch (IOException | ClassNotFoundException e) {
			log.error(e.getMessage(), e);
			stopClient();
		}
	}

	/**
	 * Stops the thread and closes the client socket.
	 */
	public void stopClient() {
		try {
			client.close();
			displayMessage("Client is stopping !!!");
			clientGUI.dispatchEvent(new WindowEvent(clientGUI, WindowEvent.WINDOW_CLOSING));
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			displayMessage(e.getMessage());
		}
		interrupt();
	}

	/**
	 * Sends a message to UI message area.
	 * 
	 * @param message
	 *            the message to be send to the UI.
	 */
	private void displayMessage(String message) {
		log.info(message);
		messageArea.setText(messageArea.getText() + "\n" + message);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		connect();
		readFromServer();
	}

}
