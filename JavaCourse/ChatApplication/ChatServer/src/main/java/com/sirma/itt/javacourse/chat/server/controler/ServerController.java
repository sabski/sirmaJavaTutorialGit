package com.sirma.itt.javacourse.chat.server.controler;

import com.sirma.itt.javacourse.chat.server.interfaces.ServerSideController;
import com.sirma.itt.javacourse.chat.server.threads.MainServerThread;
import com.sirma.itt.javacourse.chat.server.ui.ServerWindow;

/**
 * Server controller to separate UI and back end.
 * 
 * @author Simon Iliev
 * 
 */
public class ServerController implements ServerSideController {

	private ServerWindow window;
	private MainServerThread mainThread;

	public ServerController() {
		window = new ServerWindow(this);
	}

	@Override
	public void startServer(int port) {
		mainThread = new MainServerThread(this, port);
		mainThread.start();
	}

	@Override
	public void stopServer() {
		if (mainThread != null) {
			mainThread.stopServer();
		}
	}

	@Override
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
