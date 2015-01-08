package com.sirma.itt.javacourse.networkingAndGui.task3.serverClientTalk.client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JTextArea;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.SocketGenerator;
import com.sirma.itt.javacourse.networkingAndGui.task3.serverClientTalk.server.DateServer;

/**
 * Client that connects to the {@link DateServer} and receives a message from
 * it.
 * 
 * @author Simeon Iliev
 */
public class DateClient extends Thread {

	private static final Logger LOGGER = Logger.getLogger(DateClient.class);

	private Socket clientSideSocket;
	private JTextArea textArea;

	/**
	 * Constructor using text area.
	 * 
	 * @param textArea
	 *            the text area to display messages.
	 */
	public DateClient(JTextArea textArea) {
		this.textArea = textArea;
	}

	/**
	 * Connects the server.
	 * 
	 * @return a message whether or not the connection was established.
	 */
	public void connect() {
		clientSideSocket = SocketGenerator.createSocket();
		if (clientSideSocket == null) {
			displayMessage("Cant connect to server, try again");
			return;
		}
		displayMessage("Connected to server");
	}

	/**
	 * Disconnects the client from the server.
	 * 
	 * @return a disconnect message if the client was properly disconnected.
	 */
	public void disconnect() {
		if (clientSideSocket != null) {
			try {
				clientSideSocket.close();
				displayMessage("Disconnected");
			} catch (IOException e) {
				LOGGER.error(e.getMessage(), e);
			}
		}
	}

	/**
	 * Retrieves the message from the server.
	 * 
	 * @return the message that was sent from the server or an error message if
	 *         the server message Can't Be retrieved.
	 */
	public void getMessage() {
		try (DataInputStream reader = new DataInputStream(
				clientSideSocket.getInputStream());) {
			displayMessage(reader.readUTF());
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		}
	}

	public void displayMessage(String message) {
		textArea.setText(textArea.getText() + "\n" + message);
		textArea.invalidate();
	}

	@Override
	public void run() {
		displayMessage("Attempting to connect to server please wait...");
		connect();
		if (clientSideSocket != null) {
			getMessage();
			disconnect();
		}
	}
}
