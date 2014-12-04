package com.sirma.itt.javacourse.networkingAndGui.task3.serverClientTalk.server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import javax.swing.JTextArea;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.SocketGenerator;

/**
 * Date server class that is opened on port 7000. This class accepts connections
 * from new clients And sends them the server Date.
 * 
 * @author Simeon Iliev
 */
public class DateServer extends Thread {

	private static Logger log = Logger.getLogger(DateServer.class);

	private ServerSocket server;

	private Socket client;
	private boolean isRunning;
	private JTextArea messageArea;

	/**
	 * Basic constructor.
	 * 
	 * @param messageArea
	 */
	public DateServer(JTextArea messageArea) {
		this.messageArea = messageArea;
	}

	/**
	 * Opens the server socket. After this method is called the method
	 * accepConnection() should be called, to allow user processing. When the
	 * server is started the observers are notified.
	 */
	public void startServer() {
		server = SocketGenerator.createServerSocket();
		isRunning = true;
		displayMessage("Server started");
	}

	/**
	 * Stops the server by closing the connection and stopping the admission of
	 * new clients to the server. Notifies the observers that the server has
	 * stopped or if didn't stop properly.
	 */
	public void stopServer() {
		if (server != null) {
			try {
				isRunning = false;
				server.close();
				displayMessage("Server stopped");
			} catch (IOException e) {
				log.error(e.getMessage(), e);
				displayMessage(e.getMessage());
			}
		}
	}

	/**
	 * Allows the acceptance of connections for the server. Before this method
	 * is called make sure that the startServer() method is called.
	 */
	public void acceptConnection() {
		while (isRunning) {
			try {
				client = server.accept();
			} catch (IOException e) {
				displayMessage(e.getMessage());
			}
			if (isRunning) {
				sendUserMessage(client);
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
		String date = new Date().toString();
		try (DataOutputStream outputStream = new DataOutputStream(
				clientSocket.getOutputStream())) {
			outputStream.writeUTF("Server time is " + date);
			outputStream.flush();
			clientSocket.close();
			displayMessage("New client at date : " + date);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			displayMessage(e.getMessage());
		}
	}

	/**
	 * Displays a message to the UI.
	 * 
	 * @param message
	 *            the message to be displayed on the UI.
	 */
	public void displayMessage(String message) {
		messageArea.setText(messageArea.getText() + "\n" + message);
	}

	@Override
	public void run() {

		startServer();
		acceptConnection();
	}
}
