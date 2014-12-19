package com.sirma.itt.javacourse.networkingAndGui.task4.clientInformation.server;

import com.sirma.itt.javacourse.networkingAndGui.ServerUI;

/**
 * UI for the Information Server.
 * 
 * @author Simeon Iliev
 */
public class RunInformationServer {

	/**
	 * Main method.
	 * 
	 * @param args
	 *            arguments for the main method.
	 */
	public static void main(String[] args) {
		new ServerUI(new InformationServer());
	}

}
