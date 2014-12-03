package com.sirma.itt.javacourse.networkingAndGui.task6.transmiter.server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JTextArea;

import com.sirma.itt.javacourse.networkingAndGui.task6.transmiter.messagedispacher.MessageDispacher;
import com.sirma.itt.javacourse.networkingAndGui.task6.transmiter.messagedispacher.MulticastAddressSupplier;

/**
 * @author siliev
 * 
 */
public class MulticastServer extends Thread {

	private static org.apache.log4j.Logger log = org.apache.log4j.Logger
			.getLogger(MulticastServer.class);

	private ServerSocket server;
	private Socket client;
	private MulticastAddressSupplier supplier;
	private MessageDispacher dispacher;
	private Map<InetAddress, MulticastSocket> activeAddresses;

	private JTextArea messageArea;

	public void startServer() {
		try {
			server = new ServerSocket(7015);
			log.info("Server started");
			displayMessage("Server started");
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			displayMessage(e.getMessage());
		}
	}

	public void stopServer() {
		activeAddresses.clear();
		dispacher.interrupt();
		interrupt();
	}

	public void acceptConnections() {
		while (!server.isClosed()) {
			try {
				client = server.accept();
				InetAddress clientAddress = supplier.getRandomAddress();
				dispacher.addChanell(clientAddress);
				sendClientMulticastAddress(client, clientAddress);
			} catch (IOException e) {
				log.error(e.getMessage(), e);
				displayMessage(e.getMessage());
			}
		}

	}

	public void sendClientMulticastAddress(Socket clientSocket,
			InetAddress address) {
		ObjectOutputStream outputStream = null;
		if (clientSocket != null) {
			try {
				outputStream = new ObjectOutputStream(
						clientSocket.getOutputStream());
				outputStream.writeObject(address.getCanonicalHostName());
				log.info(address.toString());
				displayMessage("Address given to client :"
						+ address.getCanonicalHostName());
				outputStream.flush();
			} catch (IOException e) {
				log.error(e.getMessage(), e);
				displayMessage(e.getMessage());
			}
		}
	}

	@Override
	public void run() {
		startServer();
		acceptConnections();
	}

	/**
	 * Sends a message in the UI message area.
	 * 
	 * @param message
	 *            the message that is to written in the UI.
	 */
	private void displayMessage(String message) {
		messageArea.setText(messageArea.getText() + "\n" + message);
	}

	/**
	 * Basic constructor.
	 * 
	 * @param messageArea
	 */
	public MulticastServer(JTextArea messageArea) {
		supplier = new MulticastAddressSupplier();
		activeAddresses = new HashMap<InetAddress, MulticastSocket>();
		dispacher = new MessageDispacher();
		dispacher.start();
		this.messageArea = messageArea;
	}

}
