package com.sirma.itt.javacourse.chat.server.threads;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JTextArea;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.chat.server.manager.ChatRoomManager;
import com.sirma.itt.javacourse.chat.server.manager.UserManager;

/**
 * 
 * @author siliev
 * 
 */
public class MainServerThread extends Thread {

	private Logger log = Logger.getLogger(MainServerThread.class);
	private ServerSocket server;
	private UserManager userManager;
	// private ChatRoomManager chatRoomManager;
	private JTextArea messageArea;

	public MainServerThread(JTextArea messageArea) {
		this.messageArea = messageArea;
	}

	@Override
	public void run() {
		log.info("Server thread started");
		startServer();
		acceptConnections();
	}

	protected void startServer() {
		// server = SocketGenerator.createServerSocket();
		try {
			server = new ServerSocket(7000);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
		userManager = UserManager.getInstance();
		ChatRoomManager.getInstance();
		log.info("startServer");
		displayMessage("Server has started");
	}

	protected void acceptConnections() {
		log.info("acceptConnections");
		while (!isInterrupted()) {
			try {
				Socket client = server.accept();
				log.info("Client has connected");
				userManager.acceptUser(client);
			} catch (IOException e) {
				log.error(e.getMessage(), e);
			}
		}
	}

	/**
	 * Stops the server thread and cleans up the resources.
	 */
	public void stopServer() {
		try {
			log.info("Stopping server");
			displayMessage("Stoping server");
			server.close();
			interrupt();
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
	}

	public void displayMessage(String message) {
		messageArea.setText(messageArea.getText() + "/n" + message);
	}
}
