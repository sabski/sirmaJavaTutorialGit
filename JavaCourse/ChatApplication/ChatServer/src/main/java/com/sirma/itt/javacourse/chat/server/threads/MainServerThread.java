package com.sirma.itt.javacourse.chat.server.threads;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.SocketGenerator;
import com.sirma.itt.javacourse.chat.common.ChatUser;

/**
 * 
 * @author siliev
 * 
 */
public class MainServerThread extends Thread {

	private Logger log = Logger.getLogger(MainServerThread.class);
	private ServerSocket server;
	private List<ChatUser> userList;

	@Override
	public void run() {
		log.info("Server thread started");
		startServer();
		acceptConnections();
	}

	protected void startServer() {
		server = SocketGenerator.createServerSocket();
		userList = new ArrayList<>();
	}

	protected void acceptConnections() {
		while (!isInterrupted()) {
			try {
				Socket client = server.accept();
				// TODO Verify client name and give feedback to the client.
				userList.add(new ChatUser("Test", client));
				log.info("Client has connected");
			} catch (IOException e) {
				log.error(e.getMessage(), e);
			}
		}
	}

	protected void stopServer() {
		try {
			log.info("Stopping server");
			server.close();
			interrupt();
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
	}

}
