package com.sirma.itt.javacourse.chat.server.interfaces;

/**
 * Controller interface
 * 
 * 
 * @author Simon Iliev
 *
 */
public interface ServerSideController {

	/**
	 * Starts the server on a specified port.
	 * 
	 * @param port
	 *            the port on which to start the server.
	 */
	public void startServer(int port);

	/**
	 * Stops the server thread.
	 */
	public void stopServer();

	/**
	 * Relays a message to the UI.
	 * 
	 * @param message
	 *            the message to be displayed.
	 */
	public void displayMessage(String message);
}
