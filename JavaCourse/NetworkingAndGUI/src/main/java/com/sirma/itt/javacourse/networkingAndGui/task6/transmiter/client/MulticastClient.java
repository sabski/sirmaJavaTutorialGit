package com.sirma.itt.javacourse.networkingAndGui.task6.transmiter.client;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.Socket;

import javax.swing.JTextArea;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.SocketGenerator;

/**
 * A client that connects to a server and listens to a multicast addresses for
 * for messages.
 * 
 * @author siliev
 * 
 */
public class MulticastClient extends Thread {

	private static final Logger LOGGER = Logger.getLogger(MulticastClient.class);
	private MulticastSocket multicastClient;
	private Socket client;
	private String group = "225.4.5.6";
	private JTextArea messageArea;

	/**
	 * Listens to the multicast messages and displays that a message was
	 * received.
	 */
	public void readPackegeData() {
		try {
			multicastClient = new MulticastSocket(7005);
			multicastClient.joinGroup(InetAddress.getByName(group));
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		}
		while (!multicastClient.isConnected()) {
			byte[] buffer = new byte[1024];
			DatagramPacket pack = new DatagramPacket(buffer, buffer.length);
			try {
				multicastClient.receive(pack);
				LOGGER.info("reseived " + pack.toString());
				ByteArrayInputStream byteStream = new ByteArrayInputStream(
						buffer);
				ObjectInputStream is = new ObjectInputStream(
						new BufferedInputStream(byteStream));
				Object o = is.readObject();
				displayMessage("packege reseived " + o.toString());
			} catch (IOException e) {
				LOGGER.error(e.getMessage(), e);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Reads the multicast address that the server has assigned to this client
	 * to listen to.
	 */
	private void readMulticastAddress() {
		try {
			ObjectInputStream reader = new ObjectInputStream(
					client.getInputStream());
			String message = (String) reader.readObject();
			if (message != null) {
				LOGGER.info(message);
				group = message;
				displayMessage("Multicast listeing addres is " + message);

			}

		} catch (IOException | ClassNotFoundException e) {
			LOGGER.error(e.getMessage(), e);
			stopClient();
		}
	}

	/**
	 * Stops listening to the multicast broadcast, and closes the socket.
	 */
	void stopClient() {
		if (multicastClient != null && multicastClient.isConnected()) {
			multicastClient.close();
		}
		try {
			client.close();
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
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
		LOGGER.info("Client started");
		connect();

	}

	/**
	 * Connects to the server.
	 */
	private void connect() {
		displayMessage("Attempting to connect to server");
		client = SocketGenerator.createSocket();
		if (client == null) {
			displayMessage("Cant connect to server.");
			return;
		}
		readMulticastAddress();
		readPackegeData();
	}

	/**
	 * Constructor.
	 * 
	 * @param multicastClientUI
	 *            the UI
	 * 
	 */
	public MulticastClient(MulticastClientUI multicastClientUI) {

		messageArea = multicastClientUI.getMessageWingow();
	}
}
