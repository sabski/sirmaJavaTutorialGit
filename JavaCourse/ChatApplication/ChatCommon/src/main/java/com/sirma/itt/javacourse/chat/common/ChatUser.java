package com.sirma.itt.javacourse.chat.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import org.apache.log4j.Logger;

/**
 * This class represents the user of the application.
 * 
 * 
 * @author siliev
 * 
 */
public class ChatUser {

	private static final Logger LOGGER = Logger.getLogger(ChatUser.class);

	private String username;
	private Socket clientSocket;
	private OutputStream outputStream;
	private InputStream inputStream;

	/**
	 * @param username
	 *            the username of the user.
	 * @param clientSocket
	 *            the socket the client has been assigned to.
	 */
	public ChatUser(String username, Socket clientSocket) {
		this.username = username;
		this.clientSocket = clientSocket;
		try {
			this.outputStream = clientSocket.getOutputStream();
			this.inputStream = clientSocket.getInputStream();
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		}

	}

	/**
	 * @return the username of the user
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the clientSocket
	 */
	public Socket getClientSocket() {
		return clientSocket;
	}

	/**
	 * @param clientSocket
	 *            the clientSocket to set
	 */
	public void setClientSocket(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}

	/**
	 * @return the outputStream
	 */
	public OutputStream getOutputStream() {
		return outputStream;
	}

	/**
	 * @param outputStream
	 *            the outputStream to set
	 */
	public void setOutputStream(OutputStream outputStream) {
		this.outputStream = outputStream;
	}

	/**
	 * @return the inputStream
	 */
	public InputStream getInputStream() {
		return inputStream;
	}

	/**
	 * @param inputStream
	 *            the inputStream to set
	 */
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

}
