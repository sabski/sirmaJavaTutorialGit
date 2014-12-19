package com.sirma.itt.javacourse.networkingAndGui.task6.transmiter.server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import com.sirma.itt.javacourse.SocketGenerator;
import com.sirma.itt.javacourse.networkingAndGui.AbstractServer;
import com.sirma.itt.javacourse.networkingAndGui.task6.transmiter.messagedispacher.AbstractMessageModerator;
import com.sirma.itt.javacourse.networkingAndGui.task6.transmiter.messagedispacher.MessageDispatcher;
import com.sirma.itt.javacourse.networkingAndGui.task6.transmiter.messagedispacher.MulticastAddressSupplier;

/**
 * A server that accepts client connections and gives multicast addresses for
 * the clients to listen to.
 * 
 * @author siliev
 * 
 */
public class MulticastServer extends AbstractServer {

	private static org.apache.log4j.Logger log = org.apache.log4j.Logger
			.getLogger(MulticastServer.class);

	private ServerSocket server;
	private Socket client;
	private MulticastAddressSupplier supplier;
	private AbstractMessageModerator dispacher;
	private Map<InetAddress, MulticastSocket> activeAddresses;

	public void startServer() {
		server = SocketGenerator.createServerSocket();
		log.info("Server started");
		displayMessage("Server started");
	}

	public void stopServer() {
		log.info("Server is stoping");
		displayMessage("Server is stoping");
		activeAddresses.clear();
		try {
			server.close();
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
		dispacher.interrupt();
		interrupt();
	}

	public void acceptConnections() {
		while (!server.isClosed()) {
			try {
				client = server.accept();
				log.info("Client connected");
				InetAddress clientAddress = supplier.getRandomAddress();
				dispacher.addChanell(clientAddress);
				sendClientMulticastAddress(client, clientAddress);
			} catch (IOException e) {
				log.error(e.getMessage(), e);
				displayMessage(e.getMessage());
			}
		}

	}

	/**
	 * Sends the client a multicast address to listen to.
	 * 
	 * @param clientSocket
	 *            the client we want to send the address to.
	 * @param address
	 *            the multicast address that is to be send to the client.
	 */
	public void sendClientMulticastAddress(Socket clientSocket,
			InetAddress address) {
		ObjectOutputStream outputStream = null;
		if (clientSocket != null) {
			try {
				outputStream = new ObjectOutputStream(
						clientSocket.getOutputStream());
				outputStream.writeObject(address.getCanonicalHostName());
				log.info("Address given to client :"
						+ address.getCanonicalHostName());
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

	public void displayMessage(String message) {
		getTextArea().setText(getTextArea().getText() + "\n" + message);
	}

	/**
	 * Basic constructor.
	 * 
	 * @param messageArea
	 *            the message area of the UI so that events on the server may be
	 *            displayed.
	 */
	public MulticastServer() {
		supplier = new MulticastAddressSupplier();
		activeAddresses = new HashMap<InetAddress, MulticastSocket>();
		dispacher = new MessageDispatcher();
		dispacher.start();
	}
}
