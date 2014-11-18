package com.sirma.itt.javacourse.networkingAndGui.task3.serverClientTalk.client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

import org.apache.log4j.Logger;

/**
 * @author Simeon Iliev
 */
public class ClientSoket {

	private static Logger log = Logger.getLogger(ClientSoket.class);

	private Socket clientSideSocket;

	/**
	 * @return
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
	 * @return
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
	 * @return
	 */
	public String message() {
		try (DataInputStream reader = new DataInputStream(clientSideSocket.getInputStream());) {
			return "Server time is " + reader.readUTF();
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			return e.getMessage();
		}
	}
}
