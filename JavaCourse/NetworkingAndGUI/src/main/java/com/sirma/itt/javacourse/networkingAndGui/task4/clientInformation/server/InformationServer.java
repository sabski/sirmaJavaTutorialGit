package com.sirma.itt.javacourse.networkingAndGui.task4.clientInformation.server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JTextArea;

import org.apache.log4j.Logger;

/**
 * Server class whose job is to receive client connections and send user the number there are on the
 * server.
 * 
 * @author Simeon Iliev
 */
public class InformationServer extends Thread {

	private static Logger log = Logger.getLogger(InformationServer.class);

	private ServerSocket server;
	private Socket client;
	private int clientNumber;
	private final Map<Socket, OutputStream> clientList;
	private final JTextArea messageArea;

	/**
	 * Basic constructor.
	 */
	public InformationServer(JTextArea messageArea) {
		this.clientNumber = 0;
		this.clientList = new HashMap<Socket, OutputStream>();
		this.messageArea = messageArea;

	}

	/**
	 * Start the server on local port 7000.
	 */
	public void startServer() {
		try {
			server = new ServerSocket(7000);
			displayMessage("Server is starting.");
			log.info("Server is starting");
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
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
	 * Stops the thread and closes the server socket.
	 */
	public void stopServer() {
		for (Entry<Socket, OutputStream> clientPair : clientList.entrySet()) {
			try {
				ObjectOutputStream oStream = (ObjectOutputStream) clientPair.getValue();
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
		acceptConnetion();
	}

	/**
	 * This method allows the server to continuously accept connections to the server until the
	 * thread is interrupted.
	 */
	public void acceptConnetion() {
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
				outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
				outputStream.writeObject("You are client number " + clientNumber);
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
				ObjectOutputStream oStream = (ObjectOutputStream) clientPair.getValue();
				oStream.writeObject("Client number " + clientNumber + " has connected.");
				oStream.flush();
			} catch (IOException e) {
				log.error(e.getMessage(), e);
			}
		}
		clientList.put(clientSocket, outputStream);
	}

}
