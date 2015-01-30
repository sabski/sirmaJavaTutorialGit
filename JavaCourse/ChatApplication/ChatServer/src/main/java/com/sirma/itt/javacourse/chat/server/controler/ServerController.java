package com.sirma.itt.javacourse.chat.server.controler;

import com.sirma.itt.javacourse.chat.server.threads.MainServerThread;
import com.sirma.itt.javacourse.chat.server.ui.ServerWindow;

/**
 * Server controller to separate UI and back end.
 * 
 * @author Simon Iliev
 * 
 */
public class ServerController {

	private ServerWindow window;
	private MainServerThread mainThread;

	public ServerController() {
		window = new ServerWindow(this);
	}

	/**
	 * Starts the server on a specified port.
	 * 
	 * @param port
	 *            the port on which to start the server.
	 */
	public void startServer(int port) {
		mainThread = new MainServerThread(this, port);
		mainThread.start();
	}

	/**
	 * Stops the server thread.
	 */
	public void stopServer() {
		if (mainThread != null) {
			mainThread.stopServer();
		}
	}

	/**
	 * Relays a message to the UI.
	 * 
	 * @param message
	 *            the message to be displayed.
	 */
	public void displayMessage(String message) {
		window.displayMessage(message);
	}

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
