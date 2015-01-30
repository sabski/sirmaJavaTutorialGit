package com.sirma.itt.javacourse.chat.server.threads;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.chat.server.controler.ServerController;
import com.sirma.itt.javacourse.chat.server.manager.UserManager;

/**
 * The main server thread that starts the server and accepts connections.
 * 
 * 
 * @author siliev
 * 
 */
public class MainServerThread extends Thread {

	private static final Logger LOGGER = Logger
			.getLogger(MainServerThread.class);
	private ServerSocket server;
	private UserManager userManager;
	private ServerController controler;
	private int port;

	/**
	 * Constructor for the main server thread.
	 * 
	 * @param messageArea
	 *            the message area of the UI.
	 */
	public MainServerThread(ServerController controler, int port) {
		this.port = port;
		this.controler = controler;
	}

	@Override
	public void run() {
		LOGGER.info("Server thread started");
		startServer(port);
		acceptConnections();
	}

	/**
	 * Starts the server.
	 * 
	 * @param port
	 *            the port on which to start the server.
	 */
	protected void startServer(int port) {
		try {
			server = new ServerSocket(port);
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		}
		userManager = new UserManager(controler);
		LOGGER.info("startServer");
		displayMessage("Server has started");
	}

	/**
	 * Accepts client connections and starts confirmation dialog.
	 */
	protected void acceptConnections() {
		LOGGER.info("acceptConnections");
		while (!isInterrupted()) {
			try {
				Socket client = server.accept();
				LOGGER.info("Client has connected");
				displayMessage("Client has connected");
				userManager.acceptUser(client);
			} catch (IOException e) {
				LOGGER.error(e.getMessage(), e);
			}
		}
	}

	/**
	 * Stops the server thread and cleans up the resources.
	 */
	public void stopServer() {
		try {
			LOGGER.info("Stopping server");
			displayMessage("Stoping server");
			userManager.disconnectAllUsers();
			server.close();
			interrupt();
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		}
	}

	/**
	 * Displays an information message on to the server UI.
	 * 
	 * @param message
	 *            the message we want to display on to the UI.
	 */
	public void displayMessage(String message) {
		controler.displayMessage(message);
	}
}
