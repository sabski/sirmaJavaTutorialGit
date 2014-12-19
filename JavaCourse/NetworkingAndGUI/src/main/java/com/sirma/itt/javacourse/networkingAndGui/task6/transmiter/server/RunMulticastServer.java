/**
 * 
 */
package com.sirma.itt.javacourse.networkingAndGui.task6.transmiter.server;

import com.sirma.itt.javacourse.networkingAndGui.ServerUI;

/**
 * @author siliev
 * 
 */
public class RunMulticastServer {


	public static void main(String[] args) {

		new ServerUI(new MulticastServer());
	}

}
