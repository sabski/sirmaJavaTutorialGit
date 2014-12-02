/**
 * 
 */
package com.sirma.itt.javacourse.networkingAndGui.task6.transmiter.messagedispacher;

import java.net.InetAddress;

/**
 * @author siliev
 * 
 */
public interface MessageModerator {

	/**
	 * 
	 * @param address
	 */
	public void addChanell(InetAddress address);

	
	/**
	 * 
	 * @param message
	 */
	public void sendMessages(String message);
}
