package com.sirma.itt.javacourse.networkingAndGui.task5.reverseMessage.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JTextArea;

import org.apache.log4j.Logger;

/**
 * Message server class accepts a user connection receives and sends user messages.
 * 
 * @author Simeon Iliev
 */
public class MessageServer extends Thread {

	private static Logger log = Logger.getLogger(MessageServer.class);
	private final JTextArea messageArea;
	private ServerSocket server;
	private Socket client;
	private ObjectOutputStream outputStream;
	private ObjectInputStream inputStream;

	/**
	 * Read the client messages and invokes a response to them.
	 */
	public void readClientMessage() {
		String line = null;
		try {
			while ((line = (String) inputStream.readObject()) != null) {
				sendUserMessage(writeRevеrsedMessage(line));
			}
		} catch (ClassNotFoundException | IOException e) {
			log.error(e.getMessage(), e);
		}
	}

	/**
	 * Writes a reverse message that is returned
	 * 
	 * @param message
	 *            the message to be reverted
	 * @return the reverted String.
	 */
	public String writeRevеrsedMessage(String message) {
		StringBuilder reversedMessage = new StringBuilder(message);
		return "The reverse of " + message + " is " + reversedMessage.reverse();
	}

	@Override
	public void run() {
		startServer();
		acceptClientConnection();
		readClientMessage();
	}

	/**
	 * Starts the server socket.
	 */
	public void startServer() {
		try {
			server = new ServerSocket(7000);
			displayMessage("Server is starting.");
			log.info("Server is starting");
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}

	}

	/**
	 * Accepts a single client connection.
	 */
	public void acceptClientConnection() {
		try {
			client = server.accept();
			outputStream = new ObjectOutputStream(client.getOutputStream());
			inputStream = new ObjectInputStream(client.getInputStream());
			sendUserMessage("Welcome client");
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			displayMessage(e.getMessage());
		}
	}

	/**
	 * Sends the connected client a message.
	 * 
	 * @param message
	 *            the message that is to be sent to the client.
	 */
	private void sendUserMessage(String message) {
		if (client != null) {
			try {
				outputStream.writeObject(message);
				log.info("Message was sent : " + message);
				outputStream.flush();
				outputStream.reset();
				displayMessage("Message was sent : " + message);
			} catch (IOException e) {
				log.error(e.getMessage(), e);
				displayMessage(e.getMessage());
			}
		}
	}

	/**
	 * Stops the server and closes the server and client socket.
	 */
	public void stopServer() {
		if (server != null) {
			try {
				server.close();
				if (client != null) {
					client.close();
				}
				displayMessage("Server is stopped");
				log.info("Server is stopping");
			} catch (IOException e) {
				log.error(e.getMessage(), e);
				displayMessage(e.getMessage());
			}
		}
	}

	/**
	 * Displays a message to the UI.
	 * 
	 * @param message
	 *            the message to be displayed on the UI.
	 */
	public void displayMessage(String message) {
		messageArea.setText(messageArea.getText() + "\n" + message);
	}

	/**
	 * Constructor for the server, that takes a {@link MessageServerGUI} as a parameter.
	 * 
	 * @param serverGUI
	 *            the UI of the server.
	 */
	public MessageServer(JTextArea messageArea) {
		this.messageArea = messageArea;
	}

}
