package com.sirma.itt.javacourse.networkingAndGui;

import javax.swing.JTextArea;

/**
 * Abstract class for servers.
 * 
 * 
 * @author siliev
 * 
 */
public abstract class AbstractServer extends Thread {

	private JTextArea textArea;

	/**
	 * Start the server.
	 */
	public abstract void startServer();

	/**
	 * Stops the server and cleans up.
	 */
	public abstract void stopServer();

	/**
	 * Accepts incoming user connections. Adds the channel that was assigned to
	 * them to be broadcasted.
	 */
	public abstract void acceptConnections();

	/**
	 * Sends a message in the UI message area.
	 * 
	 * @param message
	 *            the message that is to written in the UI.
	 */
	public abstract void displayMessage(String message);

	/**
	 * @return the textArea
	 */
	public JTextArea getTextArea() {
		return textArea;
	}

	/**
	 * @param textArea
	 *            the textArea to set
	 */
	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

}
