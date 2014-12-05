package com.sirma.itt.javacourse.networkingAndGui.task6.transmiter.client;

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

	private static Logger log = Logger.getLogger(MulticastClient.class);
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
			log.error(e.getMessage(), e);
		}
		while (!multicastClient.isConnected()) {
			byte[] buffer = new byte[1024];
			DatagramPacket pack = new DatagramPacket(buffer, buffer.length);
			try {
				multicastClient.receive(pack);
				log.info("reseived " + pack.toString());

				displayMessage("packege reseived " + pack.toString());
			} catch (IOException e) {
				log.error(e.getMessage(), e);
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
				log.info(message);
				group = message;
				displayMessage("Multicast listeing addres is " + message);

			}

		} catch (IOException | ClassNotFoundException e) {
			log.error(e.getMessage(), e);
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
			log.error(e.getMessage(), e);
		}

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

	@Override
	public void run() {
		log.info("Client started");
		connect();
		readMulticastAddress();
		readPackegeData();
	}

	/**
	 * Connects to the server.
	 */
	private void connect() {
		client = SocketGenerator.createSocket();
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
