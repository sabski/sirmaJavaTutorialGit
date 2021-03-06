package com.sirma.itt.javacourse.networkingAndGui.task3.serverClientTalk.server;

import com.sirma.itt.javacourse.networkingAndGui.ServerUI;

/**
 * Runner class for {@link DateServerGUI}.
 * 
 * @author Simeon Iliev
 */
public class RunServer {

	/**
	 * Main method.
	 * 
	 * @param args
	 *            arguments for the main method.
	 */
	public static void main(String[] args) {
		new ServerUI(new DateServer());
	}

}
