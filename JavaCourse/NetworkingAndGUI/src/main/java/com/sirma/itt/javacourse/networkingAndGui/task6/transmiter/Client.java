/**
 * 
 */
package com.sirma.itt.javacourse.networkingAndGui.task6.transmiter;


/**
 * Client interface.
 * 
 * @author siliev
 * 
 */
public interface Client {

	public void sendMessage(String message);

	public String receiveMessage();

}
