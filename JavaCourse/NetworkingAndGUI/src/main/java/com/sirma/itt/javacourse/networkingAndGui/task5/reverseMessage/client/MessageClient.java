package com.sirma.itt.javacourse.networkingAndGui.task5.reverseMessage.client;

import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JTextArea;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.networkingAndGui.task5.reverseMessage.server.MessageServer;

/**
 * Class that connects to {@link MessageServer} server and send and receives
 * messages from the server. This class is able capable of updating the UI it is
 * attached to.
 * 
 * @author Simeon Iliev
 */
public class MessageClient extends Thread {

	private static final Logger LOGGER = Logger.getLogger(MessageClient.class);
	private final MessageClientGUI clientGUI;
	private final JTextArea messageArea;
	private Socket client;
	private ObjectInputStream input;
	private ObjectOutputStream output;

	/**
	 * Connects the client to the server and opens the input and output stream.
	 */
	public void startClient() {
		displayMessage("Attempting to connect to server.");
		try {
			client = new Socket("localhost", 7000);
			input = new ObjectInputStream(client.getInputStream());
			output = new ObjectOutputStream(client.getOutputStream());
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
			displayMessage(e.getMessage());
		}
	}

	/**
	 * Stops the client connection, when the connection is broken or the user
	 * has closed the window.
	 */
	public void stopClient() {
		try {
			client.close();
			displayMessage("Client will stop in 5 seconds.");
			Thread.sleep(5 * 1000);
			clientGUI.dispatchEvent(new WindowEvent(clientGUI,
					WindowEvent.WINDOW_CLOSING));
			LOGGER.info(isAlive());
			interrupt();
		} catch (IOException | InterruptedException e) {
			LOGGER.error(e.getMessage(), e);
			displayMessage(e.getMessage());
		}

	}

	/**
	 * Listens to the server input stream for incoming messages and prints them
	 * on the UI;
	 */
	public void receiveServerMessages() {
		try {
			String message;
			while (!client.isClosed()) {
				message = (String) input.readObject();
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
	 * Sends a message to the server. After the reset is send the buffer is
	 * reset so that the stream may be reused.
	 * 
	 * @param messageToSend
	 *            the message to send to the server.
	 */
	public void sendMessageToServer(String messageToSend) {
		if (messageToSend.equals(".")) {
			stopClient();
		} else {
			try {
				output.writeObject(messageToSend);
				output.flush();
				output.reset();
			} catch (IOException e) {
				LOGGER.error(e.getMessage(), e);
				displayMessage(e.getMessage());
			}
		}
	}

	/**
	 * Prints a message to the UI message area.
	 * 
	 * @param messageToDisplay
	 *            the message that is to be send to the UI.
	 */
	public void displayMessage(String messageToDisplay) {
		LOGGER.info(messageToDisplay);
		messageArea.setText(messageArea.getText() + "\n" + messageToDisplay);
	}

	/**
	 * Constructor with {@link MessageClientGUI} parameter so that the class can
	 * send messages to the UI and signals.
	 * 
	 * @param clientGUI
	 *            the UI that uses this client.
	 */
	public MessageClient(MessageClientGUI clientGUI) {
		this.clientGUI = clientGUI;
		this.messageArea = clientGUI.getMessageArea();
	}

	@Override
	public void run() {
		startClient();
		receiveServerMessages();
	}

}
