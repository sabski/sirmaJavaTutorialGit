package com.sirma.itt.javacourse.networkingAndGui.task6.transmiter.messagedispacher;

import java.net.InetAddress;

/**
 * @author siliev
 * 
 */
public abstract class AbstractMessageModerator extends Thread {

	/**
	 * Adds a new broadcast channel.
	 * 
	 * @param address
	 *            the {@link InetAddress} we want to add to the list.
	 */
	public abstract void addChanell(InetAddress address);

	/**
	 * Sends a message to all the broadcasting channels.
	 * 
	 * @param message
	 *            the message we want to sent.
	 */
	public abstract void sendMessages(String message);
}
