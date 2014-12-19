package com.sirma.itt.javacourse.networkingAndGui.task3.serverClientTalk.server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.SocketGenerator;
import com.sirma.itt.javacourse.networkingAndGui.AbstractServer;

/**
 * Date server class that is opened on port 7000. This class accepts connections
 * from new clients And sends them the server Date.
 * 
 * @author Simeon Iliev
 */
public class DateServer extends AbstractServer {

	private static Logger log = Logger.getLogger(DateServer.class);

	private ServerSocket server;

	private Socket client;
	private boolean isRunning;

	public void startServer() {
		server = SocketGenerator.createServerSocket();
		isRunning = true;
		displayMessage("Server started");
	}

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
		getTextArea().setText(getTextArea().getText() + "\n" + message);
	}

	@Override
	public void run() {
		startServer();
		acceptConnections();
	}

	@Override
	public void acceptConnections() {
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
}
