package com.sirma.itt.javacourse.chat.server.threads;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.SocketGenerator;
import com.sirma.itt.javacourse.chat.common.ChatUser;
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

	@Override
	public void run() {
		log.info("Server thread started");
		startServer();
		acceptConnections();
	}

	protected void startServer() {
		//server = SocketGenerator.createServerSocket();
		try {
			server = new ServerSocket(7000);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
		userManager = UserManager.getInstance();
		log.info("startServer");
	}

	protected void acceptConnections() {
		log.info("acceptConnections");
		while (!isInterrupted()) {
			try {
				Socket client = server.accept();
				log.info("Client has connected");
				// TODO Verify client name and give feedback to the client.
				String userName = readUserName(client);
				ChatUser user = new ChatUser(userName, client);
				if (userManager.addUser(user)) {
					log.info("User has joined the server " + user.getUsername());
					// TODO Notify users that new user has joined.
				} else {
					// TODO Send wrong user name
					log.info("DENIED USER : " + userName);
				}
			} catch (IOException e) {
				log.error(e.getMessage(), e);
			}
		}
	}

	private String readUserName(Socket socket) {
		String line = null;
		try {
			ObjectInputStream inputStream = new ObjectInputStream(
					socket.getInputStream());
			line = (String) inputStream.readObject();
		} catch (ClassNotFoundException | IOException e) {
			log.error(e.getMessage(), e);
		}
		log.info("Line read : " + line);
		return line;
	}

	/**
	 * Stops the server thread and cleans up the resources.
	 */
	public void stopServer() {
		try {
			log.info("Stopping server");
			server.close();
			interrupt();
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
	}

}
