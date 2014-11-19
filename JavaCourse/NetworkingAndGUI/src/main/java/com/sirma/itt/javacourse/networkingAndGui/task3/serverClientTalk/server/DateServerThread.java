package com.sirma.itt.javacourse.networkingAndGui.task3.serverClientTalk.server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Date;

import org.apache.log4j.Logger;

/**
 * Thread that accepts a Socket as its parameter so that it can send a message to it.
 * 
 * @author Simeon Iliev
 */
public class DateServerThread extends Thread {

	private static Logger log = Logger.getLogger(DateServerThread.class);

	private final Socket clientSocket;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		try (DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream())) {
			outputStream.writeUTF(new Date().toString());
			outputStream.flush();
			clientSocket.close();
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}

	}

	/**
	 * Basic constructor.
	 * 
	 * @param clientSocket
	 *            the socket to which we want to send the date.
	 */
	public DateServerThread(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}

}
