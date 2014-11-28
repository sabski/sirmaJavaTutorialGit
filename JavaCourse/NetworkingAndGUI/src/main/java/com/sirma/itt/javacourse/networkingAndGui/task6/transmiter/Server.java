/**
 * 
 */
package com.sirma.itt.javacourse.networkingAndGui.task6.transmiter;

/**
 * @author siliev
 *
 */
public interface Server {

	
	public void startServer();
	
	public void stopServer();
	
	public void acceptConnections();
	
	public void receiveMessages();
	
	public void sendMessages();
}
