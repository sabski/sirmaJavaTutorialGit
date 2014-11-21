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
 * @author Simeon Iliev
 */
public class InfromationServer extends Thread {

	private static Logger log = Logger.getLogger(InfromationServer.class);

	private ServerSocket server;
	private Socket client;
	private int clientNumber;
	private boolean isRunning;
	private final Map<Socket, OutputStream> clientList;
	private final JTextArea messageArea;

	/**
	 * 
	 */
	public InfromationServer(JTextArea messageArea) {
		this.clientNumber = 0;
		this.clientList = new HashMap<Socket, OutputStream>();
		this.messageArea = messageArea;

	}

	public void startServer() {
		try {
			server = new ServerSocket(7000);
			setRunning(true);
			sendMessage("Server is starting.");
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
	}

	private void sendMessage(String message) {
		messageArea.setText(messageArea.getText() + "\n" + message);
	}

	public void stopServer() {
		interrupt();
		if (server != null) {
			try {
				server.close();
				clientNumber = 0;
				clientList.clear();
				sendMessage("Server is stoped");
			} catch (IOException e) {
				log.error(e.getMessage(), e);
				sendMessage(e.getMessage());
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

	public void acceptConnetion() {
		while (!isInterrupted()) {
			try {
				client = server.accept();
				clientNumber++;
				sendUserMessage(client);
			} catch (IOException e) {
				log.error(e.getMessage(), e);
				sendMessage(e.getMessage());
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
		ObjectOutputStream outputStream;
		try {
			outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
			outputStream.writeObject("You are Number " + clientNumber);
			outputStream.flush();
			clientList.put(clientSocket, outputStream);
			sendMessage("New client has connected : " + clientNumber);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			sendMessage(e.getMessage());
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
	}

	/**
	 * Getter method for isRunning.
	 * 
	 * @return the isRunning
	 */
	public boolean isRunning() {
		return isRunning;
	}

	/**
	 * Setter method for isRunning.
	 * 
	 * @param isRunning
	 *            the isRunning to set
	 */
	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

}
