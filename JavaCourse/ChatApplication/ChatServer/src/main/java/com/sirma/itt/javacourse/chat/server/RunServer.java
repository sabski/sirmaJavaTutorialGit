package com.sirma.itt.javacourse.chat.server;

import com.sirma.itt.javacourse.chat.server.controler.ServerController;

/**
 * Runner class for server application.
 * 
 * @author Simon Iliev
 * 
 */
public class RunServer {

	/**
	 * Main method.
	 * 
	 * @param args
	 *            arguments for the main method.
	 */
	public static void main(String[] args) {

		new ServerController();

	}
}
