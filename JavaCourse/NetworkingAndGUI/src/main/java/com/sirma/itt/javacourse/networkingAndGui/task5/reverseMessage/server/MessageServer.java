package com.sirma.itt.javacourse.networkingAndGui.task5.reverseMessage.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JTextArea;

import org.apache.log4j.Logger;

/**
 * @author Simeon Iliev
 */
public class MessageServer extends Thread {

	private static Logger log = Logger.getLogger(MessageServer.class);
	private final JTextArea messageArea;
	private final MessageServerGUI serverGUI;
	private ServerSocket server;
	private Socket client;
	private ObjectOutputStream outputStream;
	private ObjectInputStream inputStream;

	public void readClientMessage() {
		String line = null;
		try {
			while ((line = (String) inputStream.readObject()) != null) {
				sendUserMessage(client, writeRevеrsedMessage(line));
			}
		} catch (ClassNotFoundException | IOException e) {
			log.error(e.getMessage(), e);
		}
	}

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

	public void startServer() {
		try {
			server = new ServerSocket(7000);

			displayMessage("Server is starting.");
			log.info("Server is starting");
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}

	}

	public void acceptClientConnection() {
		try {
			client = server.accept();
			outputStream = new ObjectOutputStream(client.getOutputStream());
			inputStream = new ObjectInputStream(client.getInputStream());
			sendUserMessage(client, "Welcome client");
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			displayMessage(e.getMessage());
		}
	}

	private void sendUserMessage(Socket client, String message) {
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

	public void stopServer() {
		if (server != null) {
			try {
				server.close();
				client.close();
				displayMessage("Server is stopped");
				log.info("Server is stopping");
			} catch (IOException e) {
				log.error(e.getMessage(), e);
				displayMessage(e.getMessage());
			}
		}
	}

	public void displayMessage(String message) {
		messageArea.setText(messageArea.getText() + "\n" + message);
	}

	/**
	 * @param serverGUI
	 */
	public MessageServer(MessageServerGUI serverGUI) {
		this.serverGUI = serverGUI;
		this.messageArea = serverGUI.getMessageArea();
	}

}
