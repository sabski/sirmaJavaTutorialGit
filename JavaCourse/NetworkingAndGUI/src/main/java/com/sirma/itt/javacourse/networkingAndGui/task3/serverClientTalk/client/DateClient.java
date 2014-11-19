package com.sirma.itt.javacourse.networkingAndGui.task3.serverClientTalk.client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.networkingAndGui.task3.serverClientTalk.server.DateServer;

/**
 * Client that connects to the {@link DateServer} and receives a message from it.
 * 
 * @author Simeon Iliev
 */
public class DateClient {

	private static Logger log = Logger.getLogger(DateClient.class);

	private Socket clientSideSocket;

	/**
	 * Connects the server.
	 * 
	 * @return a message whether or not the connection was established.
	 */
	public String connect() {
		try {
			clientSideSocket = new Socket("localhost", 7000);
			return "Connected to server";
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			return e.getMessage();
		}
	}

	/**
	 * Disconnects the client from the server.
	 * 
	 * @return a disconnect message if the client was properly disconnected.
	 */
	public String disconnect() {
		if (clientSideSocket != null) {
			try {
				clientSideSocket.close();
				return "Disconnected";
			} catch (IOException e) {
				log.error(e.getMessage(), e);
				return e.getMessage();
			}
		}
		return "There is no active connection";
	}

	/**
	 * Retrieves the message from the server.
	 * 
	 * @return the message that was sent from the server or an error message if the server message
	 *         Can't Be retrieved.
	 */
	public String getMessage() {
		try (DataInputStream reader = new DataInputStream(clientSideSocket.getInputStream());) {
			return "Server time is " + reader.readUTF();
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			return e.getMessage();
		}
	}
}
