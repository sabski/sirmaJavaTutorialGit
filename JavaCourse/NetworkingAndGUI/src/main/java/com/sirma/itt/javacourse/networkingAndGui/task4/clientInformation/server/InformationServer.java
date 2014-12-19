package com.sirma.itt.javacourse.networkingAndGui.task4.clientInformation.server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.SocketGenerator;
import com.sirma.itt.javacourse.networkingAndGui.AbstractServer;

/**
 * Server class whose job is to receive client connections and send user the
 * number there are on the server.
 * 
 * @author Simeon Iliev
 */
public class InformationServer extends AbstractServer {

	private static Logger log = Logger.getLogger(InformationServer.class);

	private ServerSocket server;
	private Socket client;
	private int clientNumber;
	private final Map<Socket, OutputStream> clientList;

	/**
	 * Basic constructor.
	 */
	public InformationServer() {
		this.clientNumber = 0;
		this.clientList = new HashMap<Socket, OutputStream>();
	}

	/**
	 * Start the server on local port 7000.
	 */
	public void startServer() {
		server = SocketGenerator.createServerSocket();
		displayMessage("Server is starting.");
		log.info("Server is starting");
	}

	@Override
	public void displayMessage(String message) {
		getTextArea().setText(getTextArea().getText() + "\n" + message);
	}

	/**
	 * Stops the thread and closes the server socket.
	 */
	public void stopServer() {
		for (Entry<Socket, OutputStream> clientPair : clientList.entrySet()) {
			try {
				ObjectOutputStream oStream = (ObjectOutputStream) clientPair
						.getValue();
				oStream.writeObject("Server is stopping");
				oStream.flush();
				clientPair.getKey().close();
			} catch (IOException e) {
				log.error(e.getMessage(), e);
			}
		}
		if (server != null) {
			try {
				server.close();
				clientNumber = 0;
				clientList.clear();
				displayMessage("Server is stopped");
				log.info("Server is stopping");
			} catch (IOException e) {
				log.error(e.getMessage(), e);
				displayMessage(e.getMessage());
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		startServer();
		acceptConnections();
	}

	/**
	 * Send the client the server date message;
	 * 
	 * @param clientSocket
	 *            the client to which the message will be sent.
	 */
	protected void sendUserMessage(Socket clientSocket) {
		ObjectOutputStream outputStream = null;
		if (clientSocket != null) {
			try {
				outputStream = new ObjectOutputStream(
						clientSocket.getOutputStream());
				outputStream.writeObject("You are client number "
						+ clientNumber);
				log.info("New client has connected : " + clientNumber);
				outputStream.flush();
				displayMessage("New client has connected : " + clientNumber);
			} catch (IOException e) {
				log.error(e.getMessage(), e);
				displayMessage(e.getMessage());
			}
		}
		for (Entry<Socket, OutputStream> clientPair : clientList.entrySet()) {
			try {
				ObjectOutputStream oStream = (ObjectOutputStream) clientPair
						.getValue();
				oStream.writeObject("Client number " + clientNumber
						+ " has connected.");
				oStream.flush();
			} catch (IOException e) {
				log.error(e.getMessage(), e);
			}
		}
		clientList.put(clientSocket, outputStream);
	}

	@Override
	public void acceptConnections() {
		while (!server.isClosed()) {
			try {
				client = server.accept();
				clientNumber++;
				sendUserMessage(client);
			} catch (IOException e) {
				log.error(e.getMessage(), e);
				displayMessage(e.getMessage());
			}
		}

	}

}
