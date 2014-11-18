package com.sirma.itt.javacourse.networkingAndGui.task3.serverClientTalk.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.Logger;

/**
 * @author Simeon Iliev
 */
public class DateServer {

	private static Logger log = Logger.getLogger(DateServer.class);

	private ServerSocket server;
	private Socket client;

	/**
	 * 
	 */
	public String startServer() {
		try {
			server = new ServerSocket(7000);
			return "Server started";
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			return e.getMessage();
		}

	}

	/**
	 * 
	 */
	public void stopServer() {
		if (server != null) {
			try {
				server.close();
			} catch (IOException e) {
				log.error(e.getMessage(), e);
			}
		}
	}

	public void accepConnection() {
		while (true) {
			try {
				client = server.accept();
			} catch (IOException e) {
				log.error(e.getMessage(), e);
			}

			new DateServerThread(client).start();
		}
	}
}
