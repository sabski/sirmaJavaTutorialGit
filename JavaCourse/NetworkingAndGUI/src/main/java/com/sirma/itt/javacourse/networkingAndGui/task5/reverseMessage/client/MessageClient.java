package com.sirma.itt.javacourse.networkingAndGui.task5.reverseMessage.client;

import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JTextArea;

import org.apache.log4j.Logger;

/**
 * @author Simeon Iliev
 */
public class MessageClient extends Thread {

	private static Logger log = Logger.getLogger(MessageClient.class);
	private Socket client;
	private final MessageClientGUI clientGUI;
	private final JTextArea messageArea;
	private ObjectInputStream reader;
	private ObjectOutputStream output;

	public void startClient() {
		try {
			client = new Socket("localhost", 7000);
			reader = new ObjectInputStream(client.getInputStream());
			output = new ObjectOutputStream(client.getOutputStream());
			displayMessage("Attempting to connect to server.");
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			displayMessage(e.getMessage());
		}
	}

	public void stopClient() {
		try {
			client.close();
			displayMessage("Client is stopping !!!");
			Thread.sleep(1 * 1000);
			clientGUI.dispatchEvent(new WindowEvent(clientGUI, WindowEvent.WINDOW_CLOSING));
		} catch (IOException | InterruptedException e) {
			log.error(e.getMessage(), e);
			displayMessage(e.getMessage());
		}
		interrupt();
	}

	public void receiveServerMessages() {
		try {
			String message;
			while (!client.isClosed()) {
				message = (String) reader.readObject();
				if (message != null) {
					displayMessage(message);
				}
			}
		} catch (IOException | ClassNotFoundException e) {
			log.error(e.getMessage(), e);
			stopClient();
		}
	}

	public void sendMessageToServer(String messageToSend) {
		try {
			output.writeObject(messageToSend);
			output.flush();
			output.reset();
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
	}

	public void displayMessage(String messageToDisplay) {
		log.info(messageToDisplay);
		messageArea.setText(messageArea.getText() + "\n" + messageToDisplay);
	}

	/**
	 * @param clientGUI
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
