package com.sirma.itt.javacourse.networkingAndGui.task4.clientInformation.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import javax.swing.JTextArea;

import org.apache.log4j.Logger;

/**
 * @author Simeon Iliev
 */
public class InformationClient extends Thread {

	private static final Logger log = Logger.getLogger(InformationClient.class);
	private Socket client;
	private final JTextArea messageArea;
	private ObjectInputStream reader;

	/**
	 * 
	 */
	public InformationClient(JTextArea messageArea) {
		this.messageArea = messageArea;
	}

	public void connect() {
		try {
			client = new Socket("localhost", 7000);
			reader = new ObjectInputStream(client.getInputStream());
			sendMessage("Attempting to connect to server.");
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			sendMessage(e.getMessage());
		}

	}

	public void readFromServer() {

		

		try {
			String message;
			while ((message = (String) reader.readObject()) != null) {
				sendMessage(message);
				System.err.println();
			}

		} catch (IOException | ClassNotFoundException e) {
			log.error(e.getMessage(), e);
		}
	}

	public void stopClient() {
		try {
			client.close();
			sendMessage("Client is stopping !!!");
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			sendMessage(e.getMessage());
		}

	}

	private void sendMessage(String message) {
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
