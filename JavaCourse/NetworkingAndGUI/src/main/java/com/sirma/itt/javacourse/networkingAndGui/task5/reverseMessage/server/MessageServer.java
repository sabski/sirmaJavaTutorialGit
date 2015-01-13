package com.sirma.itt.javacourse.networkingAndGui.task5.reverseMessage.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.networkingAndGui.AbstractServer;

/**
 * Message server class accepts a user connection receives and sends user
 * messages.
 * 
 * @author Simeon Iliev
 */
public class MessageServer extends AbstractServer {

	private static final Logger LOGGER = Logger.getLogger(MessageServer.class);
	private ServerSocket server;
	private Socket client;
	private ObjectOutputStream outputStream;
	private ObjectInputStream inputStream;
	private List<UserThread> users = new ArrayList<UserThread>();

	@Override
	public void run() {
		startServer();
		acceptConnections();
	}

	/**
	 * Starts the server socket.
	 */
	public void startServer() {
		try {
			server = new ServerSocket(7000);
			displayMessage("Server is starting.");
			LOGGER.info("Server is starting");
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		}

	}

	/**
	 * Stops the server and closes the server and client socket.
	 */
	public void stopServer() {
		if (server != null) {
			try {
				users.clear();
				server.close();
				if (client != null) {
					client.close();
				}
				displayMessage("Server is stopped");
				LOGGER.info("Server is stopping");
				interrupt();
			} catch (IOException e) {
				LOGGER.error(e.getMessage(), e);
			}
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
	public void acceptConnections() {
		while (!isInterrupted()) {
			try {
				client = server.accept();
				outputStream = new ObjectOutputStream(client.getOutputStream());
				inputStream = new ObjectInputStream(client.getInputStream());
				UserThread user = new UserThread(client, outputStream,
						inputStream);
				user.sendUserMessage("Welcome client");
				users.add(user);
				user.start();
			} catch (IOException e) {
				LOGGER.error(e.getMessage(), e);
				displayMessage(e.getMessage());
			}
		}
	}
}
